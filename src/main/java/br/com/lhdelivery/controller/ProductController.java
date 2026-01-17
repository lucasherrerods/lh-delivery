package br.com.lhdelivery.controller;

import br.com.lhdelivery.model.Product;
import br.com.lhdelivery.service.ProductService;

public class ProductController {
    private final ProductService service = new ProductService();

    public void register(String name, double price) {
        service.registerProduct(new Product(name, price));
    }

    public void list() {
        service.listProducts();
    }

    public void search(int id) {
        service.searchProduct(id);
    }

    public void remove(int id) {
        service.removeProduct(id);
    }
}
