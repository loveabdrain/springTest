package com.example.test.service

import com.example.test.dto.CreateTransactionDto
import com.example.test.model.Transaction
import com.example.test.repo.CategoryRepo
import com.example.test.repo.TransactionRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionServiceImpl(val transactionRepo: TransactionRepo, val categoryRepo: CategoryRepo): TransactionService {

    override fun getAllTransactions(): List<Transaction> {
        return transactionRepo.findAll()
    }

    override fun getTransactionById(id: Long): Optional<Transaction> {
        return transactionRepo.findById(id)
    }

    override fun createTransaction(transaction: CreateTransactionDto) {
        val transactionData = Transaction(
            price = transaction.price,
            category = transaction.categoryId?.let { categoryRepo.findById(it).get() },
            date = transaction.date,
            description = transaction.description!!,
        )
        transactionRepo.save(transactionData)
    }

    override fun updateTransaction(id: Long, transaction: Transaction) {
        transactionRepo.findById(id).map {  existingTransaction ->
            val updateTransaction: Transaction = existingTransaction.copy(
                price = transaction.price,
                date = transaction.date,
                category = transaction.category,
                description = transaction.description
            )
            ResponseEntity.ok().body(transactionRepo.save(updateTransaction))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun deleteTransaction(id: Long) {
        transactionRepo.findById(id). map { transaction ->
            transactionRepo.delete(transaction)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}