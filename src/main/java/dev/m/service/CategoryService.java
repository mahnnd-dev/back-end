package dev.m.service;

import dev.m.model.Category;
import dev.m.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> getCategories(int page, int limit) {
        return categoryRepository.findAll(PageRequest.of(page - 1, limit));
    }

    public Optional<Category> getCategory(String id) {
        return categoryRepository.findById(id);
    }

    public Category addCategory(Category category) {
        category.setId(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    public Category updateCategory(String id, Category category) {
        category.setId(id);
        return categoryRepository.save(category);
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }
}