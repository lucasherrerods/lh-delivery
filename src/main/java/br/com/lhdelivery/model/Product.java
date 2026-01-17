package br.com.lhdelivery.model;

public class Product {
    private static int counter = 1;
    private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = counter++;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{ ID: " + getId() + ", Nome: " + getName() + ", " + "Preço: " + getPrice() + " }";
    }
}
