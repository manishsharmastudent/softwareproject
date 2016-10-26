package models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StationStop {

	public StationStop(String name, int arrivalPlatform, int departurePlatform, String coordinates) {
		super();
		this.name = name;
		this.arrivalPlatform = arrivalPlatform;
		this.departurePlatform = departurePlatform;
		this.coordinates = coordinates;
	}

	private DateFormat dFormat;
	private String name;

	private Time time;

    private int arrivalPlatform;

    private int departurePlatform;

    private String coordinates;

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
		if(timeString.length() == 19)
			dFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
        	Date startDate;
        	try {
				startDate = dFormat.parse(timeString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
