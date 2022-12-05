package org.puc.core.voo;

import org.puc.core.bilhete.Bilhete;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Voo implements Serializable {

    // #region atributos
    // atributos
    private int idVoo;
    private static int incrementoVoo = 0;
    private LinkedList<Trecho> trechos;
    private Date data;
    private ArrayList<Bilhete> passagens;
    private BigDecimal precoBase;
    // #endregion

    // #region Construtor

    /**
     * Construtor simples: Cria um voo.
     */
    public Voo() {
    }

    public Voo(Date data) {
    /**
     * Construtor: Cria um voo para uma data específica.
     * 
     * @param data data do voo.
     */
        this.data = data;
        this.idVoo = incrementoVoo++;
        trechos = new LinkedList<Trecho>();
    }
    // #endregion

    // #region Métodos de funcionamento

    /**
     * Adiciona um trecho ao voo
     * 
     * @param trecho trecho a ser adicionado
     */
    public void addTrecho(Trecho trecho) {
        this.trechos.add(trecho);
    }

    /**
     * Formata a forma que será impresso as informações do Voo
     */
    public String toString() {
        return "\nData: " + this.data + "\nTrechos: " + this.trechos.toString() + "\n Preço trecho: R$" + this.precoBase
                + "\n _________________________________________";
    }

    // #region Getters
    public BigDecimal getPrecoBase() {
        return this.precoBase;
    }

    public ArrayList<Bilhete> getPassagens() {
        return passagens;
    }

    public LinkedList<Trecho> getTrechos() {
        return trechos;
    }

    public Date getData() {
        return data;
    }

    public int getIdVoo() {
        return idVoo;
    }
    // #endregion
}
