package org.puc.core.boost;

import java.math.BigDecimal;

public class TicketBooster {
    private String boostName;
    private BigDecimal cost;
    private BigDecimal boost;

    public TicketBooster(Type typeBooster) {
        this.boostName = typeBooster.longName;
        this.cost = typeBooster.cost;
        this.boost = typeBooster.boost;
    }

    public TicketBooster( ) {
    }

    public String getBoostName() {
        return boostName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getBoost() {
        return boost;
    }
}
