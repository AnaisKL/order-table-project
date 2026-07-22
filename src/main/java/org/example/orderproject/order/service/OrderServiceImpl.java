package org.example.orderproject.order.service;

import lombok.RequiredArgsConstructor;
import org.example.orderproject.order.dto.OrderDTO;
import org.example.orderproject.order.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;

    @Override
    public List<OrderDTO> orderList() {
        return orderMapper.findAll();
    }

    @Override
    public OrderDTO orderDetail(Long orderId) {
        return orderMapper.findById(orderId);
    }

    @Override
    public void orderInsert(OrderDTO orderDTO) {
        orderMapper.save(orderDTO);
    }

    @Override
    public void orderUpdate(OrderDTO orderDTO) {
        orderMapper.update(orderDTO);
    }

    @Override
    public void orderDelete(Long orderId) {
        orderMapper.deleteById(orderId);
    }
}
