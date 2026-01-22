package br.com.lhdelivery.service;

import br.com.lhdelivery.model.Cart;
import br.com.lhdelivery.model.CartItem;
import br.com.lhdelivery.model.CartStatus;
import br.com.lhdelivery.repository.CartRepository;

public class CartService {
    private final CartRepository repository = new CartRepository();

    public Cart createCart() {
        Cart cart = searchCartByStatus();

        if (cart == null) {
            cart = repository.newCart();
            repository.save(cart);
        }   else {
            return null;
        }

        return cart;
    }

    public void addItem(CartItem item) {
        Cart cart = searchCartByStatus();

        if (cart == null) {
            cart =  repository.newCart();
            repository.save(cart);
        }

        cart.getItems().add(item);
        recalculateTotal(cart);
    }

    public void removeItem(CartItem item) {
        Cart cart = searchCartByStatus();

        if (cart != null) {
            cart.getItems().remove(item);
            recalculateTotal(cart);
        }
    }

    public Cart showCart() {
        Cart cart = searchCartByStatus();

        if (cart == null) {
            return null;
        }

        return cart;
    }

    public CartItem searchItem(int id) {
        Cart cart = searchCartByStatus();
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
    
    public Cart searchCartByStatus() {
        Cart cart = null;
        
        for (Cart c : repository.listCarts()) {
            if (c.getStatus() == CartStatus.OPEN); {
                cart = c;
            }
        }
        
        return cart;
    }

    public void closeCart() {
        Cart cart = searchCartByStatus();

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
