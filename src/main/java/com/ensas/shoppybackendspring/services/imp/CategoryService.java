package com.ensas.shoppybackendspring.services.imp;

import com.ensas.shoppybackendspring.dtos.CategoryDto;
import com.ensas.shoppybackendspring.dtos.ProductDto;
import com.ensas.shoppybackendspring.entities.Product;
import com.ensas.shoppybackendspring.exceptions.CategoryNotFoundException;
import com.ensas.shoppybackendspring.mappers.CategoryMapper;
import com.ensas.shoppybackendspring.mappers.ProductMapper;
import com.ensas.shoppybackendspring.repositories.CategoryRepository;
import com.ensas.shoppybackendspring.repositories.ProductRepository;
import com.ensas.shoppybackendspring.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryMapper categoryMapper;
    private final ProductMapper productMapper;



    @Override
    public List<CategoryDto> getAllCategories(){
        return categoryRepository.findAll().stream()
                .map(categoryMapper::categoryToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductsByCategory(Long id, int page, int size) {
        // Check if Category exists
        categoryRepository.findById(id).orElseThrow(()->
                new CategoryNotFoundException("Category with id: "+id+" does not exists"));
        List<Product> products = productRepository
                .findByCategoryId(id, PageRequest.of(page, size))
                .getContent();
        return products.stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

}
