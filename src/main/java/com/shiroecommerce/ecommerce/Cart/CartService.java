package com.shiroecommerce.ecommerce.Cart;
import java.util.ArrayList;
import com.shiroecommerce.ecommerce.Product.Product;
import com.shiroecommerce.ecommerce.Product.ProductRepository;
import org.springframework.stereotype.Service;

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

    /*public List<Cart> getCart(Long userId) {

        List<Cart> cartItems = cartRepository.findByUserId(userId);

        for (Cart cart : cartItems) {

            Product product =
                    productRepository
                            .findById(cart.getProductId())
                            .orElse(null);

            if (product != null) {

                System.out.println("Product: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Quantity: " + cart.getQuantity());

            }
        }

        return cartItems;*/

    public List<CartResponse> getCart(Long userId)
    {

        List<Cart> cartItems = cartRepository.findByUserId(userId);

        List<CartResponse> responses = new ArrayList<>();

        for (Cart cart : cartItems) {

            Product product = productRepository
                    .findById(cart.getProductId())
                    .orElse(null);

            if (product != null) {

                CartResponse response = new CartResponse(
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

}