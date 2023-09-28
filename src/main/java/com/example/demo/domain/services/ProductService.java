package com.example.demo.domain.services;

import com.example.demo.domain.entities.Product;
import com.example.demo.repository.entities.ProductEntity;
import com.example.demo.repository.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.save(mapProductToProductEntity(product));
    }

    public Optional<Product> getProductById(UUID id) {
        return productRepository.findById(id).map(this::mapProductEntityToProduct);
    }

    public void deleteProductById(UUID id) {
        productRepository.deleteById(id);
    }

    public void updateProduct(Product product) {
        productRepository.save(mapProductToProductEntity(product));
    }

    public Collection<Product> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapProductEntityToProduct).collect(Collectors.toList());
    }

    private Product mapProductEntityToProduct(ProductEntity productEntity) {
        return new Product(productEntity.getId(), productEntity.getName());
    }

    private ProductEntity mapProductToProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        return productEntity;
    }

}
