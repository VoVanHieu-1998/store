package com.store.entity;

import com.store.model.ProductDetailModel;

import javax.persistence.*;

@Entity(name = "cart_item")
public class CartItem {

    @EmbeddedId
    CartItemId itemId;
    @Column(nullable = false)
    Integer itemQuantity;
    @Column(nullable = false)
    Integer status;

    @Transient
    ProductDetailModel productDetail;

    public CartItem() {
    }

    public CartItem(CartItemId itemId, Integer itemQuantity, Integer status, ProductDetailModel productDetail) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.status = status;
        this.productDetail = productDetail;
    }


    public void qOCartItemUp() {
        if (itemQuantity < productDetail.getQuantity()) {
            this.itemQuantity++;
        }
    }

    public void qOCartItemDown() {
        if (itemQuantity > 1) {
            this.itemQuantity--;
        }
    }

    public void changeStatusOCartItem(int status) {
        this.status = status;
    }

    public void enter_Quantity(int itemQuantity) {
        if (itemQuantity < 1) {
            this.itemQuantity = 1;
        } else {
            if (itemQuantity > productDetail.getQuantity()) {
                this.itemQuantity = productDetail.getQuantity();
            } else {
                this.itemQuantity = itemQuantity;
            }
        }
    }

    public ProductDetailModel getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailModel productDetail) {
        this.productDetail = productDetail;
    }

    public CartItemId getItemId() {
        return itemId;
    }

    public void setItemId(CartItemId itemId) {
        this.itemId = itemId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
