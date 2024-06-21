package com.example.proBarber.dto;

import com.example.proBarber.Geladeira;
import com.example.proBarber.Produtos;

import java.util.List;

public record EstoqueRequestDTO(Long id, List<Produtos> produtosList, List<Geladeira> geladeiraList) {
}
