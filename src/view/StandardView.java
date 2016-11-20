package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class StandardView {

    static ArrayList<String> path = new ArrayList<String>();
    static int heightNavPanel = 30;
    static int widthNavPanel = 170;

    protected JFrame window;
    protected JPanel mainPanel = new JPanel();
    protected JButton standardButton = new JButton("StandaarButton");
    protected BorderLayout layout = new BorderLayout();
    protected FlowLayout navigationPanelLayout = new FlowLayout(FlowLayout.LEFT);

    protected Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    protected JPanel welkomPanel = new JPanel();
    protected JPanel interactiePanel = new JPanel(new SpringLayout());
    protected JPanel panel= new JPanel();
    protected JPanel navigationPanel = new JPanel(); //mainNavPanel //Tree structure
    protected JPanel mainNavPanel = new JPanel();//fullNavigationPanel

    protected JLabel tijdLabel = new JLabel();
    protected JLabel datumLabel = new JLabel();
    protected JLabel welkomLabel = new JLabel();
    protected JButton terugButton = new JButton("Terug");

    private JMenuBar menuBar;
    private JMenu menu;

    StandardView(String titel){
        window = new JFrame(titel);

        java.net.URL url = ClassLoader.getSystemResource("resources/nmbs_sncb.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        window.setIconImage(img);
        if (titel != "Login") {
            initTimeAndDate();
            initMenuBar();
            initWelkomBoard();
            initNavTree();
        }
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setWelkomLabel(String tekst){
        this.welkomLabel.setText(tekst);
    }

    public JFrame getWindow(){
        return this.window;
    }
    public JPanel getMainPanel(){ return this.mainPanel; }
    public JButton getStandardButton(){
        return this.standardButton;
    }

    public void initTimeAndDate(){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        tijdLabel.setText(sdf.format(cal.getTime()));
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        datumLabel.setText(sdf.format(cal.getTime()));
    }
    public void initMenuBar(){
        menuBar = new JMenuBar();
        menu = new JMenu("Test");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("A test");
        menu.add(menuItem);
        window.setJMenuBar(menuBar);
    }
    public void initWelkomBoard(){
        welkomPanel.setLayout(new GridLayout(1,3));

        welkomLabel.setHorizontalAlignment(JLabel.CENTER);
        datumLabel.setHorizontalAlignment(JLabel.CENTER);
        tijdLabel.setHorizontalAlignment(JLabel.CENTER);

        welkomPanel.add(welkomLabel);
        welkomPanel.add(tijdLabel);
        welkomPanel.add(datumLabel);

        welkomPanel.setPreferredSize(new Dimension(800,50));
        welkomPanel.setMaximumSize(welkomPanel.getPreferredSize());
        welkomPanel.setBorder(border);

        mainPanel.add(welkomPanel, BorderLayout.NORTH);
    }
    public void initNavTree(){
        mainNavPanel.setLayout(new BorderLayout(0,0));
        mainNavPanel.add(navigationPanel, BorderLayout.WEST);
        mainNavPanel.add(terugButton, BorderLayout.EAST);

        mainNavPanel.setBorder(border);

        navigationPanel.setLayout(navigationPanelLayout);
        mainNavPanel.setPreferredSize(welkomPanel.getPreferredSize());
        mainPanel.add(mainNavPanel, BorderLayout.NORTH);

    }

    public void showWindow(){
        getWindow().setSize(800,700);
        getWindow().setLocationRelativeTo(null);
        window.add(mainPanel);
        mainPanel.setVisible(true);
        window.setVisible(true);
    }
    public void addPath(String tekst){
        path.add(tekst);
    }
    public void showPath(){
        for (int i = 0; i < path.size(); i++){
            JLabel treeText = new JLabel("");

            JPanel treePanel = new JPanel();
            treePanel.setLayout(new BorderLayout());

            treeText.setHorizontalAlignment(JLabel.CENTER);
            treeText.setVerticalAlignment(JLabel.CENTER);

            treeText.setText(path.get(i));

            treePanel.setPreferredSize(new Dimension(widthNavPanel, heightNavPanel));
            treePanel.setBorder(border);
            treePanel.add(treeText, BorderLayout.CENTER);

            navigationPanel.add(treePanel);
        }
    }
    public void deleteLastInPath(){
        if (path.size() > 0){
            path.remove(path.size()-1);
        }
    }
}
