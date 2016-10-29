package model;

import java.util.Date;

/**
 * Created by Manish on 23/10/2016.
 */
public class Abonnement {
   // private Korting korting;
    private Date beginDatum;
    private Date vervalDatum;
//  private Route routes;
// private Klant klant;
    // private Float prijs;

    public Date getbeginDatum(){
        return this.beginDatum;
    }
    public Date getVervalDatum(){
        return this.vervalDatum;
    }
    public void setBeginDatum(Date datum){
        this.beginDatum = datum;
    }
    public void setVervalDatum(Date datum){
        this.vervalDatum = datum;
    }
}
