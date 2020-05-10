package kg.company.blogProject.services.impls;

import kg.company.blogProject.entities.Category;
import kg.company.blogProject.repos.CategoryRepo;
import kg.company.blogProject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        return category.get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        if(categoryRepo.findById(id).isPresent()) {
            Category existingCategory = categoryRepo.findById(id).get();
            existingCategory.setName(category.getName());
            Category updatedCategory = categoryRepo.save(existingCategory);
            return updatedCategory;
        }
        else return null;
    }

    @Override
    public String deleteCategoryById(Long categoryId) {
        String result = "deleted " + categoryRepo.findById(categoryId);
        categoryRepo.deleteById(categoryId);
        return result;
    }

    @Override
    public List<Category> getAllCategoriesByName(String name) {
        return categoryRepo.getAllByName(name);
    }
}
