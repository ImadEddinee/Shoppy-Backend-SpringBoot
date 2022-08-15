package com.ensas.shoppybackendspring.controller;

import com.ensas.shoppybackendspring.dtos.CategoryDto;
import com.ensas.shoppybackendspring.dtos.ProductDto;
import com.ensas.shoppybackendspring.services.imp.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
@CrossOrigin("http://localhost:4200")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping // TODO use Page instead
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
    @GetMapping("/{id}/products")
    public ResponseEntity<List<ProductDto>> getProductsByCategory(
            @PathVariable("id") Long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size){
        return new ResponseEntity<>(categoryService.getProductsByCategory(id,page,size), HttpStatus.OK);
    }
    @GetMapping("/{id}/products/search")
    public ResponseEntity<List<ProductDto>> searchInProductsByCategory(
            @PathVariable("id") Long id,
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size){
            List<ProductDto> products = categoryService.getByCategory(id,keyword,page,size);
            return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
