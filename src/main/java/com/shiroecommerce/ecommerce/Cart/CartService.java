package com.shiroecommerce.ecommerce.Cart;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService
{
    private final CartRepository cartRepository;
    public CartService(CartRepository cartRepository){
        this.cartRepository=cartRepository;
    }

    public List<Cart> getCart(){
        return cartRepository.findAll();
    }







}
