package com.example.test.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.text.SimpleDateFormat
import java.util.*

@Entity
@Table(name = "users")
data class User(

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "name", nullable = false, unique = true)
    val name: String,

    @Column(name = "email", nullable = false, unique = true)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "avatar")
    val avatar: String,

    @Column(name = "created_at")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    val createdDate: String = SimpleDateFormat("dd-MM-yyyy").format(Date())
)