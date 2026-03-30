package com.seungmin.cozyDelivery.domain.order.controller;

import com.seungmin.cozyDelivery.domain.order.dto.request.OrderRequest;
import com.seungmin.cozyDelivery.domain.order.dto.response.OrderResponse;
import com.seungmin.cozyDelivery.domain.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "주문")
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "주문 단일 조회")
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        OrderResponse response = orderService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(summary = "주문 페이지네이션")
    @GetMapping
    public ResponseEntity<PagedModel<OrderResponse>> getOrders(
            @RequestParam Integer page,
            @RequestParam Integer size) {
        Page<OrderResponse> orders = orderService.getOrders(page, size);
        return ResponseEntity.ok(new PagedModel(orders));
    }

    @Operation(summary = "주문한 제품 페이징")
    @GetMapping("/search")
    public ResponseEntity<PagedModel<OrderResponse>> getOrdersByProductName(
            @RequestParam String productName,
            @RequestParam Integer page,
            @RequestParam Integer size) {
        Page<OrderResponse> orders = orderService.getOrdersByProductName(productName, page, size);
        return ResponseEntity.ok(new PagedModel(orders));
    }

}
