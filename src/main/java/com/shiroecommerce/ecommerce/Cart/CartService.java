package com.shiroecommerce.ecommerce.Cart;

import java.util.ArrayList;
import com.shiroecommerce.ecommerce.Product.Product;
import com.shiroecommerce.ecommerce.Product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartService(
            CartRepository cartRepository,
            ProductRepository productRepository
    ) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


    public List<CartResponse> getCart(Long userId)
    {

        List<Cart> cartItems = cartRepository.findByUserId(userId);

        List<CartResponse> responses = new ArrayList<>();

        for (Cart cart : cartItems) {

            Product product = productRepository
                    .findById(cart.getProductId())
                    .orElse(null);

            if (product != null) {

                CartResponse response = new CartResponse
                        (
                        cart.getId(),
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        cart.getQuantity()

                );

                responses.add(response);
            }
        }

        return responses;
    }

    public Cart addToCart(Cart cart) {

        // Check that the product exists
        Product product = productRepository
                .findById(cart.getProductId())
                .orElseThrow();

        // Check if the product is already in this user's cart
        Cart existingCart = cartRepository
                .findByUserIdAndProductId(
                        cart.getUserId(),
                        cart.getProductId()
                )
                .orElse(null);

        if (existingCart != null) {

            // Product already exists in cart,
            // so increase the quantity
            existingCart.setQuantity(
                    existingCart.getQuantity() + cart.getQuantity()
            );

            return cartRepository.save(existingCart);
        }

        return cartRepository.save(cart);
    }
    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    public Cart updateQuantity(Long cartId, int quantity) {

        Cart cart = cartRepository
                .findById(cartId)
                .orElseThrow();

        cart.setQuantity(quantity);

        return cartRepository.save(cart);
    }



}