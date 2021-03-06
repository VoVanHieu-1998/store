package com.store.entity;

import com.store.model.ProductDetailModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

@Entity(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cartId;
    Integer status;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    Set<CartItem> cartItems;

    @Transient
    private Map<Integer, CartItem> data;
    @Transient
    private int totalItems;

    public Map<Integer, CartItem> getData() {
        return data;
    }

    //  total of items
    public int calTotalItems() {
        int sum = 0;
        List<CartItem> items = new ArrayList<>(data.values());

        for (CartItem item : items) {

            sum += item.getItemQuantity();
        }
        return sum;
    }

    //  total of items checkout
    public int totalItemsCheckout() {
        int sum = 0;

        List<Integer> keyList = new ArrayList<>(data.keySet());
        for (int i = 0; i < data.size(); i++) {
            CartItem item = data.get(keyList.get(i));
            if (item.getStatus() == 1) sum += item.getItemQuantity();
        }
//        for (CartItem i : data.values()) {
//            if (i.getStatus() == 1) sum += i.getItemQuantity();
//        }
        return sum;
    }

    //  total of price of items checkout
    public BigDecimal totalPriceItemsCheckout() {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal itemCost = BigDecimal.ZERO;
        BigDecimal totalCost = BigDecimal.ZERO;
        for (CartItem i : data.values()) {
            if (i.getStatus() == 1)
                itemCost = i.getProductDetail().getPromotion_price().multiply(new BigDecimal(i.itemQuantity));
            totalCost = totalCost.add(itemCost);

            //sum.add(i.getProductDetail().getPromotion_price().multiply(new BigDecimal(i.getItemQuantity())));
        }
        return totalCost;
    }

    public void setData(Map<Integer, CartItem> data) {
        this.data = data;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems() {
        this.totalItems = calTotalItems();
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private CartItem findProductOItem(ProductDetailModel productDetail) {
        for (CartItem item : data.values()) {
            if (item.getItemId().getProductdetailId() == productDetail.getProductdetailId()) return item;
        }
        return new CartItem(new CartItemId(productDetail.getProductdetailId()), 1, 0, productDetail);
    }

    //    add CartItem
    public void addCartItem(ProductDetailModel productDetail) {
        CartItem item = this.findProductOItem(productDetail);
        // check CartItem exist?
        // check quantity of proeducts?
        if (data.containsKey(item.getItemId().getProductdetailId())) {
            item.qOCartItemUp();

//            // update s??? l?????ng trong database
//            DBUtils.updateCart(this.getCartId(), p.getId(), item.getQuantity());
        } else {
            data.put(item.getItemId().getProductdetailId(), item);
            // th??m item m???i v?? database
////            System.out.println("this.getCartId(): " + this.getCartId() + ", p.getId() :" + p.getId());
//            DBUtils.insertCartItem(this.getCartId(), p.getId(), item.getQuantity(), 0);
        }

        this.setTotalItems();
    }

    public void inputQuantity(Integer code, int quantity) {
        data.get(code).enter_Quantity(quantity);
        this.setTotalItems();
//        CartItem cartItem = data.get(code);
//        Product p = cartItem.getProduct();

        // update quantity to database
//        DBUtils.updateQuantityItem(this.getCartId(), p.getId(), cartItem.getQuantity());
    }

    public void updateCart(Users users) {
        List<Integer> keyList = new ArrayList<>(data.keySet());
        for (int i = 0; i < data.size(); i++) {
            CartItem item = data.get(keyList.get(i));
//        for (CartItem item : data.values()) {
            //N???u s??? l?????ng c???a cart < 1
            if (item.getItemQuantity() == null || item.getItemQuantity() < 1) {
                // set l???i quantity
                data.get(keyList.get(i)).setItemQuantity(1);
//                DBUtils.updateCart(user.getCart().getCartId(), i.getProduct().getId(), i.getQuantity());
            }
            // N???u s??? l?????ng trong gi??? l???n h??n s??? l?????ng trong kho
            if (item.getItemQuantity() > item.getProductDetail().getQuantity()) {
                // set l???i quantity
                data.get(keyList.get(i)).setItemQuantity(item.getProductDetail().getQuantity());
                // update xu???ng databse
//                DBUtils.updateCart(user.getCart().getCartId(), i.getProduct().getId(), i.getProduct().getQuantity());
            }
            // N???u s??? l?????ng trong kho = 0
            if (item.getProductDetail().getQuantity() == 0) {
                // x??a item ra kh???i cart
                data.remove(item.getProductDetail().getProduct().getCode());
                // x??a d?????i databse
//                DBUtils.deleteItemOCart(user.getCart().getCartId(), i.getProduct().getId());
            }
            // N???u product t???m ng??ng b??n
            if (item.getProductDetail().getStatus() == 0) {
                // x??a item ra kh???i cart
                data.remove(item.getProductDetail().getProduct().getCode());
                // x??a d?????i databse
//                DBUtils.deleteItemOCart(user.getCart().getCartId(), i.getProduct().getId());
            }
        }
    }

    public Collection<CartItem> list() {
        return data.values();
    }


    public CartItem findCartItem(int id) {
        for (CartItem i : data.values()) {
            if (i.getProductDetail().getProductdetailId() == id)
                return i;
        }
        return null;
    }

    public void changeStatusOCartItem(int code, int status) {
        CartItem cartItem = this.findCartItem(code);
        cartItem.changeStatusOCartItem(status);
//                // ghi xu???ng database
//                DBUtils.updateCartItemStatus(user.getCart().getCartId(), cartItem.getProduct().getId(), cartItem.getStatus());

    }
}
