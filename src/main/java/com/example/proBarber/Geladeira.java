package com.example.proBarber;

import com.example.proBarber.dto.GeladeiraDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Table(name = "geladeira")
@Entity(name = "geladeira")
@Getter
@EqualsAndHashCode(of = "id")
public class Geladeira {

    private Long id;
    private String nomeAlimento;
    private double valorAlimento;


    public Geladeira(Long id, String nomeAlimento, double valorAlimento) {
        this.id = id;
        this.nomeAlimento = nomeAlimento;
        this.valorAlimento = valorAlimento;
    }

    public Geladeira() {
    }

    public Geladeira(GeladeiraDTO data){
        this.nomeAlimento = data.nomeAlimento();
        this.valorAlimento = data.valorAlimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setNomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
    }

    public double getValorAlimento() {
        return valorAlimento;
    }

    public void setValorAlimento(double valorAlimento) {
        this.valorAlimento = valorAlimento;
    }
}
