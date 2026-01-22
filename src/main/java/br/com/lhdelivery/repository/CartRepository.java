package br.com.lhdelivery.repository;

import br.com.lhdelivery.model.Cart;

import java.util.ArrayList;

public class CartRepository {
    private final ArrayList<Cart> carts = new ArrayList<>();

    public void save(Cart cart) {
        carts.add(cart);
    }

    public Cart newCart() {
        return new Cart();
    }

    public ArrayList<Cart> listCarts() {
        return carts;
    }
}
