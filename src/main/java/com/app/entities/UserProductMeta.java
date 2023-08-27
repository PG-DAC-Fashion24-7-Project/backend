package com.app.entities;

import javax.persistence.*;

@Entity
@Table(name="userproductmeta")
public class UserProductMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="productMetaId")
    private Long productMetaId;
    @Column(name="userId")
    private Long userId;
    @Column(name="productId")
    private Long productId;
    @Column(name="productPrice")
    private double productPrice;
    @Column(name="productQuantity")
    private int productQuantity;


    @ManyToOne
    @JoinColumn(name = "user2")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product2")
    private Product product;
}
