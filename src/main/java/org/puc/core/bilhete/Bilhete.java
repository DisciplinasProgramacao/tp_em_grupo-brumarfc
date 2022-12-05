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

    // #region atributos
    // atributos
    private Cliente cliente;
    protected int idBilhete;
    protected int qtdeVoo;
    protected BigDecimal precoBilheteEmPts;
    protected BigDecimal preco;
    protected Date vencimento;
    protected LinkedList<Voo> voos;
    protected int pontosFidelidade;
    protected TicketBooster ticketBooster;
    // #endregion

    // #region Construtor

    /**
     * Construtor simples: Cria um bilhete do tipo Genérico
     * @param dataVencimento data de vencimento do bilhete
     * @param pontos Pontos que serão gerados
     * @param preco Preço do bilhete
     * @param voos Voos atrelados ao bilhete
     * @param id Identificador do bilhete
     */

    public Bilhete(Date dataVencimento, BigDecimal pontos, BigDecimal preco, LinkedList<Voo> voos, int id) {
        this.vencimento = dataVencimento;
        this.cliente = null;
        this.qtdeVoo = voos.size();
        this.precoBilheteEmPts = pontos;
        this.preco = preco;
        this.voos = voos;
        this.idBilhete = id;
    }

    /**
     * Construtor: Cria um bilhete que faz uso dos pontos de fidelidade
     * @param dataVencimento data de vencimento do bilhete
     * @param pontos Pontos que serão gerados
     * @param preco Preço do bilhete
     * @param voos Voos atrelados ao bilhete
     * @param id Identificador do bilhete
     * @param pontosFidelidade Pontos de fidelidade possuidos
     */

    public Bilhete(Date dataVencimento, BigDecimal pontos, BigDecimal preco, LinkedList<Voo> voos, int id, int pontosFidelidade) {
        this.vencimento = dataVencimento;
        this.cliente = null;
        this.qtdeVoo = voos.size();
        this.precoBilheteEmPts = pontos;
        this.preco = preco;
        this.voos = voos;
        this.pontosFidelidade = pontosFidelidade;
    }
    //#endregion

    // #region Métodos de funcionamento

    /**
     * Responsável por Calcular o Preço do bilhete a partir da sua regra de implementação.
     * @return Preço do bilhete
     */
    public abstract BigDecimal calcularPreco();

    /**
     * Calcula a pontuação gerada após a compra
     * @param viagens — viagem que deve ser calculada
     * @return Pontuação gerada
     */
    public abstract BigDecimal calcularPontos(Bilhete viagens);


    public void giveBooster(Type type){
        ticketBooster = new TicketBooster(type);
    }

    /**
     * Adiciona um voo ao bilhete
     * @param voo Voo a ser adicionado
     */
    public void addVoo(Voo voo) {
        this.voos.add(voo);
        this.qtdeVoo = this.voos.size();
    }

    /**
     * Verifica disponibilidade do Bilhete
     */
    public boolean disponivel() {
        return this.cliente == null;
    }

    /**
     * Verifica Voos do bilhete
     */
    public int verificaVoos() {
        return 0;
    }

    /**
     * Vender um bilhete a um cliente específico.
     * @param cliente Cliente específico.
     */
    public void vender(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Alteração da forma como o toString imprime as informações do Bilhete
     */
    public String toString() {
        return "\nID do Bilhete: " + this.idBilhete + "\nVoos: " + this.voos.toString() + "\n Preço: R$" + this.preco + "\nPontos de Fidelidade: " + this.pontosFidelidade + "\nVencimento: " + this.vencimento + "\n _________________________________________";
    }
    //#endregion

    //#region Getters e Setters

    //Getters
    public int getIdBilhete() {
        return this.idBilhete;
    }

    public BigDecimal getPrecoBilheteEmPts() {
        return precoBilheteEmPts;
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
    
    public BigDecimal getPreco() {
        return preco;
    }

    //setters
    public void setPrecoBilheteEmPts(BigDecimal precoBilheteEmPts) {
        this.precoBilheteEmPts = precoBilheteEmPts;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    //#endregion
}
