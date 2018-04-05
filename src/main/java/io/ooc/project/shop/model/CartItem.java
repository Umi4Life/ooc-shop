//package io.ooc.project.shop.model;
//
//import javax.persistence.*;
//
//public class CartItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column
//    int cartitemid;
//
//    @ManyToOne()
//    @JoinColumn(name = "itemid")
//    private Item item;
//
//    @ManyToOne()
//    @JoinColumn(name = "cart_id")
//    private Cart cart;
//
//    @Column(name = "amount")
//    private Long quantity;
//
//    public CartItem(Item item, Long quantity) {
//        this.item = item;
//        this.quantity = quantity;
//    }
//
//    public int getCartitemid() {
//        return cartitemid;
//    }
//
//    public void setCartitemid(int cartitemid) {
//        this.cartitemid = cartitemid;
//    }
//
//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item item) {
//        this.item = item;
//    }
//
//    public Long getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Long quantity) {
//        this.quantity = quantity;
//    }
//}
