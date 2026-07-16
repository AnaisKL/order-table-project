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
    public String createSupplyNo() {
        String supplyNo= supplyMapper.selectLastItemId();

        if(supplyNo == null){
            return "SP-001";
        }

        int number= Integer.parseInt(supplyNo.substring(3));

        return String.format("SP-%03d", number + 1);

    }

    @Override
    public boolean itemNameCheck(String itemName) {
        int count= supplyMapper.itemNameCheck(itemName);

        return count == 0;
    }

    @Override
    public int supplyInsert(SupplyDTO supplyDTO) {

        int count= supplyMapper.itemNameCheck(supplyDTO.getItemName());

        if(count > 0) {
            throw new IllegalArgumentException("이미 존재하는 비품입니다.");
        }

        return supplyMapper.supplyInsert(supplyDTO);
    }

    @Override
    public SupplyDTO supplyDetail(String itemId) {
        return supplyMapper.supplyDetail(itemId);
    }
}
