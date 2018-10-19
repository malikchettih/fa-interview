package com.financeactive.interview.impl.service;

import com.financeactive.interview.api.model.Fuel;
import com.financeactive.interview.api.model.Vehicle;
import com.financeactive.interview.api.model.VehicleType;
import com.financeactive.interview.impl.service.strategies.BikeBillingStrategy;
import com.financeactive.interview.impl.service.strategies.GasolineCarBillingStrategy;
import com.financeactive.interview.impl.service.strategies.LGPCarBillingStrategy;

import java.util.HashMap;
import java.util.Map;

public class BillingStrategyProvider {

    private static Map<Vehicle, BillingStrategy> vehicleBillingStrategies = new HashMap<>();

    static{
        vehicleBillingStrategies.put(new Vehicle(VehicleType.CAR, Fuel.GASOLINE), new GasolineCarBillingStrategy());
        vehicleBillingStrategies.put(new Vehicle(VehicleType.CAR, Fuel.LGP), new LGPCarBillingStrategy());
        vehicleBillingStrategies.put(new Vehicle(VehicleType.BIKE), new BikeBillingStrategy());
        
    }
    
    public static BillingStrategy provide(Vehicle vehicle){
        return vehicleBillingStrategies.get(vehicle);
    }
    
}
