package br.com.lhdelivery.controller;

import br.com.lhdelivery.model.Cart;
import br.com.lhdelivery.model.CartItem;
import br.com.lhdelivery.service.CartService;
import br.com.lhdelivery.utils.MoneyFormatter;

public class CartController {
    private final CartService service = new CartService();

    public void create() {
        Cart cart = service.createCart();

        if (cart == null) {
            System.out.println("Já existe um carrinho em aberto!");
        }   else {
            System.out.println("Carrinho criado com sucesso!");
        }
    }

    public void add(CartItem item) {
        service.addItem(item);
        System.out.println("Item adicionado com sucesso!");
    }

    public void remove(CartItem item) {
        service.removeItem(item);
        System.out.println("Produto removido com sucesso!");
    }

    public void showCart() {
        Cart cart = service.showCart();

        if (cart == null) {
            System.out.println("Nenhum carrinho aberto.");
            return;
        }

        System.out.println("------- CARRINHO -------");
        System.out.println("Status: " + cart.getStatus());
        System.out.println("Total: " + MoneyFormatter.formatter(cart.getTotal()));

        System.out.println("Itens: ");
        for (CartItem item : cart.getItems()) {
            System.out.println("- ID " + item.getProduct().getId() + ": " + item.getProduct().getName() +
                    " | Quantidade: " + item.getQuantity() +
                    " | Preço: R$" + MoneyFormatter.formatter(item.getProduct().getPrice()));
        }
    }

    public CartItem searchItem(int id) {
        return service.searchItem(id);
    }

    public void close() {
        service.closeCart();
    }
}
