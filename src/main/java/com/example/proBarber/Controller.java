package com.example.proBarber;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class Controller {
    List<Produtos> prodList = new ArrayList<>();
    List<ItensDeVenda> itemList = new ArrayList<>();
    List<Servicos> servList = new ArrayList<>();

    List<Cabecalho> cabList = new ArrayList<>();
    String PostMensagem= "SUCESSO";

    //Get e Post do Produto

    @GetMapping("/")
    String raiz(){
        return "rota raiz";
    }
    @GetMapping("/Prod")
    public List<Produtos> produtos(){
        return prodList;
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

        prodList.add(prod);
        return ResponseEntity.status(200).body(respostaProd);
    }


    //Get e Post de serviços
    @GetMapping("/Servicos")
    public List<Servicos> servicos(){
        return servList;
    }

    @PostMapping("/Servicos")
    public ResponseEntity<Object> insert(@RequestBody Servicos servicos){

        Servicos serv = new Servicos(
                servicos.getId(),
                servicos.getNomeServico(),
                servicos.getValorServico()

        );

        Map<String,Object> respostaServ = new HashMap<>();
        respostaServ.put("dados",serv);
        respostaServ.put("Retorno",PostMensagem);
        servList.add(serv);
        return ResponseEntity.status(200).body(respostaServ);
    }


    //Get e Post do item
    @GetMapping("/item")
    public List<ItensDeVenda> item(){
        return itemList;
    }

    @PostMapping("/item")
    public ResponseEntity<Object> insert(@RequestBody ItensDeVenda item){
        ItensDeVenda itensDeVenda = new ItensDeVenda(
                item.getId(),
                item.getPedidoNumero(),
                item.getValorRecebido(),
                item.getServico(),
                item.getProduto(),
                item.getAlimento()
        );
        Map<String,Object> respostaItem =new HashMap<>();
        respostaItem.put("dados",itensDeVenda);
        respostaItem.put("Retorno",PostMensagem);

        itemList.add(itensDeVenda);
        return ResponseEntity.status(200).body(respostaItem);
    }
    // Get e Post do Cabeçalho
    @GetMapping("/cabecalho")
    public  List<Cabecalho> cabecalho(){return cabList;}
    @PostMapping("/cabecalho")

    public ResponseEntity<Object> insert(@RequestBody Cabecalho cabecalho){
        Cabecalho cabecalho1 = new Cabecalho(
                cabecalho.getId(),
                cabecalho.getPedidoNumero(),
                cabecalho.getData(),
                cabecalho.getUsuario(),
                cabecalho.getValorTotal()
        );


        Map<String,Object> respostaCab =new HashMap<>();
        respostaCab.put("dados",cabecalho1);
        respostaCab.put("Retorno",PostMensagem);
        cabList.add(cabecalho1);


        return ResponseEntity.status(200).body(respostaCab);

    }

    @GetMapping("/dashboard")
    public ResponseEntity<Object> getDashboardData() {
        Map<String, Object> dashboardData = new HashMap<>();

        dashboardData.put("totalProdutos", prodList.size());
        dashboardData.put("totalServicos", servList.size());
        dashboardData.put("totalItensDeVenda", itemList.size());
        dashboardData.put("totalCabecalhos", cabList.size());


        double valorTotalVendas = cabList.stream().mapToDouble(Cabecalho::getValorTotal).sum();
        dashboardData.put("valorTotalVendas", valorTotalVendas);



        return ResponseEntity.ok(dashboardData);
    }


}