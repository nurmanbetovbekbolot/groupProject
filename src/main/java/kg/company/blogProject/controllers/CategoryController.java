package kg.company.blogProject.controllers;

import kg.company.blogProject.entities.Category;
import kg.company.blogProject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") Long id) {
        return  categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable("id") Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public List<Category> getByName(@PathVariable("name") String name) {
        return categoryService.getAllCategoriesByName(name);
    }
}
