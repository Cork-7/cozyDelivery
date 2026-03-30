package com.seungmin.cozyDelivery.domain.product.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductSaveRequest {
    private String productName;
    private int productPrice;
}
