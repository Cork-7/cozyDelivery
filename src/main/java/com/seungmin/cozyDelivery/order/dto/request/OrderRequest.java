package com.seungmin.cozyDelivery.order.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderRequest {
    private Long productId;
    private Long orderId;
    private String productName;
    private Integer productPrice;
    private Integer orderQuantity;
}
