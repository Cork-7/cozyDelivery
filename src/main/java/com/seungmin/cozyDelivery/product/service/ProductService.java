package com.seungmin.cozyDelivery.product.service;

import com.seungmin.cozyDelivery.product.dto.request.ProductUpdateRequest;
import com.seungmin.cozyDelivery.product.entity.Product;
import com.seungmin.cozyDelivery.product.repository.ProductRepository;
import com.seungmin.cozyDelivery.product.dto.request.ProductSaveRequest;
import com.seungmin.cozyDelivery.product.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    // 상품 등록
    @Transactional
    public ProductResponse saveProduct(ProductSaveRequest request) {
        Product product = new Product(
                request.getProductName(),
                request.getProductPrice()
        );
        Product saveProduct = productRepository.save(product);
        return ProductResponse.from(saveProduct);
    }

    // 상품 수정
    @Transactional
    public ProductResponse updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 상품이 없습니다"));

        product.updateProduct(
                request.getProductName(),
                request.getProductPrice()
        );
        productRepository.save(product);

        return ProductResponse.from(product);
    }

    // 상품 단건 조회
    @Transactional(readOnly = true)
    public ProductResponse searchProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 상품이 없습니다"));

        return ProductResponse.from(product);
    }

    // 상품 전체 조회
    @Transactional(readOnly = true)
    public List<ProductResponse> searchProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(ProductResponse::from)
                .toList();
    }

    // 상품 삭제
    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 상품이 없습니다"));

        productRepository.delete(product);
    }
}
