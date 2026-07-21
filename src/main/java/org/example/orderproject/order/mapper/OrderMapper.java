package org.example.orderproject.order.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.orderproject.order.dto.OrderDTO;

import java.util.List;

@Mapper
public interface OrderMapper {
    void save(OrderDTO order);

    OrderDTO findById(Long id);

    List<OrderDTO> findAll();

    void update(OrderDTO order);

    void deleteById(Long id);
}
