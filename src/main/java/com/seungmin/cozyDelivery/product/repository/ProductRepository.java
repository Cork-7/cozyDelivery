package com.seungmin.cozyDelivery.product.repository;

import com.seungmin.cozyDelivery.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
