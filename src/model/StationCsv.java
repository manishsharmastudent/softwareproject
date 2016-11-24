package model;

import java.util.List;

/**
 * Created by Rik Van Belle on 24/11/2016.
 */
public class StationCsv {
        private String log;
        private String alt;
        private String naam;

        public StationCsv() {
        }
        public String getNaam(){
            return this.naam;
        }
        public void setNaam(String naam){
            this.naam = naam;
        }
        public String getAlt(){
            return this.alt;
        }
        public void setAlt(String alt){
            this.alt = alt;
        }
        public String getLog(){
            return this.log;
        }
        public void setLog(String log) {
            this.log = log;
        }
}
