package com.shiroecommerce.ecommerce.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    // LOGIN
    public User login(String usernameOrEmail, String password) {

        Optional<User> user =
                userRepository.findByUsernameOrEmail(
                        usernameOrEmail,
                        usernameOrEmail
                );

        System.out.println("Login entered: " + usernameOrEmail);

        if (user.isEmpty()) {
            return null;
        }

        System.out.println(
                "USER FOUND: " + user.get().getUsername()
        );

        // Check entered password against BCrypt hash
        if (!passwordEncoder.matches(
                password,
                user.get().getPassword()
        )) {
            return null;
        }

        System.out.println("LOGIN SUCCESSFUL");

        return user.get();
    }


    // GET USER
    public User getUserByUsername(String username) {

        return userRepository
                .findByUsernameOrEmail(username, username)
                .orElse(null);
    }


    // REGISTER
    public User register(
            String name,
            String surname,
            String username,
            String email,
            String password
    ) {

        // Check username
        if (userRepository.existsByUsername(username)) {
            return null;
        }

        // Check email
        if (userRepository.existsByEmail(email)) {
            return null;
        }

        User user = new User();

        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        user.setEmail(email);

        // HASH PASSWORD BEFORE SAVING
        user.setPassword(
                passwordEncoder.encode(password)
        );

        return userRepository.save(user);
    }
}