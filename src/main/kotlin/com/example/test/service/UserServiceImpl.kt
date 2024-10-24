package com.example.test.service

import com.example.test.model.User
import com.example.test.repo.UserRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(val userRepo: UserRepo): UserService {

    override fun getAllUsers(): List<User> {
        return userRepo.findAll()
    }

    override fun getUserById(id: Long): Optional<User> {
        return userRepo.findById(id)
    }

    override fun createUser(user: User) {
        userRepo.save(user)
    }

    override fun updateUser(id: Long, user: User) {
        userRepo.findById(id).map {  existingUser ->
            val updateUser: User = existingUser.copy(
                name = user.name,
                email = user.email,
                password = user.password,
                avatar = user.avatar
            )
            ResponseEntity.ok().body(userRepo.save(updateUser))
        }.orElse(ResponseEntity.notFound().build())
    }

    override fun deleteUser(id: Long) {
        userRepo.findById(id). map { user ->
            userRepo.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}