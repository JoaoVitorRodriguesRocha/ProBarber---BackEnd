package com.example.proBarber;

import java.util.Date;

public class Cabecalho {
    private int id;
    private Date data;
    private String usuario;  //pegar da classe usuário
    private float valorTotal; //pegar valor total do pedido



    public Cabecalho(int id, Date data, String usuario, float valorTotal) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
