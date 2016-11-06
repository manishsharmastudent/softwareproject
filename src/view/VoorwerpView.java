package view;

import model.Voorwerp;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class VoorwerpView extends StandardView {
    public VoorwerpView(String titel, boolean haveButton){
        super(titel, haveButton);
        standardButton.setText("Voorwerp view");
    }
    public void showVoorwerp(Voorwerp voorwerp){

    }
}
