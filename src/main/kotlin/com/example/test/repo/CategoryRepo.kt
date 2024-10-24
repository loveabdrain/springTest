package com.example.test.repo

import com.example.test.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepo: JpaRepository<Category, Long> {



}