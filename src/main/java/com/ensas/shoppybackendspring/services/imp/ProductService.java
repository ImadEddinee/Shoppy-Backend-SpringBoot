package com.ensas.shoppybackendspring.services.imp;

import com.ensas.shoppybackendspring.dtos.ProductDto;
import com.ensas.shoppybackendspring.entities.Product;
import com.ensas.shoppybackendspring.exceptions.ProductNotFoundException;
import com.ensas.shoppybackendspring.mappers.ProductMapper;
import com.ensas.shoppybackendspring.repositories.ProductRepository;
import com.ensas.shoppybackendspring.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDto> getProductByKeyword(String keyword, int page, int size) {
        keyword = "%" + keyword + "%";
        Page<Product> productsPage = productRepository
                .searchInRandomProducts(keyword, PageRequest.of(page, size));
        return pageToList(productsPage,page,size);
    }

    @Override
    public List<ProductDto> getRandomProducts(int page, int size) {
        Page<Product> productsPage = productRepository.getRandomProducts(PageRequest.of(page, size));
        return pageToList(productsPage,page,size);
    }

    @Override
    public ProductDto getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("there is no product with id = " + id));
        return productMapper.productToProductDto(product);
    }
    @Override
    public List<ProductDto> pageToList(Page<Product> productPage, int page, int size){
        List<ProductDto> productDtos = productPage.getContent().stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
        productDtos.forEach(productDto -> {
            productDto.setCurrentPage(page);
            productDto.setPageSize(size);
            productDto.setTotalPages(productPage.getTotalPages());
            productDto.setTotalElements(productPage.getTotalElements());
        });
        return productDtos;
    }
}
