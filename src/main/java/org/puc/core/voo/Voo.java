package org.puc.core.voo;

import org.puc.core.bilhete.Bilhete;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Voo implements Serializable{
    private int idVoo;
    private static int incrementoVoo = 0;
    private LinkedList<Trecho> trechos;
    private Date data;
    private ArrayList<Bilhete> passagens;
    private BigDecimal precoBase;

    public Voo() {
    }

    public Voo(Date data) {
        this.data = data;
        this.idVoo = incrementoVoo ++;
        trechos = new LinkedList<Trecho>();
    }

    public void addTrecho(Trecho trecho) {
        this.trechos.add(trecho);
    }

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
    public String toString(){
        return "\nData: " + this.data + "\nTrechos: " + this.trechos.toString() + "\n Preço trecho: R$" + this.precoBase + "\n _________________________________________";
    }
   
}
