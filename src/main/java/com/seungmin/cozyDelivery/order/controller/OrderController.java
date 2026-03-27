package com.seungmin.cozyDelivery.order.controller;

import com.seungmin.cozyDelivery.order.dto.request.OrderCrateRequest;
import com.seungmin.cozyDelivery.order.dto.response.OrderResponse;
import com.seungmin.cozyDelivery.order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderCrateRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "주문 단일 조회")
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        OrderResponse response = orderService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
