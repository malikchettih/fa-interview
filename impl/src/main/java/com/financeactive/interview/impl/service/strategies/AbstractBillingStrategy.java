package com.financeactive.interview.impl.service.strategies;

import com.financeactive.interview.api.model.BilledTime;
import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;
import com.financeactive.interview.impl.service.BillingStrategy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Abstract Billing strategy. Hold the common parts of the billing algorithm.
 * 
 * The algorithms consists of :
 * <ul>
 *     <li>Computing the billed time, number of hours and number of minutes between the starting time and the end time of the parking.</li>
 *     <li>Computation of the fees, 1rst hour free of charge, then 2 euros for one hours between 2 and 4 hours of parking, then 1.5 euros for each 1/2 hours.</li>
 *     <li>Applying a fixed rate on the price, the type of vehicle and the used fuel is fixing the rate</li>
 *     <li>Applying a rounding to the upper half, 1.49 become 1.5 and 1.99 become 2</li>
 * </ul>
 * 
 * BigDecimal are used for the computation for the precision and the utlities methods that provides this method.
 * @see java.math.BigDecimal 
 */
public abstract class AbstractBillingStrategy implements BillingStrategy {

    private final static BigDecimal PRICE_FOR_HOURS = new BigDecimal(2);
    private final static BigDecimal PRICE_FOR_HALF_HOURS = new BigDecimal("1.5");
    
    @Override
    public ParkingBill bill(ParkingTicket ticket, LocalDateTime outTime){
        
        BilledTime billedTime = computeBilledTime(ticket.getInTime(), outTime);
        BigDecimal fees = computeFees(billedTime);
        fees = applyVariation(fees);
        fees = roundUpHalf(fees);
        
        ParkingBill bill = new ParkingBill(ticket, outTime);
        bill.setBilledTime(billedTime);
        bill.setFee(fees);
        return bill;
    }
    
    protected BigDecimal getPricePerHour(){
        return PRICE_FOR_HOURS;
    }
    
    protected BigDecimal getPricePerHalfHour(){
        return PRICE_FOR_HALF_HOURS;
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
        BigDecimal amount = new BigDecimal(Math.min(billedTime.getHours(), 3)).multiply(getPricePerHour()).add(new BigDecimal(nbHalfHourAfter4Hours).multiply(getPricePerHalfHour()));
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

    /**
     * Return the price variation rate for a strategy. 
     * @return
     */
    public abstract BigDecimal getVariation();
    
}
