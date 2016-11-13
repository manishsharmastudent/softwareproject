package controller;

import java.util.Date;
import model.Abonnement;
import model.Korting;
import model.Route;
import model.Klant;
import view.AbonnementView;
/**
 * Created by Robbe on 06/11/2016.
 */
public class AbonnementController {
    private Abonnement abonnementModel;
    private AbonnementView abonnementView;

    public AbonnementController(Abonnement abonnement, AbonnementView abonnementView){
        this.abonnementModel = abonnement;
        this.abonnementView = abonnementView;
    }


    public int getAbonnementId(){ return abonnementModel.getAbonnementId(); }
    public Korting getKorting(){ return abonnementModel.getKorting(); }
    public Date getBeginDatum(){ return abonnementModel.getBeginDatum(); }
    public Date getVervalDatum(){ return abonnementModel.getVervalDatum(); }
    public Route getRoute(){ return abonnementModel.getRoute(); }
    public Klant getKlant(){ return abonnementModel.getKlant(); }
    public Float getPrijs(){ return abonnementModel.getPrijs(); }
    public Boolean isActive(){ return abonnementModel.isActive(); }

    public void setAbonnementId(int abonnementId){ abonnementModel.setAbonnementId(abonnementId); }
    public void setKorting(Korting korting){ abonnementModel.setKorting(korting); }
    public void setBeginDatum(Date beginDatum){ abonnementModel.setBeginDatum(beginDatum); }
    public void setVervalDatum(Date vervalDatum){ abonnementModel.setVervalDatum(vervalDatum); }
    public void setRoute(Route route){ abonnementModel.setRoute(route); }
    public void setKlant(Klant klant){ abonnementModel.setKlant(klant); }
    public void setPrijs(Float prijs){ abonnementModel.setPrijs(prijs); }
    public void setActive(Boolean active){ abonnementModel.setActive(active); }

    public void showAbonnement(Abonnement abonnement){ abonnementView.showAbonnement(abonnement);}
}
