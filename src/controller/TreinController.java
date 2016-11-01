package controller;

import model.Trein;
//import view.TreinView;
/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class TreinController {
    private Trein treinModel;
    //private TreinView treinView;

    private int getTreinId(){
        return treinModel.getTreinId();
    }
    private String getTreinNaam(){
        return treinModel.getTreinNaam();
    }
    private boolean setTreinId(int treinId){
        return treinModel.setTreinId(treinId);
    }
    private boolean setTreinNaam(String treinNaam){
        return treinModel.setTreinNaam(treinNaam);
    }
}
