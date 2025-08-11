package com.ecommerce.ecomProject.service;

import com.ecommerce.ecomProject.exceptions.APIException;
import com.ecommerce.ecomProject.exceptions.ResourceNotFoundException;
import com.ecommerce.ecomProject.model.Category;
import com.ecommerce.ecomProject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements  CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categoryExist =categoryRepository.findAll();
        if(categoryExist.isEmpty()){
            throw new APIException("Categories Are Not Created Till Now");
        }
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
       Category savedCategory= categoryRepository.findByCategoryName(category.getCategoryName());
       if(savedCategory != null){
           throw new APIException("Category with name "+ category.getCategoryName()+" already exists!!!");
       }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category =categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","CategoryId" , categoryId));
        categoryRepository.delete(category);
        return "Category with Id " + categoryId + " deleted Successfully";
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
       Category savedCategory= categoryRepository.findById(categoryId)
               .orElseThrow(() -> new ResourceNotFoundException("Category","CategoryId" , categoryId));
       savedCategory.setCategoryId(categoryId);
       return categoryRepository.save(savedCategory);
    }
}
