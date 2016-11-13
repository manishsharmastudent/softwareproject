package view;

import model.Korting;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class KortingView extends StandardView {
    public KortingView(String titel, boolean haveButton){
        super(titel, haveButton);
        getStandardButton().setText("KortinView");
    }
    public void showKorting(Korting korting){

    }
}
