package org.example.orderproject.supplies.service;

import org.example.orderproject.supplies.dto.SupplyDTO;

import java.util.List;

public interface SupplyService {
    List<SupplyDTO> supplyList();
    int supplyInsert(SupplyDTO supplyDTO);
}
