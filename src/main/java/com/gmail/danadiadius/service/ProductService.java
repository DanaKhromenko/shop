package com.gmail.danadiadius.service;

import com.gmail.danadiadius.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Service interface defining business operations for managing {@link Product} entities.
 *
 * <p>This interface provides a contract for product management including creation,
 * retrieval of all products, and finding specific products by their unique identifier.
 *
 * <p>Implementations of this interface should handle business logic and act as
 * a middle layer between controllers and data access layers.
 *
 * @author Dana Khromenko
 * @version 1.0
 * @since 2025
 * @see JpaRepository
 * @see Product
 */
public interface ProductService {

    /**
     * Creates and saves a new product in the system.
     *
     * @param product the product entity to be created
     * @return the saved product entity with generated identifier
     */
    Product createProduct(Product product);

    /**
     * Retrieves all products available in the system.
     *
     * @return a list of all products; returns an empty list if no products exist
     */
    List<Product> getAllProducts();

    /**
     * Finds a product by its unique identifier.
     *
     * @param id the unique identifier of the product to retrieve
     * @return the found product entity
     */
    Product getProduct(Long id);
}
