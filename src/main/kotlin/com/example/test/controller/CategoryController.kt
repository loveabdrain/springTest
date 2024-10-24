package com.example.test.controller

import com.example.test.model.Category
import com.example.test.service.CategoryService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController(val categoryService: CategoryService) {

    @GetMapping("/categories")
    fun getAllCategories(): List<Category> {
        return categoryService.getAllCategories()
    }

    @PostMapping("/categories")
    fun createCategory(@RequestBody category: Category) {
        return categoryService.createCategory(category)
    }

    @PutMapping("/categories/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody category: Category) {
        return categoryService.updateCategory(id, category)
    }

    @DeleteMapping("/categories/{id}")
    fun deleteCategory(@PathVariable id: Long) {
        return categoryService.deleteCategory(id)
    }


}