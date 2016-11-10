package view;
import javax.swing.*;

import org.jdesktop.swingx.autocomplete.*;


/**
 * Created by User on 31/10/2016.
 */
public class TicketView {
    private JFrame frame = new JFrame();
    private JLabel welkomLabel = new JLabel("Welkom");
    private JLabel tijdLabel = new JLabel("tijd");
    private JLabel datumLabel = new JLabel("datum");
    private JPanel welkomPanel = new JPanel();
    private JPanel panel = new JPanel();
    private JPanel interactiePanel = new JPanel();
    private JLabel vertrekLabel = new JLabel("Vertrekpunt");
    private JLabel aankomstLabel = new JLabel("Aankomst");
    private JLabel datumticketLabel = new JLabel("Datum");
    private JLabel aantalLabel = new JLabel("Aantal");
    private JLabel klasseLabel = new JLabel("Klasse");
    private JButton terugButton = new JButton("Terug");
    private JButton zoekButton = new JButton("Zoek");
    private AutoCompleteDecorator decorator;
    private JComboBox stationCombobox;


    public TicketView(){

        setGui();
    }


    private void setGui(){
        stationCombobox = new JComboBox(new Object[]{"","test", "aardappeltest"});
        AutoCompleteDecorator.decorate(stationCombobox);

        frame.add(panel);
        panel.add(stationCombobox);

        frame.setSize(800,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        TicketView t = new TicketView();

    }

}
