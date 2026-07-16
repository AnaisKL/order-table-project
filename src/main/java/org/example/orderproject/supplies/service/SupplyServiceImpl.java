package org.example.orderproject.service;

import lombok.RequiredArgsConstructor;
import org.example.orderproject.dto.SupplyDTO;
import org.example.orderproject.mapper.SupplyMapper;
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
}
