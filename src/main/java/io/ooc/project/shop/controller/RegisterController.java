package io.ooc.project.shop.controller;

import com.google.gson.Gson;
import io.ooc.project.shop.model.User;
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

    @PostMapping(path = "/add")
    public User add(@RequestBody String json){
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        String salt = user.getPassword();
        user.setPassword(BCrypt.hashpw(salt,BCrypt.gensalt()));
        userRepository.save(user);
        return user;
    }

    @GetMapping(path = "/get")
    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

}
