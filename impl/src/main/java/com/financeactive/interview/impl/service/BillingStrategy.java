package com.financeactive.interview.impl.service;

import com.financeactive.interview.api.model.ParkingBill;
import com.financeactive.interview.api.model.ParkingTicket;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public interface BillingStrategy {
    
    public void compute(ParkingBill parkingBill);
}
