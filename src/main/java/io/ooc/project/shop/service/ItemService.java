package io.ooc.project.shop.service;

import io.ooc.project.shop.model.Item;
import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.ItemRepository;
import io.ooc.project.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserRepository userRepository;


    public Item addItem(String name, long price, String image, String description){
        Item item = new Item();
        item.setProductNam(name);
        item.setPrice(price);
        item.setImage(image);
        item.setDescription(description);
        return item;
    }
}

