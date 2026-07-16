package org.example.orderproject.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyDTO {
    private String itemId; //비품 고유 번호(기본키)
    private String itemName; //비품명(케이블 타이, 벨크로 등)
    private String category; //분류(전선 정리용, 사무용품 등)
    private int stock; //재고 수량(기본값 = 0)
}
