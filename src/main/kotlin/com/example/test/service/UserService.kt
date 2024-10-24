package com.example.test.service

import com.example.test.model.User
import java.util.Optional

interface UserService {

    fun getAllUsers(): List<User>

    fun getUserById(id: Long): Optional<User>

    fun createUser(user: User)

    fun updateUser(id: Long, user: User)

    fun deleteUser(id: Long)
}