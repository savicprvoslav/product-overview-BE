package com.example.demo.api.rest;

import com.example.demo.api.rest.ProductsController.ProductDto;
import com.example.demo.api.rest.ProjectController.ProjectDto;
import com.example.demo.domain.entities.Product;
import com.example.demo.domain.entities.Project;
import com.example.demo.domain.services.ProjectService.CreateProjectRequest;
import com.example.demo.repository.entities.ProductEntity;

import java.util.*;

public class Mocks {

    public static UUID PRODUCT_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    public static final String PRODUCT_NAME = "Product Name";
    public static Product PRODUCT = new Product(PRODUCT_ID, PRODUCT_NAME);
    public static Collection<Product> PRODUCTS = List.of(PRODUCT);

    public static ProductDto PRODUCT_DTO = new ProductDto(PRODUCT_ID, PRODUCT_NAME);

    public static Collection<ProductDto> PRODUCTS_DTOs = List.of(PRODUCT_DTO);

    public static ProductsController.CreateProductDto CREATE_PRODUCT_DTO = new ProductsController.CreateProductDto("Product Name");

    public static UUID PROJECT_ID = UUID.fromString("00000000-0000-0000-0000-000000000001");

    public static ProjectDto PROJECT_DTO = new ProjectDto(PROJECT_ID, "Project Name", "Project Description", 0);

    public static Collection<ProjectDto> PROJECT_DTOs = List.of(PROJECT_DTO);

    public static Project PROJECT = new Project(PROJECT_ID, "Project Name", "Project Description", 0, PRODUCT_ID);

    public static Collection<Project> PROJECTS_WITH_COUNTS = List.of(PROJECT);

    public static ProjectController.CreateProjectDto CREATE_PROJECT_DTO = new ProjectController.CreateProjectDto("Project Name", "Project Description");

    public static CreateProjectRequest CREATE_PROJECT_REQUEST = new CreateProjectRequest("Project Name", "Project Description", PRODUCT_ID);

    public static ProductEntity PRODUCT_ENTITY = new ProductEntity(PRODUCT_ID,PRODUCT_NAME);
}
