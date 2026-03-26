package com.seungmin.cozyDelivery.product.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSaveRequest {
    private String productName;
    private int productPrice;
    private int productQuantity;
}
