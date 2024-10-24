package com.example.test.service

import com.example.test.model.Category
import com.example.test.repo.CategoryRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(val categoryRepo: CategoryRepo): CategoryService {

    override fun getAllCategories(): List<Category> {
        return categoryRepo.findAll()
    }

    override fun createCategory(category: Category) {
        categoryRepo.save(category);
    }

    override fun updateCategory(categoryId: Long,
                                category: Category
    ) {
        categoryRepo.findById(categoryId).map { existingCategory ->
            val updateCategory: Category = existingCategory.copy(
                name = category.name
            )
            ResponseEntity.ok().body(categoryRepo.save(updateCategory))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun deleteCategory(categoryId: Long) {
        categoryRepo.findById(categoryId).map { category ->
            categoryRepo.delete(category)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}