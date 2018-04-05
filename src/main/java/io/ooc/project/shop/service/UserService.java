package io.ooc.project.shop.service;

import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User findUserById(long id){
        User user = userRepository.findByUserid(id);
        return user;
    }

    public User findUserByName(String name){
        User user = userRepository.findByUsername(name);
        return user;
    }

    public User addUser(String username, String password, String firstName, String lastName){
        User user = new User();
        User duplicateCheck = userRepository.findByUsername(username);
        if(duplicateCheck!=null){
            return null;
        }
        String hashpassword = BCrypt.hashpw(password,BCrypt.gensalt());
        user.setUsername(username);
        user.setPassword(hashpassword);
        return user;
    }



    public User authenticate(String username, String password){
        User findUser = userRepository.findByUsername(username);
        if(findUser!=null) {
            System.out.println("FINDUSER"+findUser.getPassword());
            System.out.println("PASSWORD"+password);
            if(BCrypt.checkpw(findUser.getPassword(), password)){
                return findUser;
            }
        }
        return null;
    }

    public void saveUser(User user) {

        userRepository.save(user);
    }

}