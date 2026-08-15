package com.shiroecommerce.ecommerce.Cart;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cart")
@Setter
@Getter
public class Cart
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String productName;
    private double Price;
    private int Quantity;


}
