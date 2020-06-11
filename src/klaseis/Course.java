package klaseis;

import elegxoi.ElegxoiMetablhtwn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.SugrishHmeromhniwn;

public class Course {

    private int courseId;
    private String title; //
    private String stream;  //java, c#
    private String type; //full time part
    private String start_date;
    private String end_date;

    String date1;
    String date2;

    static ArrayList<Course> courses = new ArrayList<Course>();
    Scanner scan = new Scanner(System.in);
    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn();

    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE; //auto to pattern leitourgei ean 8eloume na kanoume sugkrishh dates 
    DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);
    DateValidatorUsingLocalDate dateValidatorUsingLocalDate = new DateValidatorUsingLocalDate();

    public Course() {
    }

    public Course(int courseId, String title, String stream, String type, String start_date, String end_date) {
        this.courseId = courseId;
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_date = start_date;
        this.end_date = end_date;
    }
    

    public void dhmiourgiaCourse(Statement stm) {
        try {
            String epilogh = "n";

            do {
                System.out.println("DWSE TON TITLO TOU MA8HMATOS");
                 this.title = em.ElegxosGiaStringPouDexetaiKapoiousChars();
              //  this.title = scan.nextLine();
                System.out.println("DWSE TO STREAM");
                  this.stream = em.ElegxosGiaStringPouDexetaiKapoiousChars();
                //this.stream = scan.nextLine();
                System.out.println("DWSE TO TYPE");
                  this.type = em.ElegxosGiaStringPouDexetaiKapoiousChars();
               // this.type = scan.nextLine();
                //8a prepei na pros8esoume periorismo se periptwsh pou o xrhsths eisagei eisagei thn hmeromhnia lh3hs megaluterh apo thn hmeromhnia enar3hs
                do {
                    System.out.println("DWSE THN HMEROMHNIA POU ARXISAN TA MA8HMATA (yyyy-MM-dd)");  //o xrhsth eisagei thn hmeromhnia k elegxei an thn exei eisagei swsta
                    boolean trueDate1 = false;
                    while (trueDate1 == false) {
                        trueDate1 = validator.isValid(start_date = scan.nextLine());
                    }
                    date1 = dateValidatorUsingLocalDate.getDate();
                    System.out.println("DWSE THN HMEROMHNIA LH3HS TWN MA8HMATWN (yyyy-MM-dd)");//o xrhsth eisagei thn hmeromhnia k elegxei an thn exei eisagei swsta
                    boolean trueDate2 = false;
                    while (trueDate2 == false) {
                        trueDate2 = validator.isValid(end_date = scan.nextLine());
                    }
                    date2 = dateValidatorUsingLocalDate.getDate();
                    SugrishHmeromhniwn.sugkrishDates(date1, date2);  //elegxos twn 2 dates sthn periptwsh pou h start_date einai meta ths end_date h loop 8a 3anatre3ei

                } while ((SugrishHmeromhniwn.sugkrishDates(date1, date2) == true)); //sthn periptwsh pou einai ises h start date > end date prepei na 3anadw8oun oi dates
                //dhmiourgia query
                String sqlCourse = "INSERT INTO COURSES VALUES (NULL, '" + title + "','" + stream + "', '" + type + "', '" + start_date + "', '" + end_date +"' )";
                stm.executeUpdate(sqlCourse);

                System.out.println("8ES NA PROS8ESEIS K ALLO COURSE PATA 'n' -> GIA SUNEXEIA  's' -> gia stop ");
                epilogh = scan.nextLine();
                while (!epilogh.equals("s") && !epilogh.equals("n")) {
                    System.out.println("Den edwses tous char 'n' or 's'");
                    epilogh = scan.nextLine();
                }

            } while (!epilogh.equals("s"));

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //************************GET ME8ODOI**********************************    
    public String getTitle() {
        return title;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getDate1() {
        return date1;
    }

    public String getDate2() {
        return date2;
    }

    public int getCourseId() {
        return courseId;
    }


    

}
