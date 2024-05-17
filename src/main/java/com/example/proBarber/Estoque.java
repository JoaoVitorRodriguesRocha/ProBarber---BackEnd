package com.example.proBarber;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produtos> produtosList;
    private List<Geladeira> geladeiraList;

    public Estoque() {
        produtosList = new ArrayList<>();
        geladeiraList = new ArrayList<>();
    }
}
