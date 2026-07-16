package org.example.orderproject.supplies.controller;

import lombok.RequiredArgsConstructor;
import org.example.orderproject.supplies.dto.SupplyDTO;
import org.example.orderproject.supplies.service.SupplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplies")
@RequiredArgsConstructor
public class SupplyController {
     private final SupplyService supplyService;

     @GetMapping("/list")
     public String list(Model model){
          model.addAttribute("supplyList", supplyService.supplyList());
          return "supply/supplyRead";
     }

     @GetMapping("/insert")
     public String insertForm(){
          return "supply/supplyCreate";
     }

     @PostMapping("/insert")
     public String supplyInsert(SupplyDTO supplyDTO){
          supplyService.supplyInsert(supplyDTO);
          return "redirect:/supplies/list";
     }
}
