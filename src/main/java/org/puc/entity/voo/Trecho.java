package org.puc.entity.voo;

import java.util.ArrayList;
import java.util.List;

public class Trecho {
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
}
