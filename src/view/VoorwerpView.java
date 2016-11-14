package view;

import model.Voorwerp;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class VoorwerpView extends StandardView {
    JPanel voorwerpen = new JPanel();


    public VoorwerpView(String titel, boolean haveButton){
        super(titel, haveButton);
        getStandardButton().setText("Voorwerp view");
    }
    public void showVoorwerp(Voorwerp voorwerp){

    }
    public void showVoorwerpen(Vector<Voorwerp> vw){
        for (int i = 0; i < vw.size();i++){
            voorwerpen.add(new JLabel(vw.get(i).getVoorwerp()));
        }
        voorwerpen.setVisible(true);
        showWindow();
    }
}
