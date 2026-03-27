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
                product
        );

        Order createOrder = orderRepository.save(order);
        return OrderResponse.from(createOrder);
    }

    // 주문 조회
    @Transactional
    public OrderResponse getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new IllegalArgumentException("해당 주문이 존재하지 않습니다"));
        return  OrderResponse.from(order);
    }
}
