package io.ooc.project.shop.service;

import io.ooc.project.shop.model.Bill;
import io.ooc.project.shop.model.Cart;
import io.ooc.project.shop.model.Item;
import io.ooc.project.shop.model.User;
import io.ooc.project.shop.repository.BillRepository;
import io.ooc.project.shop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepository billRepository;

    @Autowired
    CartRepository cartRepository;
    @Autowired
    CartService cartService;
    public void makeBill(User user){
        Bill bill = new Bill();
        Cart cart = cartRepository.findCartByUser(user);
        //bill.setItems((List)cart.listCart());
        bill.setAddress(user.getAddress());
        bill.setSubtotal(cartService.getTotal(user));
        billRepository.save(bill);
    }
}
