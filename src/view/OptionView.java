package view;

import oracle.jrockit.jfr.JFR;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by User on 24/11/2016.
 */
public class OptionView{

    private JFrame optionsFrame = new JFrame("Menu");
    private JPanel optionPanel = new JPanel();
    private JPanel settingsPanel = new JPanel();
    private JPanel mainPanel = new JPanel();
    private JLabel optionLabel = new JLabel("Menu");
    private JButton settingsButton = new JButton("Instellingen");
    private JButton helpButton = new JButton("Help");
    private JButton quitButton = new JButton("Exit");
    private Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();


    OptionView() {
        showMenu();
    }

    public void showMenu(){

        optionsFrame.setSize(400,600);
        optionsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        optionsFrame.setVisible(true);
        optionsFrame.setResizable(false);
        optionsFrame.setLocationRelativeTo(null);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));


        settingsPanel.setBorder(border);
        optionLabel.setFont(new Font("Arial", Font.BOLD, 25));
        optionPanel.setPreferredSize(new Dimension(optionsFrame.getWidth(), 100));
        optionPanel.setMinimumSize(optionPanel.getPreferredSize());
        optionPanel.setMaximumSize(optionPanel.getPreferredSize());

        settingsPanel.setLayout(new GridBagLayout());
        gridBagConstraints.insets = (new Insets(40,0,40,0));

        settingsButton.setPreferredSize(new Dimension(100,50));
        settingsButton.setMaximumSize(settingsButton.getPreferredSize());
        settingsButton.setMinimumSize(settingsButton.getPreferredSize());
        gridBagConstraints.gridy = 0;
        settingsPanel.add(settingsButton, gridBagConstraints);

        helpButton.setPreferredSize(new Dimension(100,50));
        helpButton.setMaximumSize(helpButton.getPreferredSize());
        gridBagConstraints.gridy = 1;
        settingsPanel.add(helpButton, gridBagConstraints);


        quitButton.setPreferredSize(new Dimension(100,50));
        quitButton.setMaximumSize(quitButton.getPreferredSize());
        gridBagConstraints.gridy = 2;
        settingsPanel.add(quitButton, gridBagConstraints);


        optionPanel.setLayout(new GridBagLayout());
        optionPanel.add(optionLabel);
        mainPanel.add(optionPanel);
        optionPanel.setBorder(border);
        mainPanel.add(settingsPanel);
        optionsFrame.add(mainPanel);

    }

}
