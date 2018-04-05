package io.ooc.project.shop.security;


import io.ooc.project.shop.model.User;
import io.ooc.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AuthenticationHandler implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        System.out.println("AUTHENTICATION.GETNAME "+authentication.getName());
        System.out.println("AUTHENTICATION.GETPASS "+authentication.getCredentials());
        String password = authentication.getCredentials().toString();
        User user = userService.authenticate(username,password);

        if (user!=null){
            return new UsernamePasswordAuthenticationToken(user,user,
                    new ArrayList<>());
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
