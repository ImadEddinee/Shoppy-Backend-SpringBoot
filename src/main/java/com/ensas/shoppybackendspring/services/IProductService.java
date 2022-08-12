package com.ensas.shoppybackendspring.services;

import com.ensas.shoppybackendspring.dtos.ProductDto;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();
}
