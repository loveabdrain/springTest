package com.example.test.repo

import com.example.test.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepo: JpaRepository<Transaction, Long> {
}