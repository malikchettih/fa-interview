package com.financeactive.interview.api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParkingBill {
    
    private ParkingTicket ticket;
    private LocalDateTime outTime;
    private BilledTime billedTime;
    private BigDecimal fee;

    public ParkingBill(ParkingTicket ticket, LocalDateTime outTime) { 
        this.ticket = ticket;
        this.outTime = outTime;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    public LocalDateTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDateTime outTime) {
        this.outTime = outTime;
    }

    public BilledTime getBilledTime() {
        return billedTime;
    }

    public void setBilledTime(BilledTime billedTime) {
        this.billedTime = billedTime;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}
