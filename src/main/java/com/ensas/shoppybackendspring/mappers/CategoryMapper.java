package com.ensas.shoppybackendspring.mappers;

import com.ensas.shoppybackendspring.dtos.CategoryDto;
import com.ensas.shoppybackendspring.entities.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryDtoToCategory(CategoryDto categoryDto);

    CategoryDto categoryToCategoryDto(Category category);
}
