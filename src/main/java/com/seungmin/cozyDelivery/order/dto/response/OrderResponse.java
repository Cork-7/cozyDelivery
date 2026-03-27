package com.seungmin.cozyDelivery.order.dto.response;

import com.seungmin.cozyDelivery.order.entity.Order;
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

    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getProduct().getId(),
                order.getProduct().getName(),
                order.getProduct().getPrice()
        );
    }
}
