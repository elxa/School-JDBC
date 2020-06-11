package klaseis;

import elegxoi.ElegxoiMetablhtwn;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private int StudentId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private double tuitionFees;
    public String testDate;
    
    

    private Scanner scan = new Scanner(System.in);
    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn(); //gia na elegxoume tis times pou eisagei o xrhsths

    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
    //DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);

    ArrayList<Student> students = new ArrayList<>();

    public Student() {
    }

    public Student(int StudentId, String firstName, String lastName, String dateOfBirth, double tuitionFees) {
        this.StudentId = StudentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    public void dhmiourgiaStudent(Statement stm) {
        try {
            String epilogh = "n";

            do {
                System.out.println("DWSE ONOMA Ma8hth");
                firstName = em.ElegxosGiaStringMeChars();
                System.out.println("DWSE EPONUMO Ma8hth");
                this.lastName = em.ElegxosGiaStringMeChars();
                System.out.println("DWSE HMEROMHNIA GENNHSHS (yyyy-MM-dd) "); //o xrhsth eisagei thn hmeromhnia k elegxei an thn exei eisagei swsta
                boolean trueDate = false;
                while (trueDate != true) {
                    dateOfBirth = scan.nextLine();
                    trueDate = validator.isValid(dateOfBirth);
                }
//****ME TON TROPO AUTO ELEGXOUME EAN O XRHSTHS EXEI DWSEI DOUBLE METABLHTH GIA NA MHN PETAEI ERROR***********************
                tuitionFees = 0;
                System.out.println("DWSE dIDAKTRA");
                tuitionFees = em.ElegxosGiaDoubleMetablhth(tuitionFees);

                //dhmiourgia query
                String sqlStudent = "INSERT INTO STUDENTS VALUES (NULL, '" + firstName + "','" + lastName + "', '" + dateOfBirth + "', '" + tuitionFees + "' )";
                stm.executeUpdate(sqlStudent);

                System.out.println("8ES NA PROS8ESEIS K ALLO MA8HTH PATA 'n' -> GIA SUNEXEIA  's' -> gia stop ");
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

//************************GET ME8ODOI****************************    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public int getStudentId() {
        return StudentId;
    }
    
    

}
