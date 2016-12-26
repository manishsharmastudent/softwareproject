package model;

import util.TimeParseUtil;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Ontlener on 14/11/2016.
 */
public class Halte implements Serializable {

    private String name;
    private LocalDateTime Arrival;
    private LocalDateTime ActualArrival;
    private LocalDateTime Departure;
    private LocalDateTime ActualDeparture;
    private String departurePlatform;
    private String aankomstPlatform;
    private String coordinaten;

    public Halte(){}

    public Halte(String name, String departurePlatform) {
        super();
        this.name = name;
        this.departurePlatform = departurePlatform;
    }

    public void setArrival(LocalDateTime arrival) {
        Arrival = arrival;
    }

    public void setActualArrival(LocalDateTime actualArrival) {
        ActualArrival = actualArrival;
    }

    public void setDeparture(LocalDateTime departure) {
        Departure = departure;
    }

    public void setActualDeparture(LocalDateTime actualDeparture) {
        ActualDeparture = actualDeparture;
    }

    public String getCoordinaten() {
        return coordinaten;
    }

    public void setCoordinaten(String coordinaten) {
        this.coordinaten = coordinaten;
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
        Arrival = TimeParseUtil.getTime(arrival);
    }

    public LocalDateTime getActualArrival() {
        return ActualArrival;
    }

    public void setActualArrival(String actualArrival) {
        ActualArrival = TimeParseUtil.getTime(actualArrival);
    }

    public LocalDateTime getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = TimeParseUtil.getTime(departure);
    }

    public LocalDateTime getActualDeparture() {
        return ActualDeparture;
    }

    public void setActualDeparture(String actualDeparture) {
        ActualDeparture = TimeParseUtil.getTime(actualDeparture);
    }

    public String getAankomstPlatform() {
        return aankomstPlatform;
    }

    public void setAankomstPlatform(String aankomstPlatform) {
        this.aankomstPlatform = aankomstPlatform;
    }

    public String getDeparturePlatform ()
    {
        return departurePlatform;
    }

    public void setDeparturePlatform (String departurePlatform)
    {
        this.departurePlatform = departurePlatform;
    }

    public String getDelay(){
        return TimeParseUtil.getDelay(getDeparture(),getActualDeparture());
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