package loja;

import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Cliente {
    protected String nome;
    private String nomeUsuario;
    private String senha;
    private LinkedList<Compra> compras;

    public void adicionarCompra(Compra c) {

    }

    public LinkedList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(LinkedList<Compra> compras) {
        this.compras = compras;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String historico() {
        return "";
    }

    public String historico(LocalDate data) {
        return "";
    }

    public String historico(String categoria) {
        return "";
    }

    public Double valorTotal() {
        return 0d;
    }
}
