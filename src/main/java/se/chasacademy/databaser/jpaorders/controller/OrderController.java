package se.chasacademy.databaser.jpaorders.controller;


import se.chasacademy.databaser.jpaorders.dto.CreateOrderRequest;
import se.chasacademy.databaser.jpaorders.entity.OrderEntity;
import se.chasacademy.databaser.jpaorders.repository.OrderRepository;
import se.chasacademy.databaser.jpaorders.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepo;

    public OrderController(OrderService orderService, OrderRepository orderRepo) {
        this.orderService = orderService;
        this.orderRepo = orderRepo;
    }

    @PostMapping
    public OrderEntity create(@RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }
}