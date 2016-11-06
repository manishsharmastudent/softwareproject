package view;

import javax.swing.*;
import java.awt.*;
/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class StandardView {
    JFrame window;
    Container content;
    JButton standardButton = new JButton("StandaarButton");

    StandardView(String titel, boolean haveButton){
        window = new JFrame(titel);
        content = window.getContentPane();
        if (haveButton == true){
            standardButton = new JButton("StandaardButton");
        }
    }
    JFrame getWindow(){
        return this.window;
    }
    Container getContainer(){
        return this.content;
    }
    JButton getStandardButton(){
        return this.standardButton;
    }
}
