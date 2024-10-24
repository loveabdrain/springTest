package com.example.test.service

import com.example.test.model.Category

interface CategoryService {

    fun getAllCategories(): List<Category>

    fun createCategory(category: Category)

    fun updateCategory(categoryId: Long, category: Category)

    fun deleteCategory(categoryId: Long)

}