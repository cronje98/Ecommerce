package com.shiroecommerce.ecommerce.Users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {

    @GetMapping("/{username}/home")
    public String home(@PathVariable String username) {
        return "forward:/home.html";
    }


    @GetMapping("/{username}/cart")
    public String cart(@PathVariable String username) {
        return "forward:/cart.html";
    }
}