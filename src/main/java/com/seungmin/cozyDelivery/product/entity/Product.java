package com.seungmin.cozyDelivery.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// JPA는 Reflection API를 사용해 동적으로 엔티티 객체를 생성해야해서 필요함
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void updateProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
