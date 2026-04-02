package com.seungmin.cozyDelivery.domain.order.entity;

import com.seungmin.cozyDelivery.domain.product.entity.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "order_quantity")
    private int orderQuantity;

    @Column(name = "order_price")
    private int orderPrice;

    public Orders(Product product, int orderQuantity, int orderPrice) {
        this.product = product;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }
}
