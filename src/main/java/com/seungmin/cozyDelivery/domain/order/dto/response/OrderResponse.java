package com.seungmin.cozyDelivery.domain.order.dto.response;

import com.seungmin.cozyDelivery.domain.order.entity.Orders;
import lombok.Getter;

@Getter
public class OrderResponse {
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer productPrice;

    public OrderResponse(Long orderId, Long productId, String productName, Integer productPrice) {
        this.orderId = orderId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public static OrderResponse from(Orders orders) {
        return new OrderResponse(
                orders.getId(),
                orders.getProduct().getId(),
                orders.getProduct().getName(),
                orders.getProduct().getPrice()
        );
    }
}
