package view;

import controller.StreepjeDocumentFilter;
import model.Klant;

import controller.MyDocumentFilter;
import java.util.List;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.AbstractDocument;
import java.awt.*;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class KlantView extends StandardView {
    private JPanel klantPanel = new JPanel();
    private JPanel gevondenKlantenPanel = new JPanel();
    private JLabel voornaamLabel = new JLabel("Voornaam");
    private JLabel achternaamLabel = new JLabel("Achternaam");
    private JLabel rijksregisterNummerLabel = new JLabel("Rijksregister-nummer");
    private JLabel adresLabel = new JLabel("Adres");
    private JLabel postcodeLabel = new JLabel("Postcode");
    private JLabel stadLabel = new JLabel("Stad");
    private GridBagConstraints c = new GridBagConstraints();


    private JTable klantTable = null;
    private String[][] klantData = null;

    private JTextField voornaamText = new JTextField("");
    private JTextField achternaamText = new JTextField();
    private JTextField rijksregisterNummerText = new JFormattedTextField(createFormatter("##.##.##-###.##"));
    private JTextField adresText = new JTextField();
    private JTextField postcodeText = new JFormattedTextField(createFormatter("####"));
    private JTextField stadText = new JTextField();
    private JCheckBox active = new JCheckBox("Actief");

    private JButton searchButtonRijksregisterNummer = new JButton("Zoeken");
    private JButton searchButtonSurname = new JButton("Zoeken");
    private JButton searchButtonLastname = new JButton("Zoeken");
    private JButton klantToevoegenButton = new JButton("Klant toevoegen");
    private JButton klantUpdateButton = new JButton("Klant aanpassen");
    private JButton aanpassenKlant = new JButton("Aanpassen");

    public KlantView(String titel){
        super(titel);
        klantPanel.setLayout(new GridBagLayout());
        c.insets = new Insets(10, 20 , 1 ,0);
        rijksregisterNummerText.setPreferredSize(new Dimension(110,20));
        rijksregisterNummerText.setMinimumSize(rijksregisterNummerText.getPreferredSize());
        rijksregisterNummerText.setMaximumSize(rijksregisterNummerText.getPreferredSize());
        c.fill = GridBagConstraints.HORIZONTAL;




    }

    public String getRijksregisterNummer(){
        return this.rijksregisterNummerText.getText();
    }
    public String getVoornaam(){
        return this.voornaamText.getText();
    }
    public String getAchternaam(){
        return this.achternaamText.getText();
    }
    public String getAdres(){
        return this.adresText.getText();
    }
    public int getPostcode(){
        return Integer.parseInt(this.postcodeText.getText());
    }
    public String getStad(){
        return this.stadText.getText();
    }
    public String getSelectedRow(){
        String[] klant = klantData[klantTable.getSelectedRow()];
        return klant[0];
    }
    public boolean isActive(){
        return active.isSelected();
    }

    public JButton getAanpassenKlant(){
        return aanpassenKlant;
    }
    public JButton getKlantToevoegenButton(){
        return this.klantToevoegenButton;
    }
    public JButton getSearchButtonSurname(){ return this.searchButtonSurname; }
    public JButton getSearchButtonLastname(){ return this.searchButtonLastname; }
    public JButton getSearchButtonRijksregisterNummer(){ return this.searchButtonRijksregisterNummer; }
    public JButton getKlantUpdateButton(){return this.klantUpdateButton;}
    public void showUpdateKlant(Klant klant){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        klantPanel.removeAll();
        klantPanel.updateUI();

        voornaamText = new JTextField("");
        achternaamText = new JTextField();
        stadText = new JTextField();

        ((AbstractDocument) stadText.getDocument()).setDocumentFilter(new StreepjeDocumentFilter());
        ((AbstractDocument) voornaamText.getDocument()).setDocumentFilter(new StreepjeDocumentFilter());
        ((AbstractDocument) achternaamText.getDocument()).setDocumentFilter(new MyDocumentFilter());


        c.gridy = 0;
        c.gridx = 0;
        klantPanel.add(rijksregisterNummerLabel, c);
        rijksregisterNummerText.setText(klant.getRijksregisterNummer());
        c.gridx = 1;
        klantPanel.add(rijksregisterNummerText, c);
        c.gridy = 1;
        c.gridx = 0;
        klantPanel.add(voornaamLabel, c);


        c.gridx = 1;
        klantPanel.add(voornaamText, c);
        voornaamText.setText(klant.getVoornaam());
        c.gridy = 2;
        c.gridx = 0;
        klantPanel.add(achternaamLabel, c);
        achternaamText.setText(klant.getAchternaam());
        c.gridx = 1;
        klantPanel.add(achternaamText, c);
        c.gridy = 3;
        c.gridx = 0;
        klantPanel.add(adresLabel, c);
        adresText.setText(klant.getAdres());
        c.gridx = 1;
        klantPanel.add(adresText, c);
        c.gridy = 4;
        c.gridx = 0;
        klantPanel.add(postcodeLabel, c);
        postcodeText.setText(Integer.toString(klant.getPostcode()));
        c.gridx = 1;
        klantPanel.add(postcodeText, c);
        c.gridy = 5;
        c.gridx = 0;
        klantPanel.add(stadLabel, c);
        stadText.setText(klant.getStad());
        c.gridx = 1;
        klantPanel.add(stadText, c);
        if(klant.getActive()){active.setSelected(true);}
        c.gridy = 6;
        c.gridx = 0;
        klantPanel.add(active, c);
        c.gridy = 7;
        c.gridx = 0;
        klantPanel.add(klantUpdateButton, c);
        klantPanel.setPreferredSize(klantPanel.getMinimumSize());


        interactiePanel.add(klantPanel);
        deleteLastInPath();
        deleteLastInPath();
        path.add("Klant Aanpassen");
        showWindow();
    }
    public void showKlantToevoegen(){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        klantPanel.removeAll();
        klantPanel.updateUI();

        voornaamText = new JTextField();
        achternaamText = new JTextField();
        stadText = new JTextField();

        ((AbstractDocument) stadText.getDocument()).setDocumentFilter(new StreepjeDocumentFilter());
        ((AbstractDocument) voornaamText.getDocument()).setDocumentFilter(new StreepjeDocumentFilter());
        ((AbstractDocument) achternaamText.getDocument()).setDocumentFilter(new MyDocumentFilter());



        c.gridy = 0;
        c.gridx = 0;
        klantPanel.add(rijksregisterNummerLabel, c);
        c.gridx = 1;
        klantPanel.add(rijksregisterNummerText, c);
        c.gridy = 1;
        c.gridx = 0;
        klantPanel.add(voornaamLabel, c);
        c.gridx = 1;
        klantPanel.add(voornaamText, c);
        c.gridy = 2;
        c.gridx = 0;
        klantPanel.add(achternaamLabel, c);
        c.gridx = 1;
        klantPanel.add(achternaamText, c);
        c.gridy = 3;
        c.gridx = 0;
        klantPanel.add(adresLabel, c);
        c.gridx = 1;
        klantPanel.add(adresText, c);
        c.gridy = 4;
        c.gridx = 0;
        klantPanel.add(postcodeLabel, c);
        c.gridx = 1;
        klantPanel.add(postcodeText, c);
        c.gridy = 5;
        c.gridx = 0;
        klantPanel.add(stadLabel, c);
        c.gridx = 1;
        klantPanel.add(stadText, c);
        c.gridy = 6;
        c.gridx = 0;
        klantPanel.add(klantToevoegenButton, c);
        klantPanel.setPreferredSize(klantPanel.getMinimumSize());


        interactiePanel.add(klantPanel);

        path.add("Klant Toevoegen");
        showWindow();
    }
    public void showKlantZoeken(){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        klantPanel.removeAll();
        klantPanel.updateUI();

        voornaamText = new JTextField();
        achternaamText = new JTextField();
        stadText = new JTextField();

        ((AbstractDocument) stadText.getDocument()).setDocumentFilter(new StreepjeDocumentFilter());
        ((AbstractDocument) voornaamText.getDocument()).setDocumentFilter(new StreepjeDocumentFilter());
        ((AbstractDocument) achternaamText.getDocument()).setDocumentFilter(new MyDocumentFilter());


        c.gridy = 0;
        c.gridx = 0;
        klantPanel.add(rijksregisterNummerLabel, c);
        c.gridx = 1;
        klantPanel.add(rijksregisterNummerText, c);
        c.gridx =2;
        klantPanel.add(searchButtonRijksregisterNummer, c);
        c.gridy = 1;
        c.gridx = 0;
        klantPanel.add(voornaamLabel, c);
        c.gridx = 1;
        klantPanel.add(voornaamText, c);
        c.gridx = 2;
        klantPanel.add(searchButtonSurname, c);
        c.gridy = 2;
        c.gridx = 0;
        klantPanel.add(achternaamLabel, c);
        c.gridx = 1;
        klantPanel.add(achternaamText, c);
        c.gridx = 2;
        klantPanel.add(searchButtonLastname, c);
        klantPanel.setPreferredSize(klantPanel.getMinimumSize());

        interactiePanel.add(klantPanel);
        addPath("Klant zoeken");
        showWindow();
    }
    public void showKlanten(List<Klant> klanten){
        interactiePanel.removeAll();
        interactiePanel.updateUI();
        klantPanel.removeAll();
        klantPanel.updateUI();


        gevondenKlantenPanel.setLayout(new GridBagLayout());
        initTable(klanten);

        JScrollPane scrollPane = new JScrollPane(klantTable,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        for (int column = 0; column < klantTable.getColumnCount(); column++)
        {
            TableColumn tableColumn = klantTable.getColumnModel().getColumn(column);
            tableColumn.setMinWidth(80);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < klantTable.getRowCount(); row++)
            {
                TableCellRenderer cellRenderer = klantTable.getCellRenderer(row, column);
                Component c = klantTable.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + klantTable.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);

                //  We've exceeded the maximum width, no need to check other rows

                if (preferredWidth >= maxWidth)
                {
                    preferredWidth = maxWidth;
                    break;
                }
            }

            tableColumn.setPreferredWidth( preferredWidth );


        }



        c.gridy = 0;
        c.gridx = 0;
        gevondenKlantenPanel.add(scrollPane, c);
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        gevondenKlantenPanel.add(aanpassenKlant, c);
        c.fill = GridBagConstraints.HORIZONTAL;
        interactiePanel.add(gevondenKlantenPanel);


    }
    public void initTable(java.util.List<Klant> klantList){
        String[] headers = {"Rijksregister", "Voornaam", "Achternaam", "Adres", "Postcode", "Stad"};
        klantData = new String[klantList.size()][6];

        for (int row = 0; row < klantList.size(); row++) {
            for (int col = 0; col < 6; col++) {
                Klant klant = klantList.get(row);
                switch (col) {
                    case 0:
                        klantData[row][col] = klant.getRijksregisterNummer();
                        break;
                    case 1:
                        klantData[row][col] = klant.getVoornaam();
                        break;
                    case 2:
                        klantData[row][col] = klant.getAchternaam();
                        break;
                    case 3:
                        klantData[row][col] = klant.getAdres();
                        break;
                    case 4:
                        klantData[row][col] = Integer.toString(klant.getPostcode());
                        break;
                    case 5:
                        klantData[row][col] = klant.getStad();
                        break;
                }
            }
        }

        klantTable = new JTable(klantData, headers){
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        klantTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        klantTable.setFillsViewportHeight(true);


    }
    public void klantNotFound(){
        JOptionPane.showMessageDialog(null, "Klant is niet gevonden");
    }
    public void klantUpdateSucceed(){
        JOptionPane.showMessageDialog(null, "Klant is geupdated");
    }
    public void klantInsertSucceed(){
        JOptionPane.showMessageDialog(null, "Klant is toegevoegd!");
    }
    public void klantUpdateFailure(){
        JOptionPane.showMessageDialog(null, "Er is iets misgelopen tijdens het updaten.");
    }
}
