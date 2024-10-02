package main;

import jdk.jshell.execution.Util;
import model.Product;

import java.util.*;

public class Mercado {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Product> products;
    private static Map<Product, Integer> carrinho;

    public static void main(String[] args) {
        products = new ArrayList<>();
        carrinho = new HashMap<>();
        menu();
    }

    private static void menu() {

        System.out.println("_______________________________________________________");
        System.out.println("------------Bem vindo(a) ao Computaria Comercio------------");
        System.out.println("_______________________________________________________");
        System.out.println("******  Selecione uma operação que deseja realizar ******");
        System.out.println("_______________________________________________________");
        System.out.println("| Opção 1 - Cadastrar  |");
        System.out.println("| Opção 2 - Listar     |");
        System.out.println("| Opção 3 - Comprar    |");
        System.out.println("| Opção 4 - Carrinho   |");
        System.out.println("| Opção 5 - Sair       |");

        int option = input.nextInt();

        switch (option) {

            case 1:
                cadastrarProdutos();
                break;

            case 2:
                listarProdutos();
                break;

            case 3:
                comprarProdutos();
                break;

            case 4:
                verCarrinho();
                break;

            case 5:
                System.out.println("Obrigado pela preferência");
                System.exit(0);

            default:
                System.out.println("Opção inválida!");
                menu();
                break;
        }
    }

    private static void cadastrarProdutos() {
        System.out.println("Nome do produto: ");
        String nome = input.next();

        System.out.println("Preço do produto: ");
        Double preco = input.nextDouble();

        Product produto = new Product(nome, preco);
        products.add(produto);

        System.out.println(produto.getNome() + " cadastrado com sucesso!");
        menu();
    }


    private static void listarProdutos() {
        if (products.size() > 0) {


            System.out.println("Lista de produtos \n");

            for (Product p : products) {
                System.out.println(p);
            }


        } else {
            System.out.println("Nenhum produto cadastrado!");
        }

        menu();
    }

    private static void comprarProdutos() {

        if (products.size() > 0) {

            System.out.println("Código do produto: \n");

            System.out.println("------------Produtos disponíveis------------");

            for (Product p : products) {
                System.out.println(p + "\n");
            }

            int id = Integer.parseInt(input.next());
            boolean isPresent = false;

            for (Product p : products) {
                if (p.getId() == id) {
                    int qtd = 0;

                    try {
                        qtd = carrinho.get(p);
                        carrinho.put(p, qtd + 1);
                    } catch (NullPointerException e) {
                        carrinho.put(p, 1);
                    }

                    System.out.println(p.getNome() + " adicionado ao carrinho");
                    isPresent = true;

                    if (isPresent) {

                        System.out.println("Deseja adicionar outro produto ao carrinho?");
                        System.out.println("Digite 1 para SIM\n Digite 0 para NÃO\n");

                        int option = Integer.parseInt(input.next());

                        if (option == 1) {
                            comprarProdutos();
                        } else {
                            finalizarCompra();
                        }

                    }


                } else {
                    System.out.println("Produto não encontrado");
                    menu();
                }
            }
        } else {
            System.out.println("Não existem prosutos cadastrados!");
            menu();
        }
    }

    private static void verCarrinho() {
        System.out.println("----Produtos no seu carrinho----");

        if (carrinho.size() > 0) {
            for (Product p : carrinho.keySet()) {
                System.out.println("Produto: " + p + "\nQuantidade: " + carrinho.get(p));
            }
        } else {
            System.out.println("Carrinho vazio!");
        }

        menu();
    }

    private static void finalizarCompra() {
        Double valorDaCompra = 0.0;
        System.out.println("Seus produtos");

        for (Product p : carrinho.keySet()) {
            int qtd = carrinho.get(p);
            valorDaCompra += p.getPreco() * qtd;

            System.out.println(p);
            System.out.println("Quantidade: " + qtd);
            System.out.println("------------------");
        }

        System.out.println("Valor total: " + valorDaCompra);
        carrinho.clear();

        System.out.println("Obrigado pela preferência");
        menu();
    }
}