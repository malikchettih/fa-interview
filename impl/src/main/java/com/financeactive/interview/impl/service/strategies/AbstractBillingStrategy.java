package com.financeactive.interview.impl.service.strategies;

import com.financeactive.interview.api.model.BilledTime;
import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;
import com.financeactive.interview.impl.service.BillingStrategy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class AbstractBillingStrategy implements BillingStrategy {

    public void compute(ParkingBill bill){
        
        BilledTime billedTime = computeBilledTime(bill.getTicket().getInTime(), bill.getOutTime());
        bill.setBilledTime(billedTime);
    }
    
    protected BilledTime computeBilledTime(LocalDateTime inTime, LocalDateTime outTime){
        
        long hours = inTime.until(outTime, ChronoUnit.HOURS);
        long minutes = inTime.until(outTime, ChronoUnit.MINUTES) - (hours*60);
        return new BilledTime(Math.toIntExact(hours), Math.toIntExact(minutes));
        
    }
    
    
}
