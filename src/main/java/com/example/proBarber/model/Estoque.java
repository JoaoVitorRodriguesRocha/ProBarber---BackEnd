package com.example.proBarber.model;

import jakarta.persistence.*;

@Entity
public class Estoque{

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;

    @Column(
            name = "Codigo", length = 10
    )
    private String Codigo;
	
    @Column(
            name = "Nome", length = 50
    )
    private String Nome;
	
    @Column(
            name = "Produto", length = 10
    )
    private String Produto;
	
    @Column(
            name = "Saldo"
    )
    private int Saldo;
	

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        this.Codigo = codigo;
    }

    public String getProduto() {
        return Produto;
    }

    public void setProduto(String produto) {
        this.Produto = produto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public int getSaldo() {return Saldo;}

    public void setEmail(int saldo) {
        this.Saldo = saldo;
    }
}