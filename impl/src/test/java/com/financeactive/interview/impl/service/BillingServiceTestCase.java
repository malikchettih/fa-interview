package com.financeactive.interview.impl.service;

import static org.junit.Assert.assertEquals;

import com.financeactive.interview.api.IBillingService;
import com.financeactive.interview.api.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BillingServiceTestCase {
    
    protected IBillingService billingService = new BillingService();
    
    @Test
    public void testGasoilCarBilling(){

        LocalDateTime todayAt1324 = LocalDate.now().atTime(13, 24);
        LocalDateTime todayAt1510 = LocalDate.now().atTime(15, 10);

        Vehicle vehicle = new Vehicle(VehicleType.CAR, Fuel.GASOLINE);
        ParkingTicket ticket = new ParkingTicket(vehicle, todayAt1324);        

        ParkingBill parkingBill = billingService.bill(ticket, todayAt1510);
        assertEquals(new BigDecimal(2), parkingBill.getFee());
        assertEquals("1h46", parkingBill.getBilledTime().toString());
    }
}
