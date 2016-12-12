import controller.*;

import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
/**
 * Created by Manish on 10/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        if (checkInternetConnection() == true){
            LoginController loginController = new LoginController();
            loginController.showLoginScreen();
        }
        else {
            int reply = JOptionPane.showConfirmDialog(null, "Controleer je internetconnectie en probeer opnieuw!", "Geen connectie", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
                main(null);
            }
        }
    }
    private static boolean checkInternetConnection(){
        try {
            final URL url = new URL("http://www.google.com");
            final URLConnection conn = url.openConnection();
            conn.connect();
            return true;
        } catch (MalformedURLException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            return false;
        }
    }
}