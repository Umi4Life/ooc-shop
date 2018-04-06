package io.ooc.project.shop.model;


import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="itemid")
    private Long itemid;
    @Column(name = "price")
    private Long price;
    @Column(name = "productName")
    private String productNam;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;

    public Item(Long price, String productNam, String description, String image) {
        this.price = price;
        this.productNam = productNam;
        this.description = description;
        this.image = image;
    }
    public Item() {
    }

    public Long getItemID() {
        return itemid;
    }

    public Long getPrice() {
        return price;
    }

    public String getProductNam() {
        return productNam;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public void setItemID(Long itemID) {
        this.itemid = itemID;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setProductNam(String productNam) {
        this.productNam = productNam;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
