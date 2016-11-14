package view;

import hibernate.ManageVoorwerp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Rik Van Belle on 11/11/2016.
 */
public class HomeView extends StandardView {

    private JPanel ticketPanel = new JPanel();
    private JPanel abonnementPanel = new JPanel();
    private JPanel routeInfoPanel = new JPanel();
    private ArrayList<JButton> buttons = new ArrayList<JButton>(9);
    private String[] args;

    public HomeView(String naam, boolean standardButton){
        super(naam, standardButton);

        args = new String[] {"Ticket maken", "Ticket verwijderen", "Ticket aanpassen", "Ticket zoeken"};
        initButtons();
        initPanels(ticketPanel);

        args = new String[] {"Abonnement maken", "Abonnement verwijderen", "Abonnement vernieuwen", "Abonnement aanpassen"};
        initButtons();
        initPanels(abonnementPanel);

        args = new String[] {"Route opzoeken"};
        initButtons();
        initPanels(routeInfoPanel);

        this.showWindow();
    }
    private void initPanels(JPanel panel){
        panel.setLayout(new GridLayout(args.length,1));
        for (int i = 0; i < buttons.size();i++){
            panel.add(buttons.get(i));
        }
        this.getMainPanel().add(panel);
    }
    private void initButtons(){
        for (int i = 0; i < args.length;i++){
            JButton button = new JButton(args[i]);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Geklikt");
                }
            });
            buttons.add(button);
        }
    }
}
