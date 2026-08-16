package com.shiroecommerce.ecommerce.Users;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request)
    {

        return userService.login(
                request.getLogin(),
                request.getPassword()
        );
    }
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userService.register(
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }
}