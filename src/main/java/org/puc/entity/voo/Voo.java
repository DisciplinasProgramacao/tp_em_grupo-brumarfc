package org.puc.entity.voo;

import org.puc.entity.bilhete.Bilhete;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;

public class Voo {
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
   
}
