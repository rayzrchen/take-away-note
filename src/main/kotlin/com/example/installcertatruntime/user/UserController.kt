package com.example.installcertatruntime.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["api/v1/users"])
class UserController(private val userService: UserService) {

    @GetMapping("")
    fun all(): List<User> {
        return userService.all()
    }

    @PostMapping(value = [""])
    fun create(@RequestBody(required = false) user: User) {
        userService.create(user)
    }

}
