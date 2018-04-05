package io.ooc.project.shop.controller;

import com.google.gson.Gson;
import io.ooc.project.shop.model.Cart;
import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.CartRepository;
import io.ooc.project.shop.repository.UserRepository;
//import io.ooc.project.shop.service.UserService;
import io.ooc.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by joakimnilfjord on 3/11/2017 AD.
 */
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @PostMapping(path = "/add")
    public ResponseEntity addUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email
    ) {

        User user = userService.addUser(username,password,email);
        if(user == null) {
            System.out.println(username);
            return ResponseEntity.badRequest().body("This username already exists");
        }
        Cart cart = new Cart(user);

        cartRepository.save(cart);
        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

//    @PostMapping(path = "/add")
//    public void addUser(@RequestBody String json){
//        Gson gson = new Gson();
//        System.out.println(json);
//        User user = gson.fromJson(json, User.class);
//        System.out.println(user.getUsername());
//        System.out.println(user.getPassword());
//        if(userService.checkExist(user.getUsername())){
//            return ;
//        }
//        String salt = user.getPassword();
//        user.setPassword(BCrypt.hashpw(salt,BCrypt.gensalt()));
//        userRepository.save(user);
//        return ;
//    }

    @GetMapping(path = "/get")
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

}
