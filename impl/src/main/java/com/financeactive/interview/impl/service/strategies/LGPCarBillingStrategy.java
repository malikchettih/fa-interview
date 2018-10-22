package com.financeactive.interview.impl.service.strategies;

import java.math.BigDecimal;

/**
 * Concret implementation of the billing strategy for LGP cars.
 */
public class LGPCarBillingStrategy extends AbstractBillingStrategy{

    private final static String LGP_CAR_VARIATION_RATE = "-0.5";
    
    public BigDecimal getVariation(){
        return new BigDecimal("0.07");
    }
}
