package com.financeactive.interview.impl.service;

import static org.junit.Assert.assertEquals;

import com.financeactive.interview.api.IBillingService;
import com.financeactive.interview.api.model.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class BillingServiceTestCase {
    
    protected IBillingService billingService = new BillingService();
    
    @Test
    public void testGasoilCarBilling(){

        LocalDateTime startTime = LocalDate.now().atTime(13, 24);
        LocalDateTime endTime = LocalDate.now().atTime(15, 10);

        Vehicle vehicle = new Vehicle(VehicleType.CAR, Fuel.GASOLINE);
        ParkingTicket ticket = new ParkingTicket(vehicle, startTime);        

        ParkingBill parkingBill = billingService.bill(ticket, endTime);
        assertEquals("1h46", parkingBill.getBilledTime().toString());
        assertEquals(new BigDecimal(2), parkingBill.getFee());
        
    }

    @Test
    public void testBikeBilling(){

        LocalDateTime startTime = LocalDate.now().atTime(19, 30);
        LocalDateTime endTime = LocalDate.now().atTime(00, 37);
        endTime = endTime.plus(1, ChronoUnit.DAYS);

        Vehicle vehicle = new Vehicle(VehicleType.BIKE);
        ParkingTicket ticket = new ParkingTicket(vehicle, startTime);

        ParkingBill parkingBill = billingService.bill(ticket, endTime);
        assertEquals("5h07", parkingBill.getBilledTime().toString());
        assertEquals(new BigDecimal(5.5), parkingBill.getFee());

    }

    @Test
    public void testLGPCarBilling(){

        LocalDateTime startTime = LocalDate.now().atTime(7, 43);
        LocalDateTime endTime = LocalDate.now().atTime(15, 10);

        Vehicle vehicle = new Vehicle(VehicleType.CAR, Fuel.LGP);
        ParkingTicket ticket = new ParkingTicket(vehicle, startTime);

        ParkingBill parkingBill = billingService.bill(ticket, endTime);
        assertEquals("7h27", parkingBill.getBilledTime().toString());
        assertEquals(new BigDecimal(18), parkingBill.getFee());

    }
}
