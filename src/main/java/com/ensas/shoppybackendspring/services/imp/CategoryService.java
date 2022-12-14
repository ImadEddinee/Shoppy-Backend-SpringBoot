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
import org.springframework.data.domain.Page;
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
    private final ProductService productService;



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
        Page<Product> productsPage = productRepository
                .findByCategoryId(id, PageRequest.of(page, size));
        return productService.pageToList(productsPage, page, size);
    }

    @Override
    public List<ProductDto> getByCategory(Long id, String keyword, int page, int size) {
        keyword = "%" + keyword + "%";
        categoryRepository.findById(id).orElseThrow(() ->
                new CategoryNotFoundException("Category with id: " + id + " does not exists"));
        Page<Product> productsPage = productRepository.searchByNameInCategoryId(keyword, id, PageRequest.of(page, size));
        return productService.pageToList(productsPage, page, size);
    }

}
