package io.ooc.project.shop.service;

import io.ooc.project.shop.model.Cart;
import io.ooc.project.shop.model.Item;
import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.CartRepository;
import io.ooc.project.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CartService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    public Cart findCartByUser(User user){
        return cartRepository.findCartByUser(user);
    }

    public void removeFromCart(User user, Item item){
        Cart cart = cartRepository.findCartByUser(user);
        cart.popCart(item);
    }

    

}
