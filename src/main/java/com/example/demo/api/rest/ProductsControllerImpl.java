package com.example.demo.api.rest;

import com.example.demo.IDGenerator;
import com.example.demo.domain.entities.Product;
import com.example.demo.domain.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ProductsControllerImpl implements ProductsController {

    private final ProductService productService;

    private final IDGenerator idGenerator;

    public ProductsControllerImpl(ProductService productService, IDGenerator idGenerator) {
        this.productService = productService;
        this.idGenerator = idGenerator;
    }

    @Override
    public Collection<ProductDto> getProducts() {
       return productService.getAllProducts().stream().map(this::mapProductToProductDto).toList();
    }

    @Override
    public void createProduct(CreateProductDto productDto) {
        productService.saveProduct(mapProductDtoToProduct(productDto));
    }

    @Override
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProductById(id);
    }

    private ProductDto mapProductToProductDto(Product product) {
        return new ProductDto(product.getId(), product.getName());
    }

    private Product mapProductDtoToProduct(CreateProductDto productDto) {
        return new Product(idGenerator.generateID(), productDto.getName());
    }
}
