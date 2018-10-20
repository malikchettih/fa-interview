package com.financeactive.interview.impl.service.strategies;

import java.math.BigDecimal;

public class GasolineCarBillingStrategy extends AbstractBillingStrategy{

    public BigDecimal getVariation(){
        return BigDecimal.ZERO;
    }
}
