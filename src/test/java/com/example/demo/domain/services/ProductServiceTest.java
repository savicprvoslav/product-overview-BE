package com.example.demo.domain.services;

import com.example.demo.api.rest.Mocks;
import com.example.demo.repository.repositories.ProductRepository;
import org.aspectj.weaver.patterns.IVerificationRequired;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {


    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    void saveProduct() {
        productService.saveProduct(Mocks.PRODUCT);

        Mockito.verify(productRepository)
                .save(Mocks.PRODUCT_ENTITY);
    }

    @Test
    void getProductById() {
    }

    @Test
    void deleteProductById() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void getAllProducts() {
    }
}
