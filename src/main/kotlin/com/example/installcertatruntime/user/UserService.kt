package com.example.installcertatruntime.user

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun all(): List<User> {
        return userRepository.findAll()
    }

    fun create(user: User) {
        userRepository.save(user)
    }
}
