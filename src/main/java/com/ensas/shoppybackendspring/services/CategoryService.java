package com.ensas.shoppybackendspring.services;

import com.ensas.shoppybackendspring.dtos.CategoryDto;
import com.ensas.shoppybackendspring.mappers.CategoryMapper;
import com.ensas.shoppybackendspring.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDto> getAllCategories(){
        return categoryMapper.
                categoriesToCategoryDtos(categoryRepository.findAll());
    }

}
