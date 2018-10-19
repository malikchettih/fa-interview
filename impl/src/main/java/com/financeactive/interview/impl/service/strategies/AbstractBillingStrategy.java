package com.financeactive.interview.impl.service.strategies;

import com.financeactive.interview.api.model.ParkingTicket;
import com.financeactive.interview.impl.service.BillingStrategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class AbstractBillingStrategy implements BillingStrategy {

    public BigDecimal compute(ParkingTicket ticket, LocalDateTime outTime){
        return null;
    }
    
    
}
