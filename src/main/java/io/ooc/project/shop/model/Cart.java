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

    @ManyToMany
    private List<Item> items = new ArrayList<>();

    public Cart(){}
    public Cart(User user) {
        this.user = user;
    }


    public int getCartid() {
        return cartid;
    }

    public User getUser() {
        return user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addCart(Item item) {
        items.add(item);
    }

    public Iterable listCart(){
        return items;
    }

    public void popCart(Item item){
        items.remove(item);
    }

    public void clearCart(){
        items.clear();
    }
}
