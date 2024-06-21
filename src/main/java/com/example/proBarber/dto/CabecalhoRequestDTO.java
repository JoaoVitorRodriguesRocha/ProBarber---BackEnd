package com.example.proBarber.dto;

import java.util.Date;

public record CabecalhoRequestDTO(int pedidoNumero, Date data, String usuario, float valorTotal) {
}
