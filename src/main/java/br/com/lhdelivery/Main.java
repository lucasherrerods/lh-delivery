package br.com.lhdelivery;

import br.com.lhdelivery.controller.ProductController;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final ProductController productController = new ProductController();

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
            System.out.println("4. Adicionar item ao carrinho");
            System.out.println("5. Remover item do carrinho");
            System.out.println("6. Fechar pedido");
            System.out.println("7. Alterar status do pedido");
            System.out.println("8. Listar pedidos");
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
                case 0: isRunning = false; break;
            }
        }
    }
}
