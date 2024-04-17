package com.example.proBarber;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {
    List<Produtos> prod = new ArrayList<>();
    List<ItensDeVenda> item = new ArrayList<>();
    String PostMensagem= "SUCESSO";

    //Get e Post do Produto

    @GetMapping("/")
    String raiz(){
        return "a";
    }
    @GetMapping("/Prod")
    public List<Produtos> produtos(){
        return prod;
    }
    @PostMapping("/Prod")
    public ResponseEntity<Object> insert(@RequestBody Produtos produtos){

        Produtos prod =new Produtos(
                produtos.getId(),
                produtos.getNome(),
                produtos.getPreco()

        );

        Map<String,Object> respostaProd = new HashMap<>();
        respostaProd.put("dados",prod);
        respostaProd.put("Retorno",PostMensagem);

        return ResponseEntity.status(200).body(respostaProd);
    }

    //Get e Post do item
    @GetMapping("/item")
    public List<ItensDeVenda> item(){
        return item;
    }

    @PostMapping("/item")
    public ResponseEntity<Object> insert(@RequestBody ItensDeVenda item){
        ItensDeVenda itensDeVenda = new ItensDeVenda(
                item.getValorRecebido(),
                item.getServico(),
                item.getProduto(),
                item.getAlimento()
        );


        Map<String,Object> respostaItem =new HashMap<>();
        respostaItem.put("dados",itensDeVenda);
        respostaItem.put("Retorno",PostMensagem);



        return ResponseEntity.status(200).body(respostaItem);

    }


}