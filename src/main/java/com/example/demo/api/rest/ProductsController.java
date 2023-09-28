package com.example.demo.api.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public interface ProductsController {
    @GetMapping
    Collection<ProductDto> getProducts();

    @PostMapping
    void createProduct(@RequestBody CreateProductDto productDto);

    @DeleteMapping(value = "/{id}")
    void deleteProduct(@PathVariable UUID id);

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    class ProductDto {
        private UUID id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class CreateProductDto {
        private String name;
    }
}
