package com.example.test.service

import com.example.test.dto.CreateTransactionDto
import com.example.test.model.Transaction
import java.util.Optional

interface TransactionService {

    fun getAllTransactions(): List<Transaction>

    fun getTransactionById(id: Long): Optional<Transaction>

    fun createTransaction(transaction: CreateTransactionDto)

    fun updateTransaction(id: Long, transaction: Transaction)

    fun deleteTransaction(id: Long)
}