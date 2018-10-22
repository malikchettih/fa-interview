package com.financeactive.interview.impl.service;

import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;

import java.time.LocalDateTime;

/**
 * Billing Strategy interface for a Vehicle.
 * 
 * @see com.financeactive.interview.api.model.ParkingTicket
 * @see java.time.LocalDateTime
 */
public interface BillingStrategy {

    /**
     * Return a parking bill after computing the billing fees using the ticket and the exit time parameters. 
     * p
     * @param ticket the issued ticket
     * @param outTime the exit time.
     * @return com.financeactive.interview.api.model.ParkingBill
     */
    public ParkingBill bill(ParkingTicket ticket, LocalDateTime outTime);
}
