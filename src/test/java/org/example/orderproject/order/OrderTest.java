package org.example.orderproject.order;

import lombok.extern.slf4j.Slf4j;
import org.example.orderproject.order.dto.OrderDTO;
import org.example.orderproject.order.mapper.OrderMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@MybatisTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderTest {

    @Autowired
    private OrderMapper orderMapper;

    private OrderDTO sampleOrder(Long id) {
        return OrderDTO.builder()
                .orderId(id)
                .employeeId("EMP-001")
                .itemId("SP-001")
                .requestQty(3)
                .build();
    }

    @Test
    @DisplayName("주문 1건을 저장한다")
    void save() {

        // given
        OrderDTO order = sampleOrder(1L);

        // when
        orderMapper.save(order);

        // then
        OrderDTO find = orderMapper.findById(order.getOrderId());
        assertThat(find.getOrderId()).isEqualTo(order.getOrderId());
    }

    @Test
    @DisplayName("모든 주문을 조회한다")
    void findAll() {

        // given
        orderMapper.save(sampleOrder(1L));
        orderMapper.save(sampleOrder(2L));

        // when
        List<OrderDTO> list = orderMapper.findAll();

        // then
        assertThat(list).hasSizeGreaterThanOrEqualTo(2);
    }

    @Test
    @DisplayName("주문 id로 단건을 조회한다")
    void findById() {

        // given
        OrderDTO saved = sampleOrder(10L);
        orderMapper.save(saved);

        // when
        OrderDTO found = orderMapper.findById(saved.getOrderId());

        //then
        assertNotNull(found);
        assertEquals(saved.getOrderId(), found.getOrderId());
        assertEquals("EMP-001", found.getEmployeeId());
        assertEquals("SP-001", found.getItemId());
        assertEquals(3, found.getRequestQty());
    }

    @Test
    @DisplayName("주문의 상태를 변경한다")
    void update() {

        // given
        OrderDTO saved = sampleOrder(15L);
        orderMapper.save(saved);

        // when
        saved.setStatus("지급 완료");
        orderMapper.update(saved);

        // then
        OrderDTO updated = orderMapper.findById(saved.getOrderId());
        assertEquals("지급 완료", updated.getStatus());
    }

    @Test
    @DisplayName("삭제 후 조회 결과는 null이어야 한다")
    void deleteById() {

        // given
        OrderDTO saved = sampleOrder(20L);
        orderMapper.save(saved);
        Long savedId = saved.getOrderId();

        // when
        orderMapper.deleteById(savedId);

        // then
        OrderDTO deleted = orderMapper.findById(savedId);
        Assertions.assertNull(deleted);
    }
}
