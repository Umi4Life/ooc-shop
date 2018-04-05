package io.ooc.project.shop.service;

import io.ooc.project.shop.model.Cart;
import io.ooc.project.shop.model.Item;
import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.CartRepository;
import io.ooc.project.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;

    public Cart findCartByUser(User user){

        return cartRepository.findCartByUser(user);
    }

    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }

    public void addItem(User user, Item item){
        Cart cart = cartRepository.findCartByUser(user);
        cart.addCart(item);
        cartRepository.save(cart);
    }

    public void clearCart(User user){
        Cart cart = cartRepository.findCartByUser(user);
        cart.clearCart();
        cartRepository.save(cart);
    }

    public int getTotal(User user){
        int sum = 0;
        Cart cart = cartRepository.findCartByUser(user);
        for (Item i: cart.getCart()){
            sum+=i.getPrice();
        }
        return sum;
    }

    public void removeFromCart(User user, Item item){
        Cart cart = cartRepository.findCartByUser(user);
        System.out.println(item.getItemID());
        if(cart.getCart().contains(item)){
            cart.popCart(item);
        }
        cartRepository.save(cart);
    }

    

}
