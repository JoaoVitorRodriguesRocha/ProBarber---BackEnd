package proBarber.proBarber.model;

import jakarta.persistence.*;
@Entity
public class ItensPedidoVenda {

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
            name = "Codigo", length = 50
    )
    private String Codigo;
	
    @Column(
            name = "Preco"
    )
    private int Preco;
    @Column(
            name = "Total"
    )
    private int Total;
	
    @Column(
            name = "Tipo", length = 1
    )
    private String Tipo;

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
        this.Usuario = usuario;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        this.Codigo = codigo; }
		
    public int getPreco() {
        return Preco;
    }

    public void setPreco(int preco) {
        this.Preco = preco;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        this.Total = total;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }
}