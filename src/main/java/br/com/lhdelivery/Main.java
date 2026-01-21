package br.com.lhdelivery;

import br.com.lhdelivery.controller.CartController;
import br.com.lhdelivery.controller.ProductController;
import br.com.lhdelivery.model.CartItem;
import br.com.lhdelivery.model.Product;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProductController productController = new ProductController();
    private static final CartController cartController = new CartController();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean isRunning = true;

        while(isRunning) {
            System.out.println("-------------------------");
            System.out.println("DELIVERY RESENHA DO LUCAS");
            System.out.println("-------------------------");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Criar carrinho");
            System.out.println("4. Ver carrinho");
            System.out.println("5. Adicionar item ao carrinho");
            System.out.println("6. Remover item do carrinho");
            System.out.println("7. Fechar pedido");
            System.out.println("8. Alterar status do pedido");
            System.out.println("9. Listar pedidos");
            System.out.println("0. Sair");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String name = sc.nextLine();
                    System.out.print("Digite o preço: ");
                    double price = sc.nextDouble();

                    productController.register(name, price);
                    break;
                case 2: productController.list(); break;
                case 3: cartController.create(); break;
                case 4: cartController.showCart(); break;
                case 5:
                    System.out.println("Selecione o produto que deseja adicionar:");

                    productController.list();
                    int productId = sc.nextInt();
                    Product product = productController.search(productId);

                    System.out.println("Qual a quantidade que deseja adicionar?");
                    int quantity = sc.nextInt();

                    CartItem item = new CartItem(product, quantity);
                    cartController.add(item);
                    break;
                case 6:
                    System.out.println("Selecione o produto que deseja remover: ");
                    cartController.showCart();

                    int itemId = sc.nextInt();
                    CartItem removeItem = cartController.searchItem(itemId);
                    cartController.remove(removeItem);
                    break;
                case 0: isRunning = false; break;
            }
        }
    }
}
