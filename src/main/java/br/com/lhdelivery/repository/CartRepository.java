package br.com.lhdelivery.repository;

import br.com.lhdelivery.model.Cart;
import br.com.lhdelivery.model.CartStatus;

import java.util.ArrayList;

public class CartRepository {
    private final ArrayList<Cart> carts = new ArrayList<>();

    public void save(Cart cart) {
        carts.add(cart);
    }

    public Cart newCart() {
        return new Cart();
    }

    public ArrayList<Cart> list() {
        return carts;
    }

    public Cart searchByStatus() {
        for (Cart c : carts) {
            if (c.getStatus() == CartStatus.OPEN) return c;
        }

        return null;
    }
}
