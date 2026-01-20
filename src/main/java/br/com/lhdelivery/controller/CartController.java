package br.com.lhdelivery.controller;

import br.com.lhdelivery.model.CartItem;
import br.com.lhdelivery.service.CartService;

public class CartController {
    private final CartService service = new CartService();

    public void create() {
        service.createCart();
        System.out.println("Carrinho criado com sucesso!");
    }

    public void add(CartItem item) {
        service.addItem(item);
        System.out.println("Item adicionado com sucesso!");
    }

    public void remove(CartItem item) {
        service.removeItem(item);
        System.out.println("Produto removido com sucesso!");
    }

    public void close() {
        service.closeCart();
    }
}
