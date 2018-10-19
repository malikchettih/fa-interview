package com.financeactive.interview.impl.service;

import com.financeactive.interview.api.IBillingService;
import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class BillingService implements IBillingService {
    
    @Override
    public ParkingBill bill(ParkingTicket ticket) {
        return bill(ticket, LocalDateTime.now());
    }

    @Override
    public ParkingBill bill(ParkingTicket ticket, LocalDateTime outTime) {
        
        ParkingBill bill = new ParkingBill(ticket, outTime);
        BillingStrategy billingStrategy = BillingStrategyProvider.provide(ticket.getVehicle());
        billingStrategy.compute(bill);
        return bill;
    }
}
