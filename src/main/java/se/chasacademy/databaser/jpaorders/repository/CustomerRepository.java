package se.chasacademy.databaser.jpaorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.chasacademy.databaser.jpaorders.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
