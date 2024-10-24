package com.example.test.model

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date

@Entity
@Table(name = "transactions")
data class Transaction(

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category? = null,

    @Column(name = "price")
    val price: Double = 0.0,

    @Column(name = "date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    val date: LocalDate? = LocalDate.now(),

    @Column(name = "description")
    val description: String
)
