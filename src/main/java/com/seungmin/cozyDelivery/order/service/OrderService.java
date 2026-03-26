package com.seungmin.cozyDelivery.order.service;

import com.seungmin.cozyDelivery.order.dto.request.OrderCrateRequest;
import com.seungmin.cozyDelivery.order.dto.request.OrderRequest;
import com.seungmin.cozyDelivery.order.dto.response.OrderResponse;
import com.seungmin.cozyDelivery.order.entity.Order;
import com.seungmin.cozyDelivery.order.repository.OrderRepository;
import com.seungmin.cozyDelivery.product.entity.Product;
import com.seungmin.cozyDelivery.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    // 주문
    @Transactional
    public OrderResponse createOrder(OrderCrateRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()-> new IllegalArgumentException("해당 상품이 존재하지 않습니다"));

        Order order = new Order (
                product,
                request.getOrderQuantity()
        );

        Order createOrder = orderRepository.save(order);
        return new OrderResponse(
                createOrder.getId(),
                createOrder.getProduct().getId(),
                createOrder.getProduct().getName(),
                createOrder.getProduct().getPrice(),
                createOrder.getOrderQuantity()
        );
    }

    // 주문 조회
    @Transactional
    public OrderResponse getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new IllegalArgumentException("해당 주문이 존재하지 않습니다"));
        return new OrderResponse(
                order.getId(),
                order.getProduct().getId(),
                order.getProduct().getName(),
                order.getProduct().getPrice(),
                order.getOrderQuantity()
        );
    }
}
