package com.example.proBarber;

public class Servicos {

    private int id;
    private String nomeServico;
    private double valorServico;

    public Servicos(int id, String nomeServico, double valorServico) {
        this.id = id;
        this.nomeServico = nomeServico;
        this.valorServico = valorServico;
    }

    

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

}
