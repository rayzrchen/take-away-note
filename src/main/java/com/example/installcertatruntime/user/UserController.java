package com.example.installcertatruntime.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> all() {
        return userService.all();
    }

    @PostMapping(value = "", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody(required = false) User user) {
        userService.create(user);
    }

}
