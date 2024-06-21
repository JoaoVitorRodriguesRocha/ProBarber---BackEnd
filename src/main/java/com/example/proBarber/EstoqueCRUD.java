package com.example.proBarber;

import java.util.ArrayList;
import java.util.List;

public class EstoqueCRUD {
    private ArrayList<Estoque> listaEstoque;

    public void criarEstoque(Long id ,List<Produtos> produtos,List<Geladeira> geladeiras){
        Estoque estoque = new Estoque(id,produtos, geladeiras);
        listaEstoque.add(estoque);

    }

    public Estoque buscarEstoque(Long id)
    {

        for(Estoque estoque : listaEstoque){
            if(estoque.getId() == id)
            {
                return estoque;
            }
        }
        return null;
    }

    public void deletaEstoque(Long id)
    {
       Estoque estoque = buscarEstoque(id);

        for(int i= 0; i<listaEstoque.size(); i++){
            if(estoque.getId() == id)
            {
                listaEstoque.remove(estoque);
            }
        }
    }

    public void atualizaEstoque(Long id,List<Produtos> novoprodutoList, List<Geladeira> novageladeiraList)
    {
        Estoque estoque = buscarEstoque(id);

        for(int i= 0; i<listaEstoque.size(); i++){
            if(estoque.getId() == id)
            {
                estoque.setProdutosList(novoprodutoList);
                estoque.setGeladeiraList(novageladeiraList);
            }
        }
    }


    public void listarEstoque(){
        if(listaEstoque.isEmpty()){
            System.out.println("Estoque vazio");
        }else {
            for(Estoque estoque :listaEstoque) {
                System.out.println("Produto: " + estoque.getProdutosList() +" disponível" + " Item da geladeira : " +estoque.getGeladeiraList()+ " disponível" );
            }
        }
    }




}
