package com.shiroecommerce.ecommerce.Cart;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart/{userId}")
    public List<CartResponse> getCart(@PathVariable Long userId) {
        return cartService.getCart(userId);
    }

    @PostMapping("/cart")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @DeleteMapping("/cart/{cartId}")
    public void removeFromCart(@PathVariable Long cartId) {
        cartService.removeFromCart(cartId);
    }

    @PutMapping("/cart/{cartId}")
    public Cart updateQuantity(
            @PathVariable Long cartId,
            @RequestBody int quantity
    ) {
        return cartService.updateQuantity(cartId, quantity);
    }
}