package com.example.test.dto

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

data class CreateTransactionDto(

    val categoryId: Long? = null,

    val price: Double,

    val date: LocalDate? = LocalDate.now(),

    val description: String? = null

)
