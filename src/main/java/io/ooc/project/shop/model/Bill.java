package io.ooc.project.shop.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bill {

    @Id
    @Column(name="billid")
    @GeneratedValue
    private Long bill;

    @Column
    private String address;

    @Column
    private int subtotal;

    public Bill() {
    }

    public Long getBill() {
        return bill;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }
}
