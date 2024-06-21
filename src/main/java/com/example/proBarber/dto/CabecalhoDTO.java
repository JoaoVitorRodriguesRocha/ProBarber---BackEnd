package com.example.proBarber.dto;

import com.example.proBarber.Cabecalho;

import java.util.Date;

public record CabecalhoDTO(Long id,int pedidoNumero,Date data,String usuario,float valorTotal) {
public CabecalhoDTO(Cabecalho cabecalho){
   this(cabecalho.getId(),cabecalho.getPedidoNumero(),cabecalho.getData(),cabecalho.getUsuario(),cabecalho.getValorTotal());

}

   public double getValorTotal() {
   return valorTotal;
   }
}
