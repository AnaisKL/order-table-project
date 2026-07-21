package org.example.orderproject.order.service;

import org.example.orderproject.order.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> orderList();
    OrderDTO orderDetail(Long orderId);
    void orderInsert(OrderDTO orderDTO);
    void orderUpdate(OrderDTO orderDTO);
    void orderDelete(Long orderId);
}
