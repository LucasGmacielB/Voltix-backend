package com.voltix.backend.dto.auth;

import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;

    private String description;

    private BigDecimal price;

    private int stock;

    private String imgUrl;
}
