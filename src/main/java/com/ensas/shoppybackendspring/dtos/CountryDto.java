package com.ensas.shoppybackendspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CountryDto {

    private Long id;
    private String code;
    private String name;
}
