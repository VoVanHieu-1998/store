package com.store.controller;

import com.store.service.CartSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
    @Autowired
    CartSession cartSession;
    @RequestMapping("/cart/view")
    public String viewCart(){
        return "cart/view";
    }
}
