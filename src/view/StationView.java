package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

import controller.TimeParseController;
import model.Liveboard;
import model.Station;
import model.Trein;

import static java.awt.Component.LEFT_ALIGNMENT;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class StationView extends StandardView {
    //HomeView homeView = new HomeView("Homescreen");
    private JPanel stationPanel = new JPanel();

    private JTable liveboard = null;
    private String[][] dataLiveboard = null;

    private JLabel naamLabel = new JLabel("Naam: ");
    private JLabel stadLabel = new JLabel("Stad: ");
    private JButton toevoegButton = new JButton("Toevoegen");
    private JButton zoekLiveboardButton = new JButton("Zoeken");
    private JTextField naamText = new JTextField();
    private JTextField stadText = new JTextField();

    public StationView(String titel){
        super(titel);
    }

    public JButton getZoekLiveboardButton(){ return this.zoekLiveboardButton; }

    public JButton getToevoegButton(){
        return this.toevoegButton;
    }

    public String getNaamText(){
        return this.naamText.getText();
    }

    public String getStadText(){
        return this.stadText.getText();
    }

    public void showVoegStationToe(){

        interactiePanel.setLayout(null);
        naamLabel.setBounds(30,140,180,25);
        naamText.setBounds(200,140,180,25);
        stadLabel.setBounds(30, 180, 180, 25);
        stadText.setBounds(200, 180, 180, 25);
        toevoegButton.setBounds(30, 220, 180, 25);

        interactiePanel.add(naamLabel);
        interactiePanel.add(naamText);
        interactiePanel.add(stadLabel);
        interactiePanel.add(stadText);
        interactiePanel.add(toevoegButton);

        mainPanel.setLayout(new BorderLayout(80,30));
        getMainPanel().setLayout(new BorderLayout(80,30));
        panel.setLayout(new BorderLayout(0,0));

        panel.add(mainNavPanel, BorderLayout.NORTH);
        panel.add(interactiePanel, BorderLayout.CENTER);
        mainPanel.add(welkomPanel, BorderLayout.NORTH);
        mainPanel.add(panel, BorderLayout.CENTER);
        getMainPanel().add(welkomPanel, BorderLayout.NORTH);
        getMainPanel().add(panel, BorderLayout.CENTER);
        addPath("Station toevoegen");

        showWindow();
    }

    public void showSearchLiveboard(){
        stationPanel.setLayout(new GridLayout(1,3));
        stationPanel.add(stadLabel);
        stationPanel.add(stadText);
        stationPanel.add(zoekLiveboardButton);

        mainPanel.add(stationPanel);

        addPath("Zoek liveboard");
        showWindow();
    }

    public void showLiveboard(Liveboard liveboard){
        initTable(liveboard.getStation().getTreinen());
        JLabel liveLable = new JLabel();
        liveLable.setAlignmentX(LEFT_ALIGNMENT);
        liveLable.setOpaque(true);
        if(liveboard.getLive()){
            liveLable.setText("• LIVE");
            liveLable.setForeground(Color.RED);
        } else {
            JOptionPane.showMessageDialog(null,"Er is geen verbinding! Liveboard is het laatste geupdate op " + liveboard.getTimeVersion());
        }
        stationPanel.setBorder(border);
        stationPanel.removeAll();
        stationPanel.updateUI();
        stationPanel.setLayout(new BoxLayout(stationPanel, BoxLayout.PAGE_AXIS));
        stationPanel.add(liveLable);
        JScrollPane scrollPane = new JScrollPane(this.liveboard);
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);
        stationPanel.add(scrollPane);

        mainPanel.add(stationPanel);
        showWindow();
    }
    public void initTable(List<Trein>treinList){
        String[] headers = {"Treintype", "Vertrek", "Bestemming", "Platform", "Vertrektijd", "Vertraging"};
        dataLiveboard = new String[treinList.size()][6];

        for (int row = 0; row < treinList.size(); row++) {
            for (int col = 0; col < 6; col++) {
                Trein trein = treinList.get(row);
                switch (col) {
                    case 0:
                        dataLiveboard[row][col] = Integer.toString(trein.getTreinType());
                        break;
                    case 1:
                        dataLiveboard[row][col] = this.getStadText();
                        break;
                    case 2:
                        dataLiveboard[row][col] = trein.getBestemming();
                        break;
                    case 3:
                        dataLiveboard[row][col] = trein.getVetrkPlatform();
                        break;
                    case 4:
                        dataLiveboard[row][col] = trein.getDeparture().toString();
                        break;
                    case 5:
                        dataLiveboard[row][col] = TimeParseController.getDelay(trein.getDeparture(),trein.getActualDeparture());
                        break;
                }
            }
        }

        liveboard = new JTable(dataLiveboard, headers);
    }

    public void liveboardNotFound(){
        JOptionPane.showMessageDialog(null,"Info over station is niet gevonden.");
    }
}
