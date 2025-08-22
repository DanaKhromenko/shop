package com.gmail.danadiadius.repository;

import com.gmail.danadiadius.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations and data access for {@link Product}
 * entities in database.
 *
 * <p>This interface extends {@link JpaRepository} which provides JPA related methods
 * such as get, save, delete. It operates with {@link Product} as entity type and
 * {@link Long} as primary key type.
 *
 * <p>Spring Data JPA automatically generates an implementation of this interface at
 * runtime, eliminating the need for manual implementation of common data access methods.
 *
 * @author Dana Khromenko
 * @version 1.0
 * @since 2025
 * @see JpaRepository
 * @see Product
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
