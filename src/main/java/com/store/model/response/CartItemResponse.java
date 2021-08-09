package com.store.model.response;

import com.store.entity.ProductJson;

public class CartItemResponse {
    private ProductJson product;
    private int quantity;

    public ProductJson getProduct() {
        return product;
    }

    public void setProduct(ProductJson product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
