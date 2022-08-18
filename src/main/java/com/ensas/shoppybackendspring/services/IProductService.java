package com.ensas.shoppybackendspring.services;

import com.ensas.shoppybackendspring.dtos.ProductDto;
import com.ensas.shoppybackendspring.entities.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {

    List<ProductDto> getProductByKeyword(String keyword, int page, int size);

    List<ProductDto> getRandomProducts(int page, int size);

    ProductDto getProduct(Long id);

    List<ProductDto> pageToList(Page<Product> productPage, int page, int size);
}
