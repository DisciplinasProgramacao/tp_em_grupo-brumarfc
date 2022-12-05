package org.puc.core.voo;

import java.io.Serializable;
import java.util.List;

public class Trecho implements Serializable{

    // #region atributos
    // atributos
    private int idTrecho;
    private static int incrementoTrecho = 0;
    private String destino;
    private String origem;
    private List<String> voo;
    //#endregion

    // #region Construtor
    /**
     * Cria um novo trecho a partir de sua origem e seu destino.
     * @param origem Local de origem
     * @param destino Local de destino
     */
    public Trecho (String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        this.idTrecho = incrementoTrecho ++;
    }
    //#endregion

    //#region Métodos de funcionamento

    public Voo gerarVoo(Voo voo) {
        return null;
    }

    /**
     * Formata a forma que será impresso as informações do Trecho
     */
    public String toString(){
        return "\n Origem: " + this.origem + "\n Destino: " + this.destino;
    }
    //#endregion
    
    //#region Getters
    public int getIdTrecho() {
        return this.idTrecho;
    }

    public String getDestino() {
        return destino;
    }
    //#endregion

}
