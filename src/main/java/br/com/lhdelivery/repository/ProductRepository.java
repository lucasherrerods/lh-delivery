package br.com.lhdelivery.repository;

import br.com.lhdelivery.model.Product;

import java.util.ArrayList;

public class ProductRepository {
    private static final ArrayList<Product> products = new ArrayList<>();

    public void saveProduct(Product product) {
        products.add(product);
    }

    public ArrayList<Product> listProducts() {
        return products;
    }

    public Product searchById(int id) {
        Product product = null;

        if (!listProducts().isEmpty()) {
            for (Product p : listProducts()) {
                if (p.getId() == id) {
                    product = p;
                }
            }
        }   else {
            return null;
        }

        return product;
    }

    public Product removeProduct(int id) {
        Product product = searchById(id);

        if (product == null) {
            return null;
        }   else {
            products.remove(product);
        }

        return product;
    }
}
