package model;

import java.time.LocalDateTime;

/**
 * Created by nofel.tiani on 5/12/2016.
 */
public class Liveboard {
    private Station station;
    private Boolean live;
    private LocalDateTime timeVersion;

    public Liveboard(Station station, Boolean live, LocalDateTime tv) {
        this.station = station;
        this.live = live;
        this.timeVersion = tv;
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
}
