package org.puc.core.boost;

import java.math.BigDecimal;

public class TicketBooster {

    // #region atributos
    // atributos
    private String boostName;
    private BigDecimal cost;
    private BigDecimal boost;
    //#endregion

    public TicketBooster(Type typeBooster) {
        this.boostName = typeBooster.longName;
        this.cost = typeBooster.cost;
        this.boost = typeBooster.boost;
    }

    public TicketBooster() {
    }

    //#region getters
    public String getBoostName() {
        return boostName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getBoost() {
        return boost;
    }
    //#endregion
}
