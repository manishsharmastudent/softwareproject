package controller;

import java.time.LocalDate;
import java.util.Date;
import model.Korting;
import view.KortingView;
/**
 * Created by Robbe on 06/11/2016.
 */
public class KortingController {
    private Korting kortingModel;
    private KortingView kortingView;

    public KortingController(Korting korting, KortingView kortingView){
        this.kortingModel = korting;
        this.kortingView = kortingView;
    }

    public int getKortingId(){ return kortingModel.getKortingId(); }
    public int getKortingType(){ return kortingModel.getKortingType(); }
    public Date getBeginDatum(){ return kortingModel.getBeginDatum(); }
    public String getOmschrijving(){ return kortingModel.getOmschrijving(); }
    public Boolean isActive(){ return kortingModel.isActive(); }

    public void setKortingId(int kortingId){ kortingModel.setKortingId(kortingId); }
    public void setKortingType(int kortingType){ kortingModel.setKortingType(kortingType); }
    public void setBeginDatum(Date datum){ kortingModel.setBeginDatum(datum); }
    public void setOmschrijving(String omschrijving){ kortingModel.setOmschrijving(omschrijving); }
    public void setActive(Boolean active){ kortingModel.setActive(active); }

    public void showKorting(){
        kortingView.showKorting(kortingModel);
    }
}
