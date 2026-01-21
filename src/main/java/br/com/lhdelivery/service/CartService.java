package br.com.lhdelivery.service;

import br.com.lhdelivery.model.Cart;
import br.com.lhdelivery.model.CartItem;
import br.com.lhdelivery.model.CartStatus;
import br.com.lhdelivery.repository.CartRepository;

import java.util.ArrayList;

public class CartService {
    private final CartRepository repository = new CartRepository();

    public Cart createCart() {
        Cart cart = repository.searchByStatus();

        if (cart == null) {
            cart = repository.newCart();
            repository.save(cart);
        }   else {
            return null;
        }

        return cart;
    }

    public void addItem(CartItem item) {
        Cart cart = repository.searchByStatus();

        if (cart == null) {
            cart =  repository.newCart();
            repository.save(cart);
        }

        cart.getItems().add(item);
        recalculateTotal(cart);
    }

    public void removeItem(CartItem item) {
        Cart cart = repository.searchByStatus();

        if (cart != null) {
            cart.getItems().remove(item);
            recalculateTotal(cart);
        }
    }

    public Cart showCart() {
        Cart cart = repository.searchByStatus();

        if (cart == null) {
            return null;
        }

        return cart;
    }

    public CartItem searchItem(int id) {
        Cart cart = repository.searchByStatus();
        CartItem item = null;

        if (cart != null) {
            for (CartItem i : cart.getItems()) {
                if (i.getProduct().getId() == id) {
                    item = i;
                }
            }
        }   else {
            return null;
        }
        return item;
    }

    public void closeCart() {
        Cart cart = repository.searchByStatus();

        if (cart != null) {
            cart.setStatus(CartStatus.CLOSED);
        }
    }

    public void recalculateTotal(Cart cart) {
        double sum = 0;

        for (CartItem i : cart.getItems()) {
            sum += i.getSubtotal();
        }

        cart.setTotal(sum);
    }
}
