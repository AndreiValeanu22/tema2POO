package org.example;

public class WideBodyAirplane extends Airplane {
    private int numberOfEngines;

    public WideBodyAirplane(String model, String flightID, String departure, String destination, int numberOfEngines) {
        super(model, flightID, departure, destination);
        this.numberOfEngines = numberOfEngines;
    }
    @Override
    public String toString() {
        return "Wide Body - " + super.toString() + " - " + numberOfEngines;
    }
}
