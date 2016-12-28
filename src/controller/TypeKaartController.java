package controller;

import hibernate.ManageTypeKaart;
import model.TypeKaart;
import model.Korting;
import view.TypeKaartView;
/**
 * Created by Robbe on 06/11/2016.
 */
public class TypeKaartController {
    private TypeKaart typeKaartModel;
    private TypeKaartView typeKaartView;
    private ManageTypeKaart manageTypeKaart;

    public TypeKaartController(){
        this.typeKaartView = new TypeKaartView("Type kaarten");
        this.manageTypeKaart = new ManageTypeKaart();
    }

    public TypeKaartController(TypeKaart typeKaart, TypeKaartView typeKaartView){
        this.typeKaartModel = typeKaart;
        this.typeKaartView = typeKaartView;
    }


    public int getId(){ return typeKaartModel.getId(); }
    public String getNaam(){ return typeKaartModel.getNaam(); }
    public String getOmschrijving(){ return typeKaartModel.getOmschrijving(); }
    public Korting getKorting(){ return typeKaartModel.getKorting(); }
    public void setId(int typeKaartId){ typeKaartModel.setId(typeKaartId); }
    public void SetNaam(String naam){ typeKaartModel.setOmschrijving(naam); }
    public void setOmschrijving(String omschrijving){ typeKaartModel.setOmschrijving(omschrijving); }
    public void setKorting(Korting korting){ typeKaartModel.setKorting(korting); }
}
