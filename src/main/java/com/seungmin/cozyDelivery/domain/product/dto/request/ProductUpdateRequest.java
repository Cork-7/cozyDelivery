package com.seungmin.cozyDelivery.domain.product.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductUpdateRequest {
    private String productName;
    private Integer productPrice;
}
