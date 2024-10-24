package com.example.test.controller

import com.example.test.model.User
import com.example.test.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController(val userService: UserService) {

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable id: Long): Optional<User> {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User) {
        return userService.createUser(user)
    }

    @PutMapping("/users/{id}")
    fun updateUser(@PathVariable id: Long,
                   @RequestBody user: User
    ) {
        return userService.updateUser(id, user)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Long) {
        return userService.deleteUser(id)
    }
}