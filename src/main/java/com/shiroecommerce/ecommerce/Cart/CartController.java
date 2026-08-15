package com.shiroecommerce.ecommerce.Cart;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CartController
{
    private final CartService cartService;

    public CartController(CartService cartService){
        this.cartService=cartService;
    }

    @GetMapping("/cart")
    public List<Cart> getCart(){
        return cartService.getCart();
    }




}
