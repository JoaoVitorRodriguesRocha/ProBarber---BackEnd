package com.example.proBarber;

public class ItensDeVenda {

    private int id;
    private int pedidoNumero;
    private Double valorRecebido;
    private Servicos[] servico;
    private Produtos[] produto;
    private Geladeira[] alimento;

    public ItensDeVenda(int id, int pedidoNumero, Double valorRecebido, Servicos[] servico, Produtos[] produto, Geladeira[] alimento) {
        this.id = id;
        this.pedidoNumero = pedidoNumero;
        this.valorRecebido = valorRecebido;
        this.servico = servico;
        this.produto = produto;
        this.alimento = alimento;
    }

    public int getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(int pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValorRecebido() {
        return valorRecebido;
    }

    public void setValorRecebido(Double valorRecebido) {
        this.valorRecebido = valorRecebido;
    }

    public Servicos[] getServico() {
        return servico;
    }

    public void setServico(Servicos[] servico) {
        this.servico = servico;
    }

    public Produtos[] getProduto() {
        return produto;
    }

    public void setProduto(Produtos[] produto) {
        this.produto = produto;
    }

    public Geladeira[] getAlimento() {
        return alimento;
    }

    public void setAlimento(Geladeira[] alimento) {
        this.alimento = alimento;
    }



}
