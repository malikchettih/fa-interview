package com.financeactive.interview.impl.service.strategies;

import java.math.BigDecimal;

/**
 * Concret implementation of the billing strategy for Bikes.
 */
public class BikeBillingStrategy extends AbstractBillingStrategy{

    
    private final static String BIKE_VARIATION_RATE = "-0.5";
    
    public BigDecimal getVariation(){
        return new BigDecimal(BIKE_VARIATION_RATE);
    }
}
