package org.example.orderproject.supplies.service;

import org.example.orderproject.supplies.dto.SupplyDTO;

import java.util.List;

public interface SupplyService {
    List<SupplyDTO> supplyList();
    String createSupplyNo();
    int supplyInsert(SupplyDTO supplyDTO);
    boolean itemNameCheck(String itemName);
    SupplyDTO supplyDetail(String itemId);
}
