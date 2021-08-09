package com.store.service;

import com.store.entity.Product;
import com.store.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SessionScope//  Name: scopedTarget.cartSession nó lấy theo proxyMode tên class CartSession định dạng là
@Service                                                // cartSession viết thường chữ đầu
public class CartSession {
    @Autowired
    ProductDao productDao;
    Map<Integer, Product> map = new HashMap<>();
    public void addToCart(Integer id){
        Product product = map.get(id);
        if(product == null){
            product = productDao.findById(id);
            product.setQuantity(1);
            map.put(id,product);
        }else{
            product.setQuantity(product.getQuantity()+1);
        }
    }
    public void removeToCart(Integer id){
        map.remove(id);
    }
    public void updateToCart(Integer id,int qty){
        Product product = map.get(id);
        product.setQuantity(qty);
    }
    public void clearToCart(){
        map.clear();
    }
    public int getCount(){
        Collection<Product> ps = this.getItems();
        int count = 0;
        for (Product product:ps) {
            count += product.getQuantity();
        }
        return count;
    }
    public double getAmount(){//Tổng số tiền
        Collection<Product> ps = this.getItems();
        double amount = 0;
        for (Product product:ps) {
            amount += (product.getQuantity()*product.getPrice().intValue());
        }
        return amount;
    }
    public Collection<Product> getItems(){//Collection List ,Map
        return map.values();
    }
}
