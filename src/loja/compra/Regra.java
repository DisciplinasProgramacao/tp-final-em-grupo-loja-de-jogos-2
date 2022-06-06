package loja.compra;

import java.util.LinkedList;

import loja.Jogo;

public abstract class Regra implements Comparable<Regra> {
    public abstract boolean regraEhAplicavel(LinkedList<Jogo> jogos);

    public abstract Double valorDesconto();

    public int compareTo(Regra r) {
        return (int) (this.valorDesconto() * 100 - r.valorDesconto() * 100);
    }
}