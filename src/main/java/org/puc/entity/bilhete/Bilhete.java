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

    public Bilhete(String dataVencimento, Cliente cliente, int pontos, BigDecimal preco, LinkedList<Voo> voos) {
        this.vencimento = dataVencimento;
        this.cliente = cliente;
        this.qtdeVoo = voos.size();
        this.pontosFidelidade = pontos;
        this.preco = preco;
        this.voos = voos;
    }

    public void addVoo(Voo voo) {
        this.voos.add(voo);
        this.qtdeVoo = this.voos.size();
    }

    public int verificaVoos() {
        return 0;
    }

    public abstract BigDecimal calcularPreco();

    public abstract BigDecimal calcularPontos(Bilhete viagens);
}
