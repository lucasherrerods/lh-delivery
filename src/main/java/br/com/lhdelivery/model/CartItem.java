package br.com.lhdelivery.model;

import br.com.lhdelivery.utils.MoneyFormatter;

public class CartItem {
    private Product product;
    private int quantity;
    private double subtotal;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.subtotal = product.getPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return "{ Item: " + getProduct() + ", Quantidade: " + getQuantity() + ", " + "Subtotal: " + MoneyFormatter.formatter(getSubtotal()) + " }";
    }
}
