package projectapartb;

import java.util.Scanner;
import tools.MenouEpilogwn;

public class ProjectAPartB {

    public static void main(String[] args) {

        MenouEpilogwn menou = new MenouEpilogwn();

        int choise = 5;
        boolean telos = false;

        System.out.println("To programma 8a stamathsei ews otou pathseis 'stop'");

        do {

            telos = menou.menouMeToDikaiwmaEpiloghs();
        } while (telos != true);

    }

}
