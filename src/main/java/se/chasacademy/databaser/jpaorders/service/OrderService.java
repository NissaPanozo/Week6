package se.chasacademy.databaser.jpaorders.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.chasacademy.databaser.jpaorders.dto.CreateOrderRequest;
import se.chasacademy.databaser.jpaorders.entity.Customer;
import se.chasacademy.databaser.jpaorders.entity.OrderEntity;
import se.chasacademy.databaser.jpaorders.entity.OrderLine;
import se.chasacademy.databaser.jpaorders.entity.Product;
import se.chasacademy.databaser.jpaorders.repository.CustomerRepository;
import se.chasacademy.databaser.jpaorders.repository.OrderRepository;
import se.chasacademy.databaser.jpaorders.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;

    public OrderService(CustomerRepository customerRepo,
                        ProductRepository productRepo,
                        OrderRepository orderRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    @Transactional
    public OrderEntity createOrder(CreateOrderRequest req) {

        Customer customer = customerRepo.findById(req.customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        OrderEntity order = new OrderEntity(customer);

        List<OrderLine> lines = new ArrayList<>();

        for (CreateOrderRequest.OrderLineRequest lineReq : req.lines) {
            Product product = productRepo.findById(lineReq.productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            lines.add(new OrderLine(order, product, lineReq.quantity));
        }

        order.setOrderLines(lines);
        return orderRepo.save(order);
    }
}

