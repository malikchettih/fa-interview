package com.financeactive.interview.api;

import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;

import java.time.LocalDateTime;

/**
 * Billing service interface. Provides 2 methods for billing using as parameter a parking ticket and a out time.
 * The second where the out time is not specified and is equal tu systime.
 */
public interface IBillingService {

    /**
     * Compute the billing fees regarding the informations that are provided in the parking ticket. Out time will 
     * set to systime.
     * 
     * @see  com.financeactive.interview.api.model.ParkingTicket 
     * @param ticket the issued ticket
     * @return com.financeactive.interview.api.model.ParkingBill
     */
    public ParkingBill bill(ParkingTicket ticket);

    /**
     * Compute the billing fees regarding the informations that are provided in the parking ticket and a provided out 
     * time.
     *
     * @see  com.financeactive.interview.api.model.ParkingTicket
     * @param ticket the issued ticket
     * @param outTime the exit time.               
     * @return com.financeactive.interview.api.model.ParkingBill
     */
    public ParkingBill bill(ParkingTicket ticket, LocalDateTime outTime);
}
