package com.seungmin.cozyDelivery.order.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderCrateRequest {
    private Long productId;
    private String productName;
    private Integer productPrice;
    private Integer orderQuantity;
}
