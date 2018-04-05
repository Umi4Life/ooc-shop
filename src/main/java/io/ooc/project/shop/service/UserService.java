package io.ooc.project.shop.service;

import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public User addUser(String username, String password, String email){
        User user = new User();
        User duplicateCheck = userRepository.findByUsername(username);
        if(duplicateCheck!=null){
            return null;
        }
        String hashpassword = BCrypt.hashpw(password,BCrypt.gensalt());
        user.setUsername(username);
        user.setPassword(hashpassword);
        user.setEmail(email);
        return user;
    }

    public User authenticate(String username, String password){
        User findUser = userRepository.findByUsername(username);
        if(findUser!=null) {
            if(BCrypt.checkpw(password,findUser.getPassword())){
                return findUser;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}