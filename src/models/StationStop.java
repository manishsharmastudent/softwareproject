package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StationStop {

	private String name;

	private Time time;

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

    public Time getTime ()
    {
        return time;
    }

    public void setTime (String timeString)
    {
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
/*
    public null getPlatform ()
    {
        return platform;
    }

    public void setPlatform (null Platform)
    {
        this.platform = platform;
    }
*/
    public String getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (String coordinates)
    {
        this.coordinates = coordinates;
    }
/*
    @Override
    public String toString()
    {
    }
	*/
}
