package model;


import jdk.jshell.execution.Util;
import utilities.utilities;


public class Product extends Item {
    private static int count = 1;

    private int id;
    private String nome;
    private Double preco;

    public Product(String nome, Double preco) {
        super(count, nome, preco);
        this.id = count;
        this.nome = nome;
        this.preco = preco;
        Product.count += 1;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public double calcularPrecoTotal() {
        return getPreco();
    }

    public String toString() {
        return "id: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nPreço: " + utilities.doubleToString(this.getPreco());
    }

}
