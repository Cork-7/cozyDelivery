package com.seungmin.cozyDelivery.order.repository;

import com.seungmin.cozyDelivery.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
