package com.ecommerce.ecomProject.service;

import com.ecommerce.ecomProject.model.Category;
import com.ecommerce.ecomProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements  CategoryService{
    private List<Category> categories = new ArrayList<Category>();
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category =categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        categoryRepository.delete(category);
        return "Category with Id " + categoryId + " deleted Successfully";
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
       Category savedCategory= categoryRepository.findById(categoryId)
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));
       savedCategory.setCategoryId(categoryId);
       return categoryRepository.save(savedCategory);
    }
}
