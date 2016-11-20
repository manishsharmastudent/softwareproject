package view;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class StandardView {
    JFrame window;
    Container content;
    JButton standardButton = new JButton("StandaarButton");
    FlowLayout layout = new FlowLayout();

    StandardView(String titel, boolean haveButton){
        window = new JFrame(titel);
        window.setSize(400, 500);
        content = window.getContentPane();
        content.setLayout(layout);
        if (haveButton == true){
            standardButton = new JButton("StandaardButton");
        }
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
