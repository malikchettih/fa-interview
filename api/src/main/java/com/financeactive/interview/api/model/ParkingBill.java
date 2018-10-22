package com.financeactive.interview.api.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Parking Bill, hold a reference to the isseud ticket and provides outTime, billed time and computed fees.
 * 
 * @see java.time.LocalDateTime
 * @see java.math.BigDecimal 
 * @see com.financeactive.interview.api.model.ParkingTicket
 * @see com.financeactive.interview.api.model.BilledTime
 */
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
    
    public String toString(){
        
        StringBuffer buffer = new StringBuffer("\n");
        buffer.append("- véhicule : "+ticket.getVehicle().getVehicleType().getLabel()+" "+ticket.getVehicle().getFuel().getLabel()+"\n");
        buffer.append("- temps passé : "+billedTime+"\n");
        NumberFormat format = NumberFormat.getNumberInstance(Locale.FRENCH);
        buffer.append("- montant dû : "+format.format(fee)+" euros \n");
        return buffer.toString();
    }
}
