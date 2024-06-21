package com.example.proBarber;

import com.example.proBarber.dto.EstoqueDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Table(name = "estoque")
@Entity(name = "estoque")
@EqualsAndHashCode(of = "id")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<Produtos> produtosList;
    private List<Geladeira> geladeiraList;


    public Estoque() {
    }

    public Estoque(Long id, List<Produtos> produtosList, List<Geladeira> geladeiraList) {
        this.id = id;
        this.produtosList = produtosList;
        this.geladeiraList = geladeiraList;
    }

    public Estoque(EstoqueDTO data){
        this.produtosList = data.produtosList();
        this.geladeiraList = data.geladeiraList();
    }

    public Long getId() {
        return id;
    }



    public void setId(Long id) {
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
