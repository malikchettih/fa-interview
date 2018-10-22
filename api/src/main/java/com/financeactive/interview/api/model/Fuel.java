package com.financeactive.interview.api.model;

/**
 * Enumeration of the allowed fuels in the parking.
 */
public enum Fuel {
    
    GASOLINE("essence"), LGP("GPL");

    protected String label;

    Fuel(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }
}
