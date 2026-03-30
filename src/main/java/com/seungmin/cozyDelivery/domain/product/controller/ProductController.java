package com.seungmin.cozyDelivery.domain.product.controller;

import com.seungmin.cozyDelivery.domain.product.dto.request.ProductSaveRequest;
import com.seungmin.cozyDelivery.domain.product.dto.request.ProductUpdateRequest;
import com.seungmin.cozyDelivery.domain.product.dto.response.ProductResponse;
import com.seungmin.cozyDelivery.domain.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

        private final ProductService productService;

        // 상품 등록
        @Operation(summary = "상품 등록")
        @PostMapping()
        public ResponseEntity<ProductResponse> register(@RequestBody ProductSaveRequest request){
                ProductResponse response = productService.saveProduct(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        // 상품 수정
        @Operation(summary = "상품 수정")
        @PutMapping("/{id}")
        public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductUpdateRequest request){
                ProductResponse response = productService.updateProduct(id,request);
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        // 상품 단일 조회
        @Operation(summary = "상품 단일 조회")
        @GetMapping("/{id}")
        public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
                ProductResponse response = productService.searchProduct(id);
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        // 상품 전제 초회
        @Operation(summary = "상풍 전체 조회")
        @GetMapping
        public ResponseEntity<List<ProductResponse>> getAllProducts(){
                List<ProductResponse> response = productService.searchProducts();
                return ResponseEntity.status(HttpStatus.OK).body(response);
        }

        // 상품 삭제
        @Operation(summary = "상품 삭제")
        @DeleteMapping("/{id}")
        public ResponseEntity<ProductResponse> deleteProduct(@PathVariable Long id){
                productService.deleteProduct(id);
                return ResponseEntity.noContent().build();
        }
}
