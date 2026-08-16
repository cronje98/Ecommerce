package com.shiroecommerce.ecommerce.Cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponse {

    private Long cartId;
    private Long productId;
    private String productName;
    private double price;
    private int quantity;
    private double subtotal;

    public CartResponse(
            Long cartId,
            Long productId,
            String productName,
            double price,
            int quantity
    ) {
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = price * quantity;
    }
}