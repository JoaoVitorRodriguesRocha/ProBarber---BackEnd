package com.example.proBarber.dto;

import com.example.proBarber.Estoque;
import com.example.proBarber.Geladeira;
import com.example.proBarber.Produtos;

import java.util.List;

public record EstoqueDTO(Long id,List<Produtos> produtosList,List<Geladeira> geladeiraList) {
    public EstoqueDTO(Estoque estoque){
        this(estoque.getId(),estoque.getProdutosList(),estoque.getGeladeiraList());
    }
}


