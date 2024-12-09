package org.example;

public class NarrowBodyAirplane extends Airplane {
    private int numberOfEngines;

    public NarrowBodyAirplane(String model, String flightID, String departure, String destination, int numberOfEngines) {
        super(model, flightID, departure, destination);
        this.numberOfEngines = numberOfEngines;
    }
    @Override
    public String toString() {
        return "Narrow Body - " + super.toString() + " - " + numberOfEngines;
    }
}
