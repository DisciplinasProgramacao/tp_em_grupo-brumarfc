package org.puc.core.voo;

import java.io.Serializable;
import java.util.List;

public class Trecho implements Serializable{
    private int idTrecho;
    private static int incrementoTrecho = 0;
    private String destino;
    private String origem;
    private List<String> voo;

    public Trecho (String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        this.idTrecho = incrementoTrecho ++;
    }

    public Voo gerarVoo(Voo voo) {
        return null;
    }

    public int getIdTrecho() {
        return this.idTrecho;
    }

    public String getDestino() {
        return destino;
    }

    public String toString(){
        return "\n Origem: " + this.origem + "\n Destino: " + this.destino;
    }
}
