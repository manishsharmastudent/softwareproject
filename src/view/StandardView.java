package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * Created by Rik Van Belle on 01/11/2016.
 */
public class StandardView {
    private JFrame window;
    private Container content;
    private JPanel mainPanel = new JPanel();
    private JButton standardButton = new JButton("StandaarButton");
    private FlowLayout layout = new FlowLayout();

    private JMenuBar menuBar;
    private JMenu menu;

    StandardView(String titel, boolean haveButton){
        window = new JFrame(titel);

        java.net.URL url = ClassLoader.getSystemResource("");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        window.setIconImage(img);

        window.add(mainPanel);
        initMenuBar();
        window.setSize(400, 500);
        if (haveButton == true){
            standardButton = new JButton("StandaardButton");
        }
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initMenuBar(){
        menuBar = new JMenuBar();
        menu = new JMenu("Test");
        menuBar.add(menu);

        JMenuItem menuItem = new JMenuItem("A test");
        menu.add(menuItem);
        window.setJMenuBar(menuBar);
    }
    public void showWindow(){
        window.pack();
        mainPanel.setVisible(true);
        window.setVisible(true);
    }
    public JFrame getWindow(){
        return this.window;
    }
    public Container getContainer(){
        return this.content;
    }
    public JPanel getMainPanel(){ return this.mainPanel; }
    public JButton getStandardButton(){
        return this.standardButton;
    }
}
