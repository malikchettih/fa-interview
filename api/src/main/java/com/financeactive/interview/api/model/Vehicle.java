package com.financeactive.interview.api.model;

import com.google.common.base.Objects;

/**
 * Vehicle, holds the type of the vehicle and the type of fuel that is used by the vehicle.
 * 
 * @see com.financeactive.interview.api.model.VehicleType
 * @see com.financeactive.interview.api.model.Fuel
 */
public class Vehicle {
    
    private VehicleType vehicleType;
    private Fuel fuel;


    public Vehicle (VehicleType vehicleType){
        super();
        this.vehicleType = vehicleType;
        this.fuel = Fuel.GASOLINE;
    }
    
    public Vehicle (VehicleType vehicleType, Fuel fuel){
        super();
        this.vehicleType = vehicleType;
        this.fuel = fuel;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleType == vehicle.vehicleType &&
                fuel == vehicle.fuel;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(vehicleType, fuel);
    }
}
