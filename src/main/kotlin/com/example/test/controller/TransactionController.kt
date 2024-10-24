package com.example.test.controller

import com.example.test.dto.CreateTransactionDto
import com.example.test.model.Transaction
import com.example.test.service.TransactionService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class TransactionController(val transactionService: TransactionService) {

    @GetMapping("/transactions")
    fun getAllUsers(): List<Transaction> {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transactions/{id}")
    fun getUserById(@PathVariable id: Long): Optional<Transaction> {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/transactions")
    fun createUser(@RequestBody transaction: CreateTransactionDto) {
        return transactionService.createTransaction(transaction)
    }

    @PutMapping("/transactions/{id}")
    fun updateUser(@PathVariable id: Long,
                   @RequestBody user: Transaction
    ) {
        return transactionService.updateTransaction(id, user)
    }

    @DeleteMapping("/transactions/{id}")
    fun deleteUser(@PathVariable id: Long) {
        return transactionService.deleteTransaction(id)
    }

}