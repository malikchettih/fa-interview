package com.financeactive.interview.impl.service;

import com.financeactive.interview.api.model.*;
import com.financeactive.interview.impl.service.strategies.BikeBillingStrategy;
import com.financeactive.interview.impl.service.strategies.GasolineCarBillingStrategy;
import com.financeactive.interview.impl.service.strategies.LGPCarBillingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BillingContext {

    private static Map<Vehicle, BillingStrategy> vehicleBillingStrategies = new HashMap<>();

    static{
        vehicleBillingStrategies.put(new Vehicle(VehicleType.CAR, Fuel.GASOLINE), new GasolineCarBillingStrategy());
        vehicleBillingStrategies.put(new Vehicle(VehicleType.CAR, Fuel.LGP), new LGPCarBillingStrategy());
        vehicleBillingStrategies.put(new Vehicle(VehicleType.BIKE), new BikeBillingStrategy());
    }

    protected BillingStrategy billingStrategy;

    public void setStrategy(Vehicle vehicle){
        this.billingStrategy = vehicleBillingStrategies.get(vehicle);
    }
    
    public ParkingBill execute(ParkingTicket ticket, LocalDateTime outTime){
        ParkingBill bill = this.billingStrategy.bill(ticket, outTime);
        return bill;
    }
    
}
