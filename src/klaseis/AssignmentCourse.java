package klaseis;

import dhmiourgiaBasewndedomenwn.BashCourse;
import elegxoi.ElegxoiMetablhtwn;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.SugrishHmeromhniwn;

public class AssignmentCourse {
    
        private int assignmentId;
    private String title;
    private String description;
    private String subDateTime;
    private double oralMark;
    private double totalMark;
    private int courseId = 0;

    private static ArrayList<AssignmentCourse> assignments = new ArrayList<AssignmentCourse>();
    Scanner scan = new Scanner(System.in);
    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn(); //gia na elegxoume tis times pou eisagei o xrhsths
    BashCourse bc = new BashCourse();
    //DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_DATE;
    DateValidator validator = new DateValidatorUsingLocalDate(dateFormatter);

    public AssignmentCourse() {
    }
    

    public AssignmentCourse(int assignmentId, String title, String description, String subDateTime, int courseId ) {
        this.assignmentId = assignmentId;
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.courseId = courseId;
    }

    public void dhmiourgiaAssignment(Statement stm, ArrayList<Course> courses) {
        try {
            String epilogh = "n";
            boolean existList = true;
            boolean epitreptoAssignement = false;
            String startDateCourse = "";
            String endDateCourse = "";
            String akurswshAssignment = "";

            if (courses.isEmpty()) {
                System.out.println("Den uparxoun courses");
                existList = false; //efoson den uparxei bgainoume e3w apo th me8odo
            } else {
                do {
                    System.out.println("DWSE TON TITLO THS ERGASIAS");
                    this.title = em.ElegxosGiaStringMeChars();
                    System.out.println("DWSE THN PERIGRAFH");
                      this.description = em.ElegxosGiaStringPouDexetaiKapoiousChars();
                   // this.description = scan.nextLine();
                    System.out.println("DWSE THN HMEROMHNIA UPOBOLHS yyyy-MM-dd");
                    //elegxoume ean o xrhsths exei balei swstsa thn date
                    boolean trueDate = false;
                    while (trueDate != true) {
                        subDateTime = scan.nextLine();
                        trueDate = validator.isValid(subDateTime);
                    }

                    do {
                        System.out.println("******************Exoume ta e3hs Courses************************");
                        System.out.println("");
                        bc.emfanishCourses(stm);
                        System.out.println("");
                        System.out.println("Diale3e to Course pou 8es na pros8eseis to Assignment");
                        courseId = em.ElegxosGiaIntMetablhth(courseId);

                        startDateCourse = bc.courseStartDate(stm, courseId);
                        endDateCourse = bc.courseEndDate(stm, courseId);

                        System.out.println("ean 8es na akurwseis thn dhmiourgia assignment pata 'q' alliws pata 'n' - > gia na sunexiseis thn kataxwrish ");
                        akurswshAssignment = scan.nextLine();
                        while (!akurswshAssignment.equals("q") && !akurswshAssignment.equals("n")) {
                        System.out.println("Den edwses tous char 'q' or 'n' ");
                        akurswshAssignment = scan.nextLine();
                    }
                        if (akurswshAssignment.equals('q')) {
                            break;
                        } else {

                            if ((SugrishHmeromhniwn.sugkrishDatesAssignmentCourse(subDateTime, startDateCourse) == true)
                                    && (SugrishHmeromhniwn.sugkrishDatesAssignmentCourse(subDateTime, endDateCourse) == false)) {
                                epitreptoAssignement = true;
                            }
                        }
                    } while (!akurswshAssignment.equals("q") && epitreptoAssignement != true);

                    if (akurswshAssignment.equals("q")) {
                        System.out.println("akurwsh eisagwghs assignement");
                        break;
                    } 
                    if(!akurswshAssignment.equals("q") && epitreptoAssignement == true) {
                        System.out.println("Egine h kataxwrhsh tou assignment");
                        //dhmiourgia query
                        String sqlAssignment = "INSERT INTO ASSIGNMENTS VALUES (NULL, '" + title + "','" + description + "', '" + subDateTime + "', '" + courseId + "' )";
                        stm.executeUpdate(sqlAssignment);
                    }
                    System.out.println("8ES NA PROS8ESEIS KAPOIA ALLH ERGASIA PATA 'n' -> GIA SUNEXEIA  's' -> gia stop ");
                    epilogh = scan.nextLine();
                    while (!epilogh.equals("s") && !epilogh.equals("n")) {
                        System.out.println("Den edwses tous char 'n' or 's'");
                        epilogh = scan.nextLine();
                    }
                } while (!epilogh.equals("s"));
            }
        } catch (SQLException ex) {
           // System.out.println("XRHSIMOPOIHSES ARI8MO POU DEN UPARXEI h uparxei hdh sth bash h kataxwrhsh pou kaneis");
           Logger.getLogger(AssignmentCourse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubDateTime() {
        return subDateTime;
    }

    public double getOralMark() {
        return oralMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public int getCourseId() {
        return courseId;
    }
    
    
    
}
