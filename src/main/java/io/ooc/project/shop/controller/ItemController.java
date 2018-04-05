package io.ooc.project.shop.controller;

import com.google.gson.Gson;
import io.ooc.project.shop.model.Item;
import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.ItemRepository;
import io.ooc.project.shop.repository.UserRepository;
import io.ooc.project.shop.service.ItemService;
import io.ooc.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemRepository itemRepository;

    private UserRepository userRepository;

    private ItemService itemService;

    private UserService userService;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

//    @PostMapping(path = "/add")
//    public Item add(@RequestBody String json){
//        Gson gson = new Gson();
//        Item item = gson.fromJson(json, Item.class);
//        itemRepository.save(item);
//        return item;
//    }

    @PostMapping(path = "/add")
    public ResponseEntity addItem(
            @RequestParam String product_name,
            @RequestParam String image,
            @RequestParam String description,
            @RequestParam int price
    ) {
        Item item = itemService.addItem(product_name,price,image,description);
        itemRepository.save(item);
        return ResponseEntity.ok(item);
    }



    @GetMapping(path = "/get")
    public Iterable<Item> findAll(){
        return itemRepository.findAll();
    }

}
