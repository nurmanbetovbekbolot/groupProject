package kg.company.blogProject.services;

import kg.company.blogProject.entities.Category;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
    Category updateCategory(Long id, Category category);
    String deleteCategoryById(Long categoryId);
    List<Category> getAllCategoriesByName(String name);
}
