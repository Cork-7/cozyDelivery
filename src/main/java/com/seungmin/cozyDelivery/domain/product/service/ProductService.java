package com.seungmin.cozyDelivery.domain.product.service;

import com.seungmin.cozyDelivery.domain.product.dto.request.ProductUpdateRequest;
import com.seungmin.cozyDelivery.domain.product.entity.Product;
import com.seungmin.cozyDelivery.domain.product.repository.ProductRepository;
import com.seungmin.cozyDelivery.domain.product.dto.request.ProductSaveRequest;
import com.seungmin.cozyDelivery.domain.product.dto.response.ProductResponse;
import com.seungmin.cozyDelivery.global.error.ProductErrorCode;
import com.seungmin.cozyDelivery.global.exception.ProductException;
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
                request.getName(),
                request.getPrice(),
                request.getStockQuantity()
        );
        Product saveProduct = productRepository.save(product);
        return ProductResponse.from(saveProduct);
    }

    // 상품 수정
    @Transactional
    public ProductResponse updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT));

        product.updateProduct(
                request.getName(),
                request.getPrice(),
                request.getStockQuantity()
        );
        productRepository.save(product);

        return ProductResponse.from(product);
    }

    // 상품 단건 조회
    @Transactional(readOnly = true)
    public ProductResponse searchProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT));

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
                .orElseThrow(()-> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT));

        productRepository.delete(product);
    }
}
