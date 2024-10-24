package com.example.test.dto

import java.text.SimpleDateFormat
import java.util.*

data class UpdateTransactionDto(

    val categoryId: Long? = null,

    val price: Double? = null,

    val date: String? = SimpleDateFormat("dd-MM-yyyy").format(Date()),

    val description: String? = null

)
