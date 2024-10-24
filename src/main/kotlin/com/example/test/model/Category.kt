package com.example.test.model

import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category (

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "name")
    val name: String,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val transactions: List<Transaction> = emptyList()
)