package models;

import parsers.TimeParser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class StationStop {

	private String name;
	private LocalDateTime Arrival;
    private LocalDateTime ActualArrival;
    private LocalDateTime Departure;
    private LocalDateTime ActualDeparture;
    private int arrivalPlatform;
    private int departurePlatform;
    private String coordinates;

    public StationStop(String name, int arrivalPlatform, int departurePlatform, String coordinates) {
        super();
        this.name = name;
        this.arrivalPlatform = arrivalPlatform;
        this.departurePlatform = departurePlatform;
        this.coordinates = coordinates;
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
        Arrival = TimeParser.getTime(arrival);
    }

    public LocalDateTime getActualArrival() {
        return ActualArrival;
    }

    public void setActualArrival(String actualArrival) {
        ActualArrival = TimeParser.getTime(actualArrival);
    }

    public LocalDateTime getDeparture() {
        return Departure;
    }

    public void setDeparture(String departure) {
        Departure = TimeParser.getTime(departure);
    }

    public LocalDateTime getActualDeparture() {
        return ActualDeparture;
    }

    public void setActualDeparture(String actualDeparture) {
        ActualDeparture = TimeParser.getTime(actualDeparture);
    }

    public int getArrivalPlatform ()
    {
        return arrivalPlatform;
    }

    public void setArrivalPlatform (int arrivalPlatform)
    {
        this.arrivalPlatform = arrivalPlatform;
    }

    public int getDeparturePlatform ()
    {
        return departurePlatform;
    }

    public void setDeparturePlatform (int departurePlatform)
    {
        this.departurePlatform = departurePlatform;
    }

    public String getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (String coordinates)
    {
        this.coordinates = coordinates;
    }

    public String getDelay(){
        return TimeParser.getDelay(getDeparture(),getActualDeparture());
    }

}
