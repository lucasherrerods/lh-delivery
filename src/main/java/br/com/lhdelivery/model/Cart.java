package br.com.lhdelivery.model;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items;
    private double total;
    private CartStatus status;

    public Cart() {
        this.items = new ArrayList<>();
        this.status = CartStatus.OPEN;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{ Status: " + getStatus() + ", Itens: " + getItems() + ", Total: R$" + getTotal() + " }";
    }
}
