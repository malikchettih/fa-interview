package com.financeactive.interview.impl.service;

import com.financeactive.interview.api.IBillingService;
import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;

import java.time.LocalDateTime;

public class BillingService implements IBillingService {
    
    @Override
    public ParkingBill bill(ParkingTicket ticket) {
        return bill(ticket, LocalDateTime.now());
    }

    @Override
    public ParkingBill bill(ParkingTicket ticket, LocalDateTime outTime) {
        BillingContext context = new BillingContext();
        context.setStrategy(ticket.getVehicle());
        ParkingBill bill = context.execute(ticket, outTime);
        
        return bill;
    }
}
