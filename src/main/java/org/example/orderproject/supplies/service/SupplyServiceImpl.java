package org.example.orderproject.supplies.service;

import lombok.RequiredArgsConstructor;
import org.example.orderproject.supplies.dto.SupplyDTO;
import org.example.orderproject.supplies.mapper.SupplyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyServiceImpl implements SupplyService{
    private final SupplyMapper supplyMapper;

    @Override
    public List<SupplyDTO> supplyList() {
        return supplyMapper.supplyList();
    }

    @Override
    public int supplyInsert(SupplyDTO supplyDTO) {

        int count= supplyMapper.itemNameCheck(supplyDTO.getItemName());

        if(count > 0) {
            throw new IllegalArgumentException("이미 존재하는 비품입니다.");
        }

        return supplyMapper.supplyInsert(supplyDTO);
    }
}
