package com.appweb.devfm.demo.dto.cart;


import com.appweb.devfm.demo.entity.Cart;
import com.appweb.devfm.demo.entity.Product;

import javax.validation.constraints.NotNull;

public class CartItemDto {
    private Integer id;
    private @NotNull Product product;

    public CartItemDto() {
    }

    public CartItemDto(Cart cart) {
        this.setId(cart.getId());
        this.setProduct(cart.getProduct());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", productName=" + product.getName() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}