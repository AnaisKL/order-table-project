package org.example.orderproject.order.controller;

import lombok.RequiredArgsConstructor;
import org.example.orderproject.order.dto.OrderDTO;
import org.example.orderproject.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("orderList", orderService.orderList());
        return "order/orderRead";
    }

    @GetMapping("/insert")
    public String insertForm() {
        return "order/orderCreate";
    }

    @PostMapping("/insert")
    public String orderInsert(OrderDTO orderDTO) {
        orderService.orderInsert(orderDTO);
        return "redirect:/orders/list?message=insert";
    }

    @GetMapping("/{orderId}")
    public String detail(@PathVariable Long orderId, Model model) {
        model.addAttribute("order", orderService.orderDetail(orderId));
        return "order/orderDetail";
    }

    @GetMapping("/{orderId}/edit")
    public String editForm(@PathVariable Long orderId, Model model) {
        model.addAttribute("order", orderService.orderDetail(orderId));
        return "order/orderEdit";
    }

    @PostMapping("/{orderId}")
    public String orderUpdate(OrderDTO orderDTO) {
        orderService.orderUpdate(orderDTO);
        return "redirect:/orders/list?message=update";
    }

    @PostMapping("/{orderId}/delete")
    public String orderDelete(@PathVariable Long orderId) {
        orderService.orderDelete(orderId);
        return "redirect:/orders/list?message=delete";
    }
}
