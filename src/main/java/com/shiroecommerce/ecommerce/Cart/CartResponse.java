package com.shiroecommerce.ecommerce.Cart;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponse {

    private Long productId;
    private String productName;
    private double price;
    private int quantity;
    private double subtotal;

    public CartResponse(
            Long productId,
            String productName,
            double price,
            int quantity
    ) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.subtotal = price * quantity;
    }
}
