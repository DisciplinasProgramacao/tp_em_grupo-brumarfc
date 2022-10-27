package org.puc.entity.voo;

import org.puc.entity.bilhete.Bilhete;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

public class Voo {
    private int idVoo;
    private int idTrecho;
    private Date data;
    private ArrayList<Bilhete> passagens;

    private BigDecimal precoBase;

    public BigDecimal getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(BigDecimal precoBase) {
        this.precoBase = precoBase;
    }

    public Voo addBilhete(Bilhete bilhete) {
        return null;
    }

    public void setIdVoo(int idVoo) {
        this.idVoo = idVoo;
    }

    public void setIdTrecho(int idTrecho) {
        this.idTrecho = idTrecho;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setPassagens(ArrayList<Bilhete> passagens) {
        this.passagens = passagens;
    }

    public int getIdVoo() {
        return idVoo;
    }

    public int getIdTrecho() {
        return idTrecho;
    }

    public Date getData() {
        return data;
    }

    public ArrayList<Bilhete> getPassagens() {
        return passagens;
    }
}
