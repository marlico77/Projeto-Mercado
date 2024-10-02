package model;


import jdk.jshell.execution.Util;
import utilities.utilities;


public class Product {
    private static int count = 1;

    private int id;
    private String nome;
    private Double preco;

    public Product(String nome, Double preco) {
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


    public String toString() {
        return "id: " + this.getId() +
                "\nNome: " + this.getNome() +
                "\nPreço: " + utilities.doubleToString(this.getPreco());
    }

}
