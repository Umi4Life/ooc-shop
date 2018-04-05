package io.ooc.project.shop.repository;


import io.ooc.project.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUserid(long id);
}
