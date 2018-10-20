package com.financeactive.interview.impl.service.strategies;

import com.financeactive.interview.api.model.BilledTime;
import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;
import com.financeactive.interview.impl.service.BillingStrategy;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class AbstractBillingStrategy implements BillingStrategy {

    public void compute(ParkingBill bill){
        
        BilledTime billedTime = computeBilledTime(bill.getTicket().getInTime(), bill.getOutTime());
        BigDecimal fees = computeFees(billedTime);
        fees = applyVariation(fees);
        fees = roundUpHalf(fees);
        
        bill.setBilledTime(billedTime);
        bill.setFee(fees);
    }
    
    protected BilledTime computeBilledTime(LocalDateTime inTime, LocalDateTime outTime){
        
        long hours = inTime.until(outTime, ChronoUnit.HOURS);
        long minutes = inTime.until(outTime, ChronoUnit.MINUTES) - (hours*60);
        return new BilledTime(Math.toIntExact(minutes), Math.toIntExact(hours));
        
    }
    
    protected BigDecimal computeFees(BilledTime billedTime){
        
        if(billedTime.getHours() == 0){
            return BigDecimal.ZERO;
        }
        
        int nbHalfHourAfter4Hours = getNbHalfHoursAfter(billedTime);
        BigDecimal amount = new BigDecimal(Math.min(billedTime.getHours(), 3)*2).add(new BigDecimal(nbHalfHourAfter4Hours).multiply(new BigDecimal("1.5")));
        return amount;
    }
    
    private int getNbHalfHoursAfter(BilledTime billedTime){
        if(billedTime.getHours()<=4){
            return 0;
        }
        int nbCompleteHalfHoursAfter = (((billedTime.getHours()-4)*60)+billedTime.getMinutes())/30;
        boolean oneMore = (((billedTime.getHours()-4)*60)+billedTime.getMinutes())%30 != 0;
        if(oneMore){
            nbCompleteHalfHoursAfter++;
        }
        return nbCompleteHalfHoursAfter;
    }
    
    protected BigDecimal applyVariation(BigDecimal fees){
        BigDecimal variation = getVariation().add(BigDecimal.ONE);
        return fees.multiply(variation);
        
    }
    
    protected BigDecimal roundUpHalf(BigDecimal fees){
        BigDecimal TWO = BigDecimal.valueOf(2);
        BigDecimal feesRoundedUp = fees.multiply(TWO).setScale(0, RoundingMode.UP)
                .divide(TWO, 1, RoundingMode.UNNECESSARY).stripTrailingZeros();;
        return feesRoundedUp;
    }
    
    public abstract BigDecimal getVariation();
    
}
