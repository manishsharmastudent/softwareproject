package Controller;

import model.Klant;
import view.KlantView;
/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class KlantController {
    private Klant klantModel;
    private KlantView klantView;

    public KlantController(Klant klant, KlantView klantView){
        this.klantModel = klant;
        this.klantView = klantView;
    }
    public String getRijksregister(){
        return klantModel.getRijksregisterNummer();
    }
    public String getVoornaam(){
        return klantModel.getVoornaam();
    }
    public String getAchternaam(){
        return klantModel.getAchternaam();
    }
    public String getAdres(){
        return klantModel.getAdres();
    }
    public int getPostcode(){
        return klantModel.getPostcode();
    }
    public String getStad(){
        return klantModel.getStad();
    }
    public boolean setVoornaam(String voornaam){
        return klantModel.setVoornaam(voornaam);
    }
    public boolean setAchternaam(String achternaam){
        return klantModel.setAchternaam(achternaam);
    }
    public boolean setAdres(String adres){
        return klantModel.setAdres(adres);
    }
    public boolean setPostcode(int postcode){
        return klantModel.setPostcode(postcode);
    }
    public boolean setStad(String stad){
        return klantModel.setStad(stad);
    }
    public void showKlant(){
        klantView.showKlant(klantModel);
    }
}
