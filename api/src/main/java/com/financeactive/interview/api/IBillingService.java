package com.financeactive.interview.api;

import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;

import java.time.LocalDateTime;
import java.util.Date;

public interface IBillingService {
    
    public ParkingBill bill(ParkingTicket ticket);

    public ParkingBill bill(ParkingTicket ticket, LocalDateTime outTime);
}
