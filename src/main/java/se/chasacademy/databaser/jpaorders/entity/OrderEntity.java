package se.chasacademy.databaser.jpaorders.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "ORDER_NUMBER", nullable = false, unique = true, length = 50)
    private String orderNumber;

    @Column(name = "ORDER_DATE", nullable = false)
    private LocalDate orderDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CUSTOMER_ID", nullable = false) // FK -> T_CUSTOMER(CUST_ID)
    private Customer customer;

    @Column(name = "STATUS_CODE", nullable = false, length = 20)
    private String statusCode;

    // getters/setters
}

