package org.example.orderproject.supplies.controller;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.example.orderproject.supplies.dto.SupplyDTO;
import org.example.orderproject.supplies.service.SupplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
     public String insertForm(Model model){
          String itemId= supplyService.createSupplyNo();
          model.addAttribute("itemId", itemId);
          return "supply/supplyCreate";
     }

     @GetMapping("/itemNameCheck")
     @ResponseBody
     public boolean itemNameCheck(String itemName){
          return supplyService.itemNameCheck(itemName);
     }

     @PostMapping("/insert")
     public String supplyInsert(SupplyDTO supplyDTO){
          supplyService.supplyInsert(supplyDTO);
          return "redirect:/supplies/list?message=insert";
     }

     @GetMapping("/{itemId}")
     public String detail(@PathVariable String itemId, Model model){
          SupplyDTO supplyDTO= supplyService.supplyDetail(itemId);
          model.addAttribute("supply", supplyDTO);

          return "supply/supplyDetail";
     }

     @GetMapping("/{itemId}/edit")
     public String editForm(@PathVariable String itemId, Model model){
          SupplyDTO supplyDTO= supplyService.supplyDetail(itemId);

          model.addAttribute("supply", supplyDTO);

          return "supply/supplyEdit";
     }

     @PostMapping("/{itemId}")
     public String supplyUpdate(SupplyDTO supplyDTO){
          supplyService.supplyUpdate(supplyDTO);
          return "redirect:/supplies/list?message=update";
     }

     @PostMapping("/{itemId}/delete")
     public String supplyDelete(@PathVariable String itemId){
          supplyService.supplyDelete(itemId);
          return "redirect:/supplies/list?message=delete";
     }

}
