package com.example.proBarber;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private int id;
    private List<Produtos> produtosList;
    private List<Geladeira> geladeiraList;

    public Estoque(int id, List<Produtos> produtosList, List<Geladeira> geladeiraList) {
        this.id = id;
        this.produtosList = produtosList;
        this.geladeiraList = geladeiraList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Produtos> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<Produtos> produtosList) {
        this.produtosList = produtosList;
    }

    public List<Geladeira> getGeladeiraList() {
        return geladeiraList;
    }

    public void setGeladeiraList(List<Geladeira> geladeiraList) {
        this.geladeiraList = geladeiraList;
    }
}
