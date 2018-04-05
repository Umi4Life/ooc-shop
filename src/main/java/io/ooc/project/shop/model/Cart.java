package io.ooc.project.shop.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    @Column
    private int cartid;

    @OneToOne(cascade = {CascadeType.ALL})
    @ElementCollection(targetClass=User.class)
    @JoinColumn
    private User user;

    @OneToMany
    private Set<Item> cart;

    public Cart(){}
    public Cart(User user) {
        this.user = user;
        this.cart = new HashSet<>();
    }

    public int getCartid() {
        return cartid;
    }

    public User getUser() {
        return user;
    }

    public Set<Item> getCart() {
        return cart;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addCart(Item item) {
        cart.add(item);
    }

    public Iterable listCart(){
        return cart;
    }

    public void popCart(Item item){
        cart.remove(item);
    }

    public void clearCart(){
        cart.clear();
    }
}
