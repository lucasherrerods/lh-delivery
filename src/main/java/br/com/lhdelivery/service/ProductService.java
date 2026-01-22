package br.com.lhdelivery.service;

import br.com.lhdelivery.model.Product;
import br.com.lhdelivery.repository.ProductRepository;

import java.util.ArrayList;

public class ProductService {
    private final ProductRepository repository = new ProductRepository();

    public boolean registerProduct(Product product) {
        if (validateName(product) && validatePrice(product)) {
            repository.saveProduct(product);
            return true;
        }   else {
            return false;
        }
    }

    public boolean validateName(Product product) {
        for (Product p : repository.listProducts()) {
            if (p.getName().equals(product.getName())) {
                return false;
            }
        }
        return true;
    }

    public boolean validatePrice(Product product) {
        if (product.getPrice() <= 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Product> listProducts() {
        ArrayList<Product> products = repository.listProducts();

        if (products.isEmpty()) {
            return null;
        }

        return products;
    }

    public Product searchProduct(int id) {
        Product product = repository.searchById(id);

        if (product == null) {
            return null;
        }

        return product;
    }

    public Product removeProduct(int id) {
        Product product = repository.removeProduct(id);

        if (product == null) {
            return null;
        }

        return product;
    }
}
