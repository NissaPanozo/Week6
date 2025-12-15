package se.chasacademy.databaser.jpaorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.chasacademy.databaser.jpaorders.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
