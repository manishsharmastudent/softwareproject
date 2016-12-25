package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 26/11/2016.
 */
public class AdminView extends StandardView {

    private JButton userSettingsButton = new JButton("Instellingen users");
    private JButton companySettingsButton = new JButton("Instellingen bedrijf");
    private JButton ticketsSettingsButton = new JButton("Instellingen tickets");
    private JButton verlorenVoorwerpButton = new JButton("Instellingen verloren voorwerpen");
    private GridBagConstraints c = new GridBagConstraints();

    AdminView(String titel) {
        super(titel);
    }

    public void showAdminOptions(){

        showWindow();

        welkomLabel.setText("Welkom Admin");

        interactiePanel.setLayout(new GridBagLayout());

        c.insets = (new Insets(40,0,40,0));
        c.fill = 1;
        c.gridy = 0;
        interactiePanel.add(userSettingsButton, c);

        c.gridy = 1;
        interactiePanel.add(companySettingsButton, c);

        c.gridy = 2;
        interactiePanel.add(ticketsSettingsButton, c);

        c.gridy = 3;
        interactiePanel.add(verlorenVoorwerpButton, c);




    }


}
