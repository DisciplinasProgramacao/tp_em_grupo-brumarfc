package org.puc.core.cia;

import org.puc.core.bilhete.Bilhete;
import org.puc.core.bilhete.BilheteFidelidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;

public class Cliente implements Serializable {

    // #region atributos
    // atributos
    private int idCliente;
    private BigDecimal qtdePontos;
    private String nome;
    private String cpf;
    private Date aniversario;
    private LinkedList<Bilhete> viagens;

    // #endregion

    // #region Construtor

    /**
     * Contrutor simples: Cria um novo cliente, o atribui pontos de fidelidade igual a zero e a uma lista de bilhetes.
     * @param nom Nome do cliente
     * @param cpf CPF do cliente
     * @param aniversario Data de aniversario do cliente
     * @param id Identificador do cliente
     */
    public Cliente (String nom, String cpf, Date aniversario, int id){
        this.nome = nom;
        this.cpf = cpf;
        this.aniversario = aniversario;
        this.idCliente = id;
        this.qtdePontos = new BigDecimal(0);
        viagens = new LinkedList<Bilhete>();
    }
    // #endregion

    // #region Métodos de funcionamento

    /**
     * Efetua a compra de um Bilhete, vincula o bilhete ao cliente e adiciona o bilhete na sua lista de viagens
     *
     * @param bilhete  bilhete a ser adquirido
     * @param useBoost
     * @return Preço a ser pago
     * @throws Exception
     */
    public BigDecimal comprarBilhete(Bilhete bilhete, String useBoost) throws Exception{
        BigDecimal preco;
        if (bilhete instanceof BilheteFidelidade) {
            if (this.qtdePontos.intValue() < bilhete.getPrecoBilheteEmPts().intValue())  {
                throw (new Exception("Quantidade de pontos insuficiente"));
            }
            preco = BigDecimal.ZERO;
            this.qtdePontos = this.qtdePontos.subtract(this.qtdePontos);
        }
        else {
            if (useBoost.equalsIgnoreCase("s")) {
                BigDecimal boost = bilhete.getAcelerador();
                BigDecimal priceBoost = bilhete.getPrecoAcelerador();
                this.qtdePontos = this.qtdePontos.add(bilhete.calcularPontos(bilhete)).multiply(boost);
                preco = bilhete.getPreco().add(priceBoost);
            } else {
                this.qtdePontos = this.qtdePontos.add(bilhete.calcularPontos(bilhete));
                preco = bilhete.getPreco();
            }
        }
        viagens.add(bilhete);
        bilhete.vender(this);
        return preco;
    }

    /**
     * recupera o identificador do cliente
     * @return Identificador do cliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    public BigDecimal getQtdePontos() {
        return qtdePontos;
    }

    public LinkedList<Bilhete> getViagens() {
        return viagens;
    }

    /**
     * Gera um relatório com os detalhes pertinentes ao cliente.
     * @return relatório formatado com as informações do cliente e suas viagens.
     */
    public String relatorio(){
        return "ID do Cliente: " + this.idCliente + "\nNome: " + this.nome + "\nCPF: " + this.cpf + "\nAniversário: " + this.aniversario + "\nViagens: " + this.viagens.toString();    
    }
    //#endregion
}

