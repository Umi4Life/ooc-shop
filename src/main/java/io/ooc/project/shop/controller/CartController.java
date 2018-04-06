package io.ooc.project.shop.controller;

import com.google.gson.Gson;
import io.ooc.project.shop.model.Cart;
import io.ooc.project.shop.model.Item;
import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.UserRepository;
import io.ooc.project.shop.security.AuthenticationHandler;
import io.ooc.project.shop.service.BillService;
import io.ooc.project.shop.service.CartService;
import io.ooc.project.shop.service.ItemService;
import io.ooc.project.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;
    @Autowired
    private BillService billService;

    @GetMapping(path = "/list")
    public Iterable<Item> getCart(Authentication auth
    ) {
        User user = (User) auth.getPrincipal();
        Cart cart = cartService.findCartByUser(user);
        return cart.listCart();
    }

    @PostMapping(path = "/add")
    public ResponseEntity addItem(Authentication auth,
            @RequestParam long itemid
    ) {
        User user = (User) auth.getPrincipal();
        Item item = itemService.findItemById(itemid);
        System.out.println(item.getProductNam());
        cartService.addItem(user,item);

        return ResponseEntity.ok(itemid);
    }

    @PostMapping(path = "/remove")
    public void removeItem(Authentication auth, @RequestParam long itemid) {
        User user = (User) auth.getPrincipal();
        Item item = itemService.findItemById(itemid);
        cartService.removeFromCart(user,item);

    }

    @PostMapping(path = "/clear")
    public void clear(Authentication auth){
        User user = (User) auth.getPrincipal();
        cartService.clearCart(user);
    }

    @PostMapping(path = "/checkout")
    public String checkout(Authentication auth){
        User user = (User) auth.getPrincipal();
        int total = cartService.getTotal(user);
        billService.makeBill(user);
        cartService.clearCart(user);
        return Integer.toString(total);
    }



}
