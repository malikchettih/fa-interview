package com.financeactive.interview.impl.service.strategies;

import java.math.BigDecimal;

/**
 * Concret implementation of the billing strategy for Gasoline Cars.
 */
public class GasolineCarBillingStrategy extends AbstractBillingStrategy{

    public BigDecimal getVariation(){
        return BigDecimal.ZERO;
    }
}
