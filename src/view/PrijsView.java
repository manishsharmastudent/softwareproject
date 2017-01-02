package view;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import java.awt.*;

/**
 * Created by User on 2/12/2016.
 */
public class PrijsView extends StandardView {

    private JComboBox keuzePrijs = new JComboBox(new String[]{"Afstand", "Tijd", "Per Halte"});
    private JLabel keuzeLabel = new JLabel("Keuze (aanbevolen per afstand)");
    private GridBagConstraints c = new GridBagConstraints();
    private JPanel instellingPanel = new JPanel();
    private JPanel keuzePanel = new JPanel(new GridBagLayout());

    PrijsView(String titel) {
        super(titel);
    }

    public void showKeuzePanel(){
        interactiePanel.setLayout(new BoxLayout(interactiePanel, BoxLayout.PAGE_AXIS));
        c.insets = (new Insets(0,10,40,0));
        c.gridy = 0;
        c.gridx = 1;

        keuzePanel.setLayout(new GridBagLayout());
        keuzePanel.add(keuzePrijs, c);
        c.gridx = 0;
        keuzePanel.add(keuzeLabel, c);
        interactiePanel.add(keuzePanel);



        addPath("Prijs configureren");
        showWindow();
    }
    public void showPrijsInstellingenByAfstand(){

        JLabel prijsLabel = new JLabel("Stel uw coeficient in per km (0 tot 1):");
        JTextField inputPrijs = new JTextField();
        inputPrijs.setPreferredSize(new Dimension(140,30));
        PromptSupport.setPrompt("prijs",inputPrijs);
        JLabel voorbeeldPrijsLabel = new JLabel("prijs wordt berekend via controller");
        JLabel afstandLabel = new JLabel("Prijs voor 10km     = ");
        voorbeeldPrijsLabel.setForeground(Color.GREEN);


        instellingPanel.setLayout(new GridBagLayout());




      //  c.insets = (new Insets(-200,10,0,0));

        c.gridy = 0;
        c.gridx = 1;


        instellingPanel.add(inputPrijs,c);


       // c.insets = (new Insets(-200,10,0,0));
        c.gridx = 0;




        instellingPanel.add(prijsLabel, c);

        c.gridy=1;
        c.gridx = 0;
        instellingPanel.add(afstandLabel , c);

        c.gridy=1;
        c.gridx = 1;

        instellingPanel.add(voorbeeldPrijsLabel,c);



        interactiePanel.add(instellingPanel);



    }
    public void showPrijsInstellingenByHalte(){



        JLabel prijsLabel = new JLabel("Stel uw coeficient in per halte(0 tot 1):");
        JTextField inputPrijs = new JTextField();
        inputPrijs.setPreferredSize(new Dimension(140,30));
        PromptSupport.setPrompt("prijs",inputPrijs);
        JLabel voorbeeldPrijsLabel = new JLabel("prijs wordt berekend via controller");
        JLabel halteLabel = new JLabel("Prijs voor 10 haltes     = ");
        voorbeeldPrijsLabel.setForeground(Color.GREEN);

        instellingPanel.setLayout(new GridBagLayout());

        //  c.insets = (new Insets(-200,10,0,0));

        c.gridy = 0;
        c.gridx = 1;


        instellingPanel.add(inputPrijs,c);


        // c.insets = (new Insets(-200,10,0,0));
        c.gridx = 0;




        instellingPanel.add(prijsLabel, c);

        c.gridy=1;
        c.gridx = 0;
        instellingPanel.add(halteLabel , c);

        c.gridy=1;
        c.gridx = 1;

        instellingPanel.add(voorbeeldPrijsLabel,c);



        interactiePanel.add(instellingPanel);


    }
    public void showPrijsInstellingenByTijd(){
        JLabel prijsLabel = new JLabel("Stel uw coeficient in per minuut (0 tot 1):");
        JTextField inputPrijs = new JTextField();
        inputPrijs.setPreferredSize(new Dimension(140,30));
        PromptSupport.setPrompt("prijs",inputPrijs);
        JLabel voorbeeldPrijsLabel = new JLabel("prijs wordt berekend via controller");
        JLabel afstandLabel = new JLabel("Prijs voor 10 minuten     = ");
        voorbeeldPrijsLabel.setForeground(Color.GREEN);


        instellingPanel.setLayout(new GridBagLayout());




        //  c.insets = (new Insets(-200,10,0,0));

        c.gridy = 0;
        c.gridx = 1;


        instellingPanel.add(inputPrijs,c);


        // c.insets = (new Insets(-200,10,0,0));
        c.gridx = 0;




        instellingPanel.add(prijsLabel, c);

        c.gridy=1;
        c.gridx = 0;
        instellingPanel.add(afstandLabel , c);

        c.gridy=1;
        c.gridx = 1;

        instellingPanel.add(voorbeeldPrijsLabel,c);



        interactiePanel.add(instellingPanel);

    }

}
