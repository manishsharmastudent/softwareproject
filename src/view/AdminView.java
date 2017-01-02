package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 26/11/2016.
 */
public class AdminView extends StandardView {

    private JPanel adminPanel = new JPanel(new GridBagLayout());

    private JLabel adminLabel = new JLabel("Admin opties");
    private JButton userToevoegenButton = new JButton("User toevoegen");
    private JButton userSettingsButton = new JButton("Instellingen users");
    private JButton companySettingsButton = new JButton("Instellingen bedrijf");
    private JButton ticketsSettingsButton = new JButton("Instellingen tickets");
    private JButton verlorenVoorwerpButton = new JButton("Instellingen verloren voorwerpen");
    private GridBagConstraints c = new GridBagConstraints();

    public AdminView(String titel) {
        super(titel);
        c.insets = (new Insets(5, 5, 5, 5));
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty =1;
    }

    public JButton getUserToevoegenButton(){return userToevoegenButton;}
    public JButton getUserSettingsButton(){return userSettingsButton;}
    public JButton getCompanySettingsButton(){return companySettingsButton;}
    public JButton getTicketsSettingsButton(){return ticketsSettingsButton; }
    public JButton getVerlorenVoorwerpButton() {return verlorenVoorwerpButton; }

    public void showAdminOptions() {
        if (path.size() == 0) {
            addPath("Home");
        }
        adminPanel.setBorder(border);
        adminLabel.setOpaque(true);
        adminLabel.setBackground(Color.black);
        adminLabel.setForeground(Color.white);

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 3;
        adminLabel.setHorizontalAlignment(JLabel.CENTER);
        c.gridheight = 1;
        adminPanel.add(adminLabel, c);
        c.gridy = 1;
        adminPanel.add(userToevoegenButton, c);
        c.gridy = 2;
        adminPanel.add(userSettingsButton, c);
        c.gridy = 3;
        adminPanel.add(companySettingsButton, c);
        c.gridy = 4;
        adminPanel.add(ticketsSettingsButton, c);
        c.gridy = 5;
        adminPanel.add(verlorenVoorwerpButton, c);


        interactiePanel.add(adminPanel);

        showWindow();

    }
}
