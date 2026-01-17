package br.com.lhdelivery.service;

import br.com.lhdelivery.model.Product;
import br.com.lhdelivery.repository.ProductRepository;

import java.util.ArrayList;

public class ProductService {
    public boolean registerProduct(Product product) {
        if (validateName(product) && validatePrice(product)) {
            ProductRepository.saveProduct(product);

            System.out.println("Produto adicionado com sucesso!");
            System.out.println(product.toString());
            return true;
        }   else {
            return false;
        }
    }

    public boolean validateName(Product product) {
        for (Product p : ProductRepository.listProducts()) {
            if (p.getName().equals(product.getName())) {
                System.out.println("[ERRO] Já existe um produto cadastrado com esse nome.");
                return false;
            }
        }
        return true;
    }

    public boolean validatePrice(Product product) {
        if (product.getPrice() <= 0) {
            System.out.println("[ERRO] Valor inválido, tente novamente.");
            return false;
        }
        return true;
    }

    public void listProducts() {
        ArrayList<Product> products = ProductRepository.listProducts();

        if (products.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
        }   else {
            System.out.println(products);
        }
    }

    public void searchProduct(int id) {
        Product product = ProductRepository.searchById(id);

        if (product == null) {
            System.out.println("Nenhum produto encontrado.");
        }   else {
            System.out.print("Produto: ");
            System.out.println(product);
        }
    }

    public void removeProduct(int id) {
        Product product = ProductRepository.removeProduct(id);

        if (product == null) {
            System.out.println("Produto não encontrado! Não foi possível realizar a exclusão.");
        }   else {
            System.out.println("Produto removido com sucesso.");
        }
    }
}
