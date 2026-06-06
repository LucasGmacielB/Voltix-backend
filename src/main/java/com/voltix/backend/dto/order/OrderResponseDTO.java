package com.voltix.backend.dto.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {
    private Long id;
    private BigDecimal total;
    private String status;
    private String createdAt;
    private List<OrderItemResponseDTO> items;
}
