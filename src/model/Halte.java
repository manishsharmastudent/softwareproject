package model;

import controller.TimeParseController;

import java.time.LocalDateTime;

/**
 * Created by Ontlener on 14/11/2016.
 */
public class Halte {

    private String name;
    private LocalDateTime Arrival;
    private LocalDateTime ActualArrival;
    private LocalDateTime Departure;
    private LocalDateTime ActualDeparture;
    private int departurePlatform;

    public Halte(String name, int departurePlatform) {
        super();
        this.name = name;
        this.departurePlatform = departurePlatform;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public LocalDateTime getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = TimeParseController.getTime(arrival);
    }

    public LocalDateTime getActualArrival() {
        return ActualArrival;
    }

    public void setActualArrival(String actualArrival) {
        ActualArrival = TimeParseController.getTime(actualArrival);
    }

    public LocalDateTime getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = TimeParseController.getTime(departure);
    }

    public LocalDateTime getActualDeparture() {
        return ActualDeparture;
    }

    public void setActualDeparture(String actualDeparture) {
        ActualDeparture = TimeParseController.getTime(actualDeparture);
    }

    public int getDeparturePlatform ()
    {
        return departurePlatform;
    }

    public void setDeparturePlatform (int departurePlatform)
    {
        this.departurePlatform = departurePlatform;
    }

    public String getDelay(){
        return TimeParseController.getDelay(getDeparture(),getActualDeparture());
    }

    @Override
    public String toString() {
        return "Halte{" +
                "name='" + name + '\'' +
                ", arrivalPlatform=" +
                ", departurePlatform=" + departurePlatform +
                '}';
    }
}
