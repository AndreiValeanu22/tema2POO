package org.example;

import java.time.LocalDateTime;

public class Airplane {
    private String model;
    private String flightID;
    private String departure;
    private String destination;
    private LocalDateTime desiredTakeoffTime;
    private LocalDateTime actualTakeoffTime;
    private Status status;

    public Airplane(String model, String flightID, String departure, String destination) {
        this.model = model;
        this.flightID = flightID;
        this.departure = departure;
        this.destination = destination;
        this.status = Status.WAITING_FOR_TAKEOFF;
    }

    public String toString() {
        return model + " - " + flightID + " - " + departure + " - " + destination + " - " + status + " - " + desiredTakeoffTime
                + " - " + actualTakeoffTime;
    }

}
