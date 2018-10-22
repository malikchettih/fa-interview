package com.financeactive.interview.app;

import com.financeactive.interview.api.IBillingService;
import com.financeactive.interview.api.model.*;
import com.financeactive.interview.impl.service.BillingService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Main class.
 */
public class Main {
    
    
    public static void main(String[] args){
        
        IBillingService billingService = new BillingService();

        LocalDateTime startTime1 = LocalDate.now().atTime(13, 24);
        LocalDateTime endTime1 = LocalDate.now().atTime(15, 10);
        Vehicle vehicle1 = new Vehicle(VehicleType.CAR, Fuel.GASOLINE);
        ParkingTicket ticket1 = new ParkingTicket(vehicle1, startTime1);
        ParkingBill parkingBill1 = billingService.bill(ticket1, endTime1);
        System.out.println(parkingBill1.toString());
        
        LocalDateTime startTime2 = LocalDate.now().atTime(19, 30);
        LocalDateTime endTime2 = LocalDate.now().atTime(00, 37);
        endTime2 = endTime2.plus(1, ChronoUnit.DAYS);
        Vehicle vehicle2 = new Vehicle(VehicleType.BIKE);
        ParkingTicket ticket2 = new ParkingTicket(vehicle2, startTime2);
        ParkingBill parkingBill2 = billingService.bill(ticket2, endTime2);
        System.out.println(parkingBill2.toString());
        
        LocalDateTime startTime3 = LocalDate.now().atTime(7, 43);
        LocalDateTime endTime3 = LocalDate.now().atTime(15, 10);
        Vehicle vehicle3 = new Vehicle(VehicleType.CAR, Fuel.LGP);
        ParkingTicket ticket3 = new ParkingTicket(vehicle3, startTime3);
        ParkingBill parkingBill3 = billingService.bill(ticket3, endTime3);
        System.out.println(parkingBill3.toString());
        

    }
}
