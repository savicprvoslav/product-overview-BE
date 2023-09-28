package com.example.demo.api.rest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.IDGenerator;
import com.example.demo.domain.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductsControllerImpl.class)
class ProductsControllerImplTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private IDGenerator idGenerator;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getProducts() throws Exception {
        when(productService.getAllProducts())
                .thenReturn(Mocks.PRODUCTS);

        mockMvc.perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(Mocks.PRODUCTS)))
                .andDo(print());
    }

    @Test
    void createProduct() throws Exception {
        when(idGenerator.generateID())
                .thenReturn(Mocks.PRODUCT_ID);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(Mocks.CREATE_PRODUCT_DTO)))
                .andExpect(status().isOk())
                .andDo(print());

        verify(productService).saveProduct(Mocks.PRODUCT);
    }

    @Test
    void deleteProduct() throws Exception {
        mockMvc.perform(delete("/products/{id}", Mocks.PRODUCT_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        verify(productService).deleteProductById(Mocks.PRODUCT_ID);
    }
}
