package com.example.proBarber;

import com.example.proBarber.dto.*;
import com.example.proBarber.repository.CabecalhoRepository;
import com.example.proBarber.repository.EstoqueRepository;
import com.example.proBarber.repository.GeladeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
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



  @Autowired
    private CabecalhoRepository cabRepository;

  @Autowired
    private GeladeiraRepository geladeiraRepository;

  @Autowired private EstoqueRepository estoqueRepository;

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

    @GetMapping("/relatorioServicos")
    public ResponseEntity<Object> gerarRelatorioServicos() {
        Map<String, Object> relatorioServicos = new HashMap<>();

        servList.sort((s1, s2) -> s1.getNomeServico().compareToIgnoreCase(s2.getNomeServico()));

        StringBuilder relatorio = new StringBuilder();
        double valorTotalServicos = 0;

        relatorio.append("Relatório de Serviços\n");
        relatorio.append("----------------------\n");

        for (Servicos servico : servList) {
            relatorio.append("ID: ").append(servico.getId()).append("\n");
            relatorio.append("Nome do Serviço: ").append(servico.getNomeServico()).append("\n");
            relatorio.append("Valor do Serviço: R$ ").append(servico.getValorServico()).append("\n");
            relatorio.append("----------------------\n");

            valorTotalServicos += servico.getValorServico();
        }

        relatorio.append("Total de Serviços: ").append(servList.size()).append("\n");
        relatorio.append("Valor Total dos Serviços: R$ ").append(valorTotalServicos).append("\n");

        relatorioServicos.put("relatorio", relatorio.toString());
        return ResponseEntity.ok(relatorioServicos);
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
    public  List<CabecalhoDTO> getAllCab (){
        List<CabecalhoDTO> cabList =cabRepository.findAll().stream().map(CabecalhoDTO::new).toList();
        return cabList;}

    @PostMapping("/cabecalho")
    public  void saveCabecalho(@RequestBody CabecalhoRequestDTO data){
        Cabecalho cabData = new Cabecalho();
        cabRepository.save(cabData);
        return;
    }

    @GetMapping("/geladeira")
    public List<GeladeiraDTO>getAllGel(){
        List<GeladeiraDTO> gelaList = geladeiraRepository.findAll().stream().map(GeladeiraDTO::new).toList();
        return gelaList;
    }

    @PostMapping("/geladeira")
    public  void saveGeladeira(@RequestBody GeladeiraRequestDTO data){
        Geladeira gelData = new Geladeira();
        geladeiraRepository.save(gelData);
        return;
    }




    @GetMapping("/estoque")
    public List<EstoqueDTO>getAllEst(){
        List<EstoqueDTO> estList = estoqueRepository.findAll().stream().map(EstoqueDTO::new).toList();
        return estList;
    }

    @PostMapping("/estoque")
    public  void saveEstoque(@RequestBody EstoqueRequestDTO data){
        Estoque estData = new Estoque();
        estoqueRepository.save(estData);
        return;
    }





    @GetMapping("/dashboard")
    public ResponseEntity<Object> getDashboardData() {
        Map<String, Object> dashboardData = new HashMap<>();
        List<CabecalhoDTO> cabList =cabRepository.findAll().stream().map(CabecalhoDTO::new).toList();

        dashboardData.put("totalProdutos", prodList.size());
        dashboardData.put("totalServicos", servList.size());
        dashboardData.put("totalItensDeVenda", itemList.size());
        dashboardData.put("totalCabecalhos", cabList.size());


        double valorTotalVendas = cabList.stream().mapToDouble(CabecalhoDTO::getValorTotal).sum();
        dashboardData.put("valorTotalVendas", valorTotalVendas);



        return ResponseEntity.ok(dashboardData);
    }

    @GetMapping("/produtosRelatorio")
    public  ResponseEntity<Object>getProdutoRelatorio(){
        Map<String,Object> produtoRelatorio = new HashMap<>();

           double valorTotal = prodList.stream().mapToDouble(Produtos::getPreco).sum();


        produtoRelatorio.put("totalProdutos", prodList.size());
        produtoRelatorio.put("Valor total de produtos",valorTotal);


        return ResponseEntity.ok(produtoRelatorio);

    }


}