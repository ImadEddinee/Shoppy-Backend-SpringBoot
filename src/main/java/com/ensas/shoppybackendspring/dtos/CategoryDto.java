package com.ensas.shoppybackendspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data @NoArgsConstructor @AllArgsConstructor
public class CategoryDto {

    private Long id;

    @NotBlank ( message // TODO add validators
            = "About Me must be between 10 and 200 characters")
    private String name;
}
