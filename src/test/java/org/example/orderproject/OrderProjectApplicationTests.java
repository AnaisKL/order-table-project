package org.example.orderproject;

import lombok.extern.slf4j.Slf4j;
import org.example.orderproject.supplies.dto.SupplyDTO;
import org.example.orderproject.supplies.mapper.SupplyMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Slf4j
class OrderProjectApplicationTests {
    @Autowired
    private SupplyMapper supplyMapper;

    @Test
    public void supplyListTest(){
        supplyMapper.supplyList().forEach(supplyDTO -> log.info(supplyDTO.toString()));
    }

    @Test
    public void itemNameCheckTest(){
        int count= supplyMapper.itemNameCheck("케이블 타이");

        log.info("중복 개수: {}", count);
    }

    @Test
    public void supplyInsertTest(){

        SupplyDTO dto= SupplyDTO.builder()
                .itemId("A2345")
                .itemName("케이블 타이")
                .category("전선 정리용")
                .build();

        int result= supplyMapper.supplyInsert(dto);

        log.info("등록 결과: {}", result);
    }

}
