package com.ensas.shoppybackendspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDto { //TODO use builder

    private Long id;
    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private boolean active;
    private int unitsInStock;
}
