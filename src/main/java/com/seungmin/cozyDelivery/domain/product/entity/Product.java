package com.seungmin.cozyDelivery.domain.product.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
// JPA는 Reflection API를 사용해 동적으로 엔티티 객체를 생성해야해서 필요함
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    @Column(name = "stock_quantity")
    private int stockQuantity;

    public Product(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void updateProduct(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void decreaseStock(int orderQuantity) {
        valOrderQuantity(orderQuantity);
        valStock(orderQuantity);
        this.stockQuantity -= orderQuantity;
    }

    private void valOrderQuantity(int orderQuantity) {
        if (orderQuantity <= 0) {
            throw new IllegalArgumentException("주문 수량은 1개 이상이여야 합니다.");
        }
    }

    private void valStock(int orderQuantity) {
        if(this.stockQuantity < orderQuantity) {
            throw new IllegalArgumentException("재고가 부족합니다.");
        }
    }
}
