package org.puc.core.bilhete;

import org.puc.core.boost.TicketBooster;
import org.puc.core.boost.Type;
import org.puc.core.voo.Voo;
import org.puc.core.cia.Cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;

public abstract class Bilhete implements Serializable {
    private Cliente cliente;
    protected int idBilhete;
    protected int qtdeVoo;
    protected BigDecimal precoBilheteEmPts;
    protected BigDecimal preco;
    protected Date vencimento;
    protected LinkedList<Voo> voos;
    protected int pontosFidelidade;
    protected TicketBooster ticketBooster;

    public Bilhete(Date dataVencimento, BigDecimal pontos, BigDecimal preco, LinkedList<Voo> voos, int id) {
        this.vencimento = dataVencimento;
        this.cliente = null;
        this.qtdeVoo = voos.size();
        this.precoBilheteEmPts = pontos;
        this.preco = preco;
        this.voos = voos;
        this.idBilhete = id;
    }

    public Bilhete(Date dataVencimento, BigDecimal pontos, BigDecimal preco, LinkedList<Voo> voos, int id, int pontosFidelidade) {
        this.vencimento = dataVencimento;
        this.cliente = null;
        this.qtdeVoo = voos.size();
        this.precoBilheteEmPts = pontos;
        this.preco = preco;
        this.voos = voos;
        this.pontosFidelidade = pontosFidelidade;
    }

    public void giveBooster(Type type){
        ticketBooster = new TicketBooster(type);
    }

    public BigDecimal getPrecoAcelerador(){
        return ticketBooster.getCost();
    }

    public BigDecimal getAcelerador(){
        return ticketBooster.getBoost();
    }

    public Date getDataVencimento() {
        return this.vencimento;
    }

    public LinkedList<Voo> getVoos() {
        return this.voos;
    }

    public int getId() {
        return this.idBilhete;
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

    public String toString() {
        return "\nID do Bilhete: " + this.idBilhete + "\nVoos: " + this.voos.toString() + "\n Preço: R$" + this.preco + "\nPontos de Fidelidade: " + this.pontosFidelidade + "\nVencimento: " + this.vencimento + "\n _________________________________________";
    }

    public BigDecimal getPrecoBilheteEmPts() {
        return precoBilheteEmPts;
    }

    public void setPrecoBilheteEmPts(BigDecimal precoBilheteEmPts) {
        this.precoBilheteEmPts = precoBilheteEmPts;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
