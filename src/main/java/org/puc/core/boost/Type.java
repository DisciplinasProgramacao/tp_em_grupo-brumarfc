package org.puc.core.boost;

import java.math.BigDecimal;

public enum Type {

    /**
     * black booster, para multiplicar o ganho de pontos em 1.5x
     */
    BLACK("Preto", BigDecimal.valueOf(1.5), BigDecimal.valueOf(50)),
    /**
     * silver booster, para multiplicar o ganho de pontos em 1.25x
     */
    SILVER("Prata", BigDecimal.valueOf(1.25), BigDecimal.valueOf(30));

    // #region atributos
    // atributos
    public final String longName;
    public final BigDecimal boost;
    public final BigDecimal cost;
    //#endregion

    // #region Métodos de funcionamento
    /**
     * @param longName  nome do booster
     * @param boost valor do boost
     * @param cost  custo do boost
     */
    Type(String longName, BigDecimal boost, BigDecimal cost) {
        this.longName = longName;
        this.boost = boost;
        this.cost = cost;
    }
    //#endregion
}
