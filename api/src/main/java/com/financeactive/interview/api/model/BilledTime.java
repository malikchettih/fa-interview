package com.financeactive.interview.api.model;

import java.util.Date;

/**
 * Wrapper class, hodling hours and minutes spent in the parking.
 */
public class BilledTime {
    
    private int minutes;
    private int hours;
    
    public BilledTime(){
        super();
    }

    public BilledTime(int minutes, int hours){
        super();
        this.hours = hours;
        this.minutes = minutes;
    }
    

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * Format the billed time to 00h00 String.
     * @return java.lang.String
     */
    public String toString(){
        return String.format("%dh%02d", hours, minutes);
    }
}
