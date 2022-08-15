package com.ensas.shoppybackendspring.services;

import com.ensas.shoppybackendspring.dtos.CategoryDto;
import com.ensas.shoppybackendspring.dtos.ProductDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryDto> getAllCategories();
    List<ProductDto> getProductsByCategory(Long id,int page,int size);

    List<ProductDto> getByCategory(Long id, String keyword, int page, int size);
}
