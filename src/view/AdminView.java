package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 26/11/2016.
 */
public class AdminView extends StandardView {

    private JPanel adminPanel = new JPanel(new GridLayout(6,1));

    private JLabel adminLabel = new JLabel("Admin opties");
    private JButton userToevoegenButton = new JButton("User toevoegen");
    private JButton userSettingsButton = new JButton("Instellingen users");
    private JButton companySettingsButton = new JButton("Instellingen bedrijf");
    private JButton ticketsSettingsButton = new JButton("Instellingen tickets");
    private JButton verlorenVoorwerpButton = new JButton("Instellingen verloren voorwerpen");
    private GridBagConstraints c = new GridBagConstraints();

    public AdminView(String titel) {
        super(titel);
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
        adminPanel.setOpaque(true);
        adminPanel.setBackground(Color.black);
        adminPanel.setForeground(Color.white);
        adminPanel.add(adminLabel);

        adminPanel.add(userToevoegenButton);
        adminPanel.add(userSettingsButton);
        adminPanel.add(companySettingsButton);
        adminPanel.add(ticketsSettingsButton);
        adminPanel.add(verlorenVoorwerpButton);

        interactiePanel.setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridy = 3;

        c.insets = (new Insets(5, 10, 0, 10));
        c.fill = 2;

        interactiePanel.add(adminPanel, c);

        showWindow();

    }
}
