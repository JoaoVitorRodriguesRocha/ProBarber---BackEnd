package com.example.proBarber;

import java.util.ArrayList;
import java.util.List;

public class ProdutosCRUD {

    private List<Produtos> produtosList;

    public ProdutosCRUD() {
        produtosList = new ArrayList<>();
    }

    public void criarProduto(int id, String nome, double preco) {
        Produtos produto = new Produtos(id, nome, preco);
        produtosList.add(produto);
    }

    public Produtos buscarProdutoPorId(int id) {
        for (Produtos produto : produtosList) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public void atualizarProduto(int id, String novoNome, double novoPreco) {
        Produtos produto = buscarProdutoPorId(id);
        if (produto != null) {
            produto.setNome(novoNome);
            produto.setPreco(novoPreco);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void deletarProduto(int id) {
        Produtos produto = buscarProdutoPorId(id);
        if (produto != null) {
            produtosList.remove(produto);
            System.out.println("Produto deletado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void listarProdutos() {
        if (produtosList.isEmpty()) {
            System.out.println("Não há produtos cadastrados.");
        } else {
            for (Produtos produto : produtosList) {
                System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
            }
        }
    }
    
}

