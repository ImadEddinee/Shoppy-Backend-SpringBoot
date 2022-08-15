package com.ensas.shoppybackendspring.controller;

import com.ensas.shoppybackendspring.dtos.ProductDto;
import com.ensas.shoppybackendspring.services.imp.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private final ProductService productService;
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") Long id){
        return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ProductDto>> getRandomProducts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size){
        List<ProductDto> productDtos = productService.getRandomProducts(page, size);
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductDto>> getProductsByKeyword(
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size){
        List<ProductDto> products = productService.getProductByKeyword(keyword, page, size);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
