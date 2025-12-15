package se.chasacademy.databaser.jpaorders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.chasacademy.databaser.jpaorders.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
