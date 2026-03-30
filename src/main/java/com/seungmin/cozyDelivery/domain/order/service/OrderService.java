package com.seungmin.cozyDelivery.domain.order.service;

import com.seungmin.cozyDelivery.domain.order.dto.request.OrderCrateRequest;
import com.seungmin.cozyDelivery.domain.order.dto.response.OrderResponse;
import com.seungmin.cozyDelivery.domain.order.entity.Orders;
import com.seungmin.cozyDelivery.domain.order.repository.OrderRepository;
import com.seungmin.cozyDelivery.domain.product.entity.Product;
import com.seungmin.cozyDelivery.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

        Orders orders = new Orders(
                product
        );

        Orders createOrders = orderRepository.save(orders);
        return OrderResponse.from(createOrders);
    }

    // 주문 조회
    @Transactional (readOnly = true)
    public OrderResponse getOrder(Long orderId) {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(()-> new IllegalArgumentException("해당 주문이 존재하지 않습니다"));
        return  OrderResponse.from(orders);
    }

    // 주문 전체조회 (페이징)
    @Transactional (readOnly = true)
    public Page<OrderResponse> getOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"id"));
        Page<Orders> ordersPage = orderRepository.findAll(pageable);
        return ordersPage.map(OrderResponse::from);
    }

    // 주문한 제품 이름으로 조회(페이징)
    @Transactional (readOnly = true)
    public Page<OrderResponse> getOrdersByProductName(String productName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"id"));
        Page<Orders> ordersPage = orderRepository.findByProductName(productName, pageable);
        return ordersPage.map(OrderResponse::from);
    }
}
