package klaseis;

import elegxoi.ElegxoiMetablhtwn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trainer {

    private int trainerId;
    private String firstName;
    private String lastName;
    private String subject;

    private Scanner scan = new Scanner(System.in);
    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn(); //gia na elegxoume tis times pou eisagei o xrhsths

    public Trainer() {

    }

    public Trainer(int trainerId, String firstName, String lastName, String subject) {
        this.trainerId = trainerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public void dhmiourgiaTrainer(Statement stm) {
        try {
            String epilogh = "n";

            do {
                System.out.println("DWSE ONOMA EKPAIDEUTH");
                this.firstName = em.ElegxosGiaStringMeChars();//elegxoume thn periptwsh pou o xrhsths den eisagei mono grammat
                System.out.println("DWSE EPONUMO EKPAIDEUTH");
                this.lastName = em.ElegxosGiaStringMeChars();
                System.out.println("DWSE TO SUBJECT TOU EKPAIDEUTH");
               // this.subject = scan.nextLine();
                 this.subject = em.ElegxosGiaStringPouDexetaiKapoiousChars();

                //dhmiourgia query
                String sqlTrainer = "INSERT INTO TRAINERS VALUES (NULL, '" + firstName + "','" + lastName + "', '" + subject +"' )";
                stm.executeUpdate(sqlTrainer);

                System.out.println("8ES NA PROS8ESEIS K ALLO MA8HTH PATA 'n' -> GIA SUNEXEIA  's' -> gia stop ");
                epilogh = scan.nextLine();
                while (!epilogh.equals("s") && !epilogh.equals("n")) {
                    System.out.println("Den edwses tous char 'n' or 's'");
                    epilogh = scan.nextLine();
                }

            } while (!epilogh.equals("s"));

        } catch (SQLException ex) {
            Logger.getLogger(Trainer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //*****************GET ME8ODOI*******************************
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }

    public int getTrainerId() {
        return trainerId;
    }
    
    

}
