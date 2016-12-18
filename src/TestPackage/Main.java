package TestPackage;

import model.Traject;
import static controller.ParseController.*;

import java.util.List;

/**
 * Created by Nofel on 17-12-16.
 */
public class Main {
    public static void main(String[] args) {
        try {
            List<Traject> tra = getTraject("Liege-Guillemins", "Antwerpen-Centraal");

            // tra.forEach(e -> System.out.print(e));

            // Liveboard antw = getStationBoard("Merode");

            System.out.println(tra.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }
}
