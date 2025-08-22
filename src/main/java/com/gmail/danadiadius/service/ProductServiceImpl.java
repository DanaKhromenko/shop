package com.gmail.danadiadius.service;

import com.gmail.danadiadius.model.Product;
import com.gmail.danadiadius.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link ProductService} interface providing concrete
 * business logic for product management operations.
 *
 * <p>This service handles CRUD operations for products and additionally
 * publishes events to a Kafka topic whenever a new product is created,
 * enabling event-driven architecture and microservices communication.

 * @see Product
 *
 * @author Dana Khromenko
 * @version 1.0
 * @since 2025
 */
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        Product saved = productRepository.save(product);
        // TODO: add publishing events to a Kafka topic
        return saved;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
