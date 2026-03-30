package com.seungmin.cozyDelivery.domain.product.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSaveRequest {
    private String name;
    private int price;
    private int stockQuantity;
}
