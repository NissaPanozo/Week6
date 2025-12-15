package se.chasacademy.databaser.jpaorders.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "CUST_ID")
 private Long id;

 @Column(name = "CUST_FIRST_NAME", nullable = false, length = 100)
 private String firstName;

 @Column(name = "CUST_LAST_NAME", nullable = false, length = 100)
 private String lastName;

 @Column(name = "EMAIL_ADDR", nullable = false, unique = true, length = 200)
 private String email;

 // DEFAULT CURRENT_TIMESTAMP i DB: låt DB sätta värdet
 @Column(name = "CREATED_AT", nullable = false, insertable = false, updatable = false)
 private LocalDateTime createdAt;

 // getters/setters (ev. lombok @Getter/@Setter)
}
