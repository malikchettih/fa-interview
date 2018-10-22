package com.financeactive.interview.api.model;

/**
 * Enumeration of the allowed vehicle types in the parking.
 */
public enum VehicleType {
    CAR("voiture"), BIKE("moto");
    
    protected String label;
    
    VehicleType(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return this.label;
    }
    
}
