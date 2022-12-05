package org.puc.entity.voo;

import org.puc.entity.bilhete.Bilhete;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;

public class Voo implements Serializable{
    private int idVoo;
    private static int incrementoVoo = 0;
    private LinkedList<Trecho> trechos;
    private String data;
    private ArrayList<Bilhete> passagens;
    private BigDecimal precoBase;

    public Voo(String data) {
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

    public String toString(){
        return "\nData: " + this.data + "\nTrechos: " + this.trechos.toString() + "\n Preço trecho: R$" + this.precoBase + "\n _________________________________________";
    }
   
}
