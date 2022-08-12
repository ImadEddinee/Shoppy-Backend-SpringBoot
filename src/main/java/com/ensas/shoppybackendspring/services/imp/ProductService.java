package com.ensas.shoppybackendspring.services.imp;

import com.ensas.shoppybackendspring.dtos.ProductDto;
import com.ensas.shoppybackendspring.mappers.ProductMapper;
import com.ensas.shoppybackendspring.repositories.ProductRepository;
import com.ensas.shoppybackendspring.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getAllProducts(){
        return productRepository.findAll().stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

}
