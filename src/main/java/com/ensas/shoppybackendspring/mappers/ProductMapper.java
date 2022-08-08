package com.ensas.shoppybackendspring.mappers;

import com.ensas.shoppybackendspring.dtos.ProductDto;
import com.ensas.shoppybackendspring.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productDtoToProduct(ProductDto productDto);
    ProductDto productToProductDto(Product product);

    List<ProductDto> productsToProductDtos(List<Product> products);
}
