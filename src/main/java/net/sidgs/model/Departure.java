package net.sidgs.model;

/**
 * Created by annapureddy on 1/23/2018.
 * it will process Departure Data
 */
public class Departure {
    String flightId;
    String flightgate;
    String destination;
    String flightTime;

    public Departure(String flightId, String flightgate, String destination, String flightTime) {
        this.flightId = flightId;
        this.flightgate = flightgate;
        this.destination = destination;
        this.flightTime = flightTime;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightgate() {
        return flightgate;
    }

    public void setFlightgate(String flightgate) {
        this.flightgate = flightgate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departure departure = (Departure) o;

        return flightId.equals(departure.flightId);
    }

    @Override
    public int hashCode() {
        return flightId.hashCode();
    }
}
