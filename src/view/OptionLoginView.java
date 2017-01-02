package view;

import javax.swing.*;

/**
 * Created by User on 28/11/2016.
 */
public class OptionLoginView extends JDialog{


    JFrame frame = new JFrame();

    public OptionLoginView(){
    }

    public boolean showOptionPaneLogin(){

        int reply = JOptionPane.showConfirmDialog(null,"Wilt u inloggen als admin?", "Inloggen als admin", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            return true;
        }
        else {
            return false;
        }
    }

}
