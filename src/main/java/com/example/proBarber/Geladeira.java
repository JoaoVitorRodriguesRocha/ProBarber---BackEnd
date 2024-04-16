package com.example.proBarber;

public class Geladeira {

    private int id;
    private String nomeAlimento;
    private double valorAlimento;
    
    public Geladeira(int id, String nomeAlimento, double valorAlimento) {
        this.id = id;
        this.nomeAlimento = nomeAlimento;
        this.valorAlimento = valorAlimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public double getValorAlimento() {
        return valorAlimento;
    }

    public void setValorAlimento(double valorAlimento) {
        this.valorAlimento = valorAlimento;
    }
    
}
