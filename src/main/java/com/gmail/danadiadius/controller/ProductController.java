package com.gmail.danadiadius.controller;

import com.gmail.danadiadius.model.Product;
import com.gmail.danadiadius.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing {@link Product} entities.
 * Provides endpoints for creating, retrieving, and managing products in the system.
 *
 * <p>This controller handles HTTP requests related to product operations and delegates
 * business logic to the underlying {@link ProductService}. All endpoints are prefixed
 * with "/products" as defined by the class-level {@link RequestMapping}.
 *
 * @author Dana Khromenko
 * @version 1.0
 * @since 2025
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProduct(id);
    }
}
