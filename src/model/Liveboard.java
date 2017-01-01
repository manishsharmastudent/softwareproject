package model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by nofel.tiani on 5/12/2016.
 */
public class Liveboard implements Serializable {
    private Station station;
    private Boolean live = false;
    private LocalDateTime timeVersion;
    private String exception;




//test2

    //test
    private String jsonException;

    public Liveboard(Station station, Boolean live, LocalDateTime tv) {
        this.station = station;
        this.live = live;
        this.timeVersion = tv;
    }

    public Liveboard(Station station, LocalDateTime tv) {
        this.station = station;
        this.timeVersion = tv;
    }

    public Liveboard() {
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public LocalDateTime getTimeVersion() {
        return timeVersion;
    }

    public void setTimeVersion(LocalDateTime timeVersion) {
        this.timeVersion = timeVersion;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getJsonException() {
        return jsonException;
    }

    public void setJsonException(String jsonException) {
        this.jsonException = jsonException;
    }
}