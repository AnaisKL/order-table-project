package org.example.orderproject.supplies.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.orderproject.supplies.dto.SupplyDTO;

import java.util.List;

@Mapper
public interface SupplyMapper {
    List<SupplyDTO> supplyList();
    int itemNameCheck(@Param("itemName") String itemName);
    int supplyInsert(SupplyDTO supplyDTO);
}
