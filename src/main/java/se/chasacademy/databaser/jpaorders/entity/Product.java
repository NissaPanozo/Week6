package se.chasacademy.databaser.jpaorders.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "T_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROD_ID")
    private Long id;

    @Column(name = "PROD_NAME", nullable = false, length = 150)
    private String name;

    @Column(name = "PROD_DESC", length = 500)
    private String description;

    @Column(name = "UNIT_PRICE_CENTS", nullable = false)
    private Integer unitPriceCents;

    // CHAR(1) 'Y'/'N'
    @Column(name = "ACTIVE_FLAG", nullable = false, length = 1)
    private String activeFlag;

    // getters/setters
}

