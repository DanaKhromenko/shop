package com.gmail.danadiadius.event;

import com.gmail.danadiadius.model.Product;
import com.gmail.danadiadius.service.ProductService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Represents an event for product-related operations in the system.
 * This immutable record is serialized to JSON and published to Kafka topics
 * to notify other services about product creation, updates, or other significant
 * state changes.
 *
 * @param id the unique identifier of the product, used for correlation and lookup operations
 * @param name the human-readable name of the product, useful for display and search purposes
 *
 * @see ProductService#createProduct(Product) - the primary producer of this event
 *
 * @author Dana Khromenko
 * @version 1.0
 * @since 2025
 * @see JpaRepository
 * @see Product
 */

public record ProductEvent(Long id, String name) { }
