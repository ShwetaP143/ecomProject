package com.ecommerce.ecomProject.repository;

import com.ecommerce.ecomProject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
