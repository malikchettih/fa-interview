package com.financeactive.interview.api.model;

import java.util.Date;

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

    public BilledTime(Date inTime){
        super();
        compute(inTime, new Date());
    }
    
    public BilledTime(Date inTime, Date outTime){
        super();
        compute(inTime, outTime);
    }

    protected void compute(Date inTime, Date outTime) {
    
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
    
    public String toString(){
        return String.format("%dh%d", minutes, hours);
    }
}
