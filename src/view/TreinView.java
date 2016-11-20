package view;

import model.Trein;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class TreinView extends StandardView{
    public TreinView(String titel, boolean haveButton){
        super(titel, haveButton);
        standardButton.setText("Show trein");
    }
    public void showTrein(Trein trein){

    }
}
