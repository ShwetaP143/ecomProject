package com.ecommerce.ecomProject.service;

import com.ecommerce.ecomProject.CategoryDTO;
import com.ecommerce.ecomProject.CategoryResponse;
import com.ecommerce.ecomProject.model.Category;


public interface CategoryService {
    CategoryResponse getAllCategories();
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(Long categoryId, CategoryDTO categoryDTO);
}
