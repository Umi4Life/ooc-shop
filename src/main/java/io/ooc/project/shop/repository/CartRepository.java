package io.ooc.project.shop.repository;

import io.ooc.project.shop.model.Cart;
import io.ooc.project.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findCartByUser(User user);
}
