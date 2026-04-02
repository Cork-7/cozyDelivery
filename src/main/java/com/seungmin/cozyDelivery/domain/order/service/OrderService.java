package com.seungmin.cozyDelivery.domain.order.service;

import com.seungmin.cozyDelivery.domain.order.dto.request.OrderRequest;
import com.seungmin.cozyDelivery.domain.order.dto.response.OrderResponse;
import com.seungmin.cozyDelivery.domain.order.entity.Orders;
import com.seungmin.cozyDelivery.domain.order.repository.OrderRepository;
import com.seungmin.cozyDelivery.domain.product.entity.Product;
import com.seungmin.cozyDelivery.domain.product.repository.ProductRepository;
import com.seungmin.cozyDelivery.global.error.ProductErrorCode;
import com.seungmin.cozyDelivery.global.exception.OrderException;
import com.seungmin.cozyDelivery.global.error.OrderErrorCode;
import com.seungmin.cozyDelivery.global.exception.ProductException;
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
    public OrderResponse createOrder(OrderRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()-> new ProductException(ProductErrorCode.NOT_FOUND_PRODUCT));

        productRepository.findByIdWithPessimisticLock(request.getProductId())
                .orElseThrow(()-> new OrderException(OrderErrorCode.PURCHASE_NOT_AVAILABLE));


        product.decreaseStock(request.getOrderQuantity());
        int orderPrice = product.getPrice();

        Orders orders = new Orders(
                product,
                request.getOrderQuantity(),
                orderPrice
        );

        Orders createOrders = orderRepository.save(orders);
        return OrderResponse.from(createOrders);
    }

    // 주문 조회
    @Transactional (readOnly = true)
    public OrderResponse getOrder(Long orderId) {
        Orders orders = orderRepository.findById(orderId)
                .orElseThrow(()-> new OrderException(OrderErrorCode.NOT_FOUND_ORDER));
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
