package com.store.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.SQLException;
import java.util.Set;

@Entity(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer userId;
    String username;
    String password;
    String email;
    String fullName;
    String phoneNumber;
    String level;
    String address;
    String photo;
    Integer activated;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cartId")
    Cart cart;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "users_order")
    Set<Order> orderSet;


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @OneToMany(mappedBy="user_reply",fetch= FetchType.LAZY)
    private Set<Reply> replies_user;

    public Set<Reply> getReplies_user() {
        return replies_user;
    }

    public void setReplies_user(Set<Reply> replies_user) {
        this.replies_user = replies_user;
    }



    public Set<Order> getOrderSet() {
        return orderSet;
    }
    public void updateCart() {
        cart.updateCart(this);
    }
    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }
}
