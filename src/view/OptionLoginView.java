package view;

import javax.swing.*;

/**
 * Created by User on 28/11/2016.
 */
public class OptionLoginView extends JDialog{


    JFrame frame = new JFrame();

    public OptionLoginView(){
        showOptionPaneLogin();

    }

    public void showOptionPaneLogin(){


        final JOptionPane optionPane = new JOptionPane(
                "Wilt u inloggen als admin?\n",
                JOptionPane.QUESTION_MESSAGE,
                JOptionPane.YES_NO_OPTION);

        JTextField t = new JTextField();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.add(optionPane);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        OptionLoginView t = new OptionLoginView();
        t.showOptionPaneLogin();
    }


}
