package proBarber.proBarber.model;

import jakarta.persistence.*;
@Entity
public class Pedido {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;

    @Column(
            name = "Usuario", length = 50
    )
    private String Usuario;
    @Column(
            name = "Total"
    )
    private int Total;
    @Column(
            name = "DataInclusao"
    )
    private String DataInclusao;
    @Column(
            name = "Observacao", length = 5000
    )
    private String Observacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public String getDataInclusao() {
        return DataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        DataInclusao = dataInclusao;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String observacao) {
        Observacao = observacao;
    }
}