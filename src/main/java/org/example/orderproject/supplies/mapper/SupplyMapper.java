package org.example.orderproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.orderproject.dto.SupplyDTO;

import java.util.List;

@Mapper
public interface SupplyMapper {
    List<SupplyDTO> supplyList();
}
