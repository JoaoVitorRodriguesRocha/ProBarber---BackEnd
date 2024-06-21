package com.example.proBarber;

import com.example.proBarber.dto.CabecalhoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "cabecalho")
@Entity(name = "cabecalho")
@EqualsAndHashCode(of = "id")
public class Cabecalho {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int pedidoNumero;
    private Date data;
    private String usuario;  //pegar da classe usuário
    private static float valorTotal; //pegar valor total do pedido


    public Cabecalho(Long id, int pedidoNumero, Date data, String usuario, float valorTotal) {
        this.id = id;
        this.pedidoNumero = pedidoNumero;
        this.data = data;
        this.usuario = usuario;
        this.valorTotal = valorTotal;
    }

    public Cabecalho(){

    }

    public  Cabecalho(CabecalhoDTO data){
        this.pedidoNumero =data.pedidoNumero();
        this.data = data.data();
        this.usuario = data.usuario();
        this.valorTotal = data.valorTotal();
    }
    public int getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(int pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public static float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
