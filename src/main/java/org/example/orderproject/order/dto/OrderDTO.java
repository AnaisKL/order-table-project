package org.example.orderproject.order.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long orderId;
    private String employeeId;
    private String itemId;
    private Integer requestQty;
    private LocalDateTime orderDate;
    private String status;
}
