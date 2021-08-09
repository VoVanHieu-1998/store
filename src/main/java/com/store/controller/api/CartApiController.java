package com.store.controller.api;

import com.store.service.CartSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CartApiController {
    @Autowired
    CartSession cartSession;
    @RequestMapping("/cart/addToCart/{id}")
    @ResponseBody
    public Object[] addToCart(@PathVariable Integer id) {
        cartSession.addToCart(id);
        //Trả data về client theo dạng mảng
        Object[] info = {cartSession.getCount(),cartSession.getAmount()};
        return info;
    }

    @RequestMapping("/cart/clear")
    @ResponseBody
    public void clearCart(){
        cartSession.clearToCart();
    }

    @RequestMapping("/cart/remove/{productId}")
    @ResponseBody
    public Object[] clearCart(@PathVariable Integer productId){
        cartSession.removeToCart(productId);
        Object[]info = {cartSession.getCount(),cartSession.getAmount()};
      return info;
    }
    @RequestMapping("/cart/update/{id}/{qty}")
    @ResponseBody
    public Object[] update(@PathVariable Integer id,@PathVariable Integer qty) {
        cartSession.updateToCart(id,qty);
        //Trả data về client theo dạng mảng
        Object[] info = {cartSession.getCount(),cartSession.getAmount()};
        return info;
    }

}
