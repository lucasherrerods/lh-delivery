package br.com.lhdelivery.service;

import br.com.lhdelivery.model.Cart;
import br.com.lhdelivery.model.CartItem;
import br.com.lhdelivery.model.CartStatus;
import br.com.lhdelivery.repository.CartRepository;

public class CartService {
    private final CartRepository repository = new CartRepository();

    public void createCart() {
        Cart cart = repository.newCart();
        repository.save(cart);
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
