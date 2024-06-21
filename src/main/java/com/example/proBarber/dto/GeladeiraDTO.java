package com.example.proBarber.dto;

import com.example.proBarber.Geladeira;

public record GeladeiraDTO(Long id, String nomeAlimento, double valorAlimento) {
    public GeladeiraDTO(Geladeira geladeira){
        this(geladeira.getId(), geladeira.getNomeAlimento(), geladeira.getValorAlimento());
    }



}
