package br.com.lhdelivery.controller;

import br.com.lhdelivery.model.CartItem;
import br.com.lhdelivery.model.Product;
import br.com.lhdelivery.service.ProductService;

import java.util.ArrayList;

public class ProductController {
    private final ProductService service = new ProductService();

    public void register(String name, double price) {
        boolean product = service.registerProduct(new Product(name, price));

        if (product) {
            System.out.println("Produto adicionado com sucesso!");
        }   else {
            System.out.println("[ERRO] Não foi possível adicionar o produto.");
        }
    }

    public void list() {
        ArrayList<Product> products = service.listProducts();

        if (products == null) {
            System.out.println("Nenhum produto cadastrado!");
            return;
        }   else {
            System.out.println("------- PRODUTOS -------");

            for (Product p : products) {
                System.out.println("- ID " + p.getId() + ": " + p.getName() +
                        " | Preço: R$" + p.getPrice());
            }
        }
    }

    public Product search(int id) {
        Product product = service.searchProduct(id);

        if (product == null) {
            System.out.println("Produto não encontrado.");
            return null;
        }   else {
            System.out.print("Produto: ");
            System.out.println(product);
            return product;
        }
    }

    public void remove(int id) {
        Product product = service.removeProduct(id);

        if (product == null) {
            System.out.println("Produto não encontrado! Não foi possível realizar a exclusão.");
            return;
        }   else {
            System.out.println("Produto removido com sucesso.");
        }
    }
}
