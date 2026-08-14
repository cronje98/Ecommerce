package com.shiroecommerce.ecommerce.Users;
import java.util.Optional;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;


    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public boolean login(String usernameOrEmail, String password) {

        Optional<User> user =
                userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if (user.isEmpty()) {
            return false;
        }

        return user.get().getPassword().equals(password);
    }


}


