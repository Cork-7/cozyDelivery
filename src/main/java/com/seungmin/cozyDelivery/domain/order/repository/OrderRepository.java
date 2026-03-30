package com.seungmin.cozyDelivery.domain.order.repository;

import com.seungmin.cozyDelivery.domain.order.entity.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    @EntityGraph(attributePaths = "product")
    @Query("select o from Orders o")
    Page<Orders> findAll( Pageable pageable);

    Page<Orders> findByProductName(String  productName, Pageable pageable);
}
