package se.chasacademy.databaser.jpaorders.dto;

import java.util.List;

public class CreateOrderRequest {


    public Long customerId;
    public List<OrderLineRequest> lines;

    public static class OrderLineRequest {
        public Long productId;
        public int quantity;
    }
}

