package com.seungmin.cozyDelivery.product.dto.response;

import com.seungmin.cozyDelivery.product.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponse {
    private Long id;
    private String productName;
    private Integer productPrice;

    public ProductResponse(Long id, String productName, Integer productPrice) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice());
    }
}
