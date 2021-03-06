package com.financeactive.interview.api.model;

import java.time.LocalDateTime;

/**
 * Parking ticket, holds the parking vehicle and the time of entrance.
 */
public class ParkingTicket {
    
    private Vehicle vehicle;
    private LocalDateTime inTime;

    public ParkingTicket(Vehicle vehicle, LocalDateTime inTime) {
        this.vehicle = vehicle;
        this.inTime = inTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalDateTime inTime) {
        this.inTime = inTime;
    }
}
