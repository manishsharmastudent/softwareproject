package view;

import model.Abonnement;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class AbonnementView extends StandardView {
    public AbonnementView(String titel, boolean haveButton){
        super(titel, haveButton);
        getStandardButton().setText("AbonnementView");
    }

    public void showAbonnement(Abonnement abonnement){

    }
}
