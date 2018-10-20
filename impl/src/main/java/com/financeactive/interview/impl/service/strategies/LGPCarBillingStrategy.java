package com.financeactive.interview.impl.service.strategies;

import java.math.BigDecimal;

public class LGPCarBillingStrategy extends AbstractBillingStrategy{

    public BigDecimal getVariation(){
        return BigDecimal.valueOf(0.07);
    }
}
