package com.seungmin.cozyDelivery.domain.product.dto.response;

import com.seungmin.cozyDelivery.domain.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponse {
    private Long id;
    private String name;
    private Integer price;
    private Integer stockQuantity;

    public ProductResponse(Long id, String name, Integer price, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStockQuantity());
    }
}
