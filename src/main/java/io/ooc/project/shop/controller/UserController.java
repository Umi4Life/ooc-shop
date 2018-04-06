package io.ooc.project.shop.controller;

import io.ooc.project.shop.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(path = "/info")
    public String clear(Authentication auth){
        User user = (User) auth.getPrincipal();
        return user.getUsername();
    }


}
