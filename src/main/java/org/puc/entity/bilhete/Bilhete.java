package org.puc.entity.bilhete;

import org.puc.entity.voo.Voo;
import org.puc.entity.cia.Cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class Bilhete implements Serializable{
    private Cliente cliente;
    protected int idBilhete;
    protected int qtdeVoo;
    protected int pontosFidelidade;
    protected BigDecimal preco;
    protected String vencimento;
    protected LinkedList<Voo> voos;

    public Bilhete(String dataVencimento, int pontos, BigDecimal preco, LinkedList<Voo> voos, int id) {
        this.vencimento = dataVencimento;
        this.cliente = null;
        this.qtdeVoo = voos.size();
        this.pontosFidelidade = pontos;
        this.preco = preco;
        this.voos = voos;
        this.idBilhete = id;
    }

    public void addVoo(Voo voo) {
        this.voos.add(voo);
        this.qtdeVoo = this.voos.size();
    }

    public boolean disponivel() {
        return this.cliente == null;
    }

    public int verificaVoos() {
        return 0;
    }

    public void vender(Cliente cliente) {
        this.cliente = cliente;
    }

    public abstract BigDecimal calcularPreco();

    public abstract BigDecimal calcularPontos(Bilhete viagens);

    public int getIdBilhete() {
        return this.idBilhete;
    }

    public String toString(){
        return "\nID do Bilhete: " + this.idBilhete + "\nVoos: " + this.voos.toString() + "\n Preço: R$" + this.preco + "\nPontos de Fidelidade: " + this.pontosFidelidade + "\nVencimento: " + this.vencimento + "\n _________________________________________";
    }
}
