package tools;

import dhmiourgiaBasewndedomenwn.BashAssignment;
import dhmiourgiaBasewndedomenwn.BashCourse;
import dhmiourgiaBasewndedomenwn.BashStudent;
import dhmiourgiaBasewndedomenwn.BashStudentAssignmentPerCourse;
import dhmiourgiaBasewndedomenwn.BashStudentCourse;
import dhmiourgiaBasewndedomenwn.BashTrainer;
import dhmiourgiaBasewndedomenwn.BashTrainerCourse;
import dhmiourgiaBasewndedomenwn.StudentsPouAnhkounSeParapanwCourses;
import elegxoi.ElegxoiMetablhtwn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import klaseis.AssignmentCourse;
import klaseis.Course;
import klaseis.Student;
import klaseis.StudentAssignementPerCourse;
import klaseis.StudentCourse;
import klaseis.Trainer;
import klaseis.TrainerCourse;

public class MenouEpilogwn {

    private int i;

    Scanner scan = new Scanner(System.in);
    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn(); //gia na elegxoume tis times pou eisagei o xrhsths

    BashStudent bS = new BashStudent();
    BashTrainer bT = new BashTrainer();
    BashCourse bC = new BashCourse();
    BashAssignment bA = new BashAssignment();
    BashStudentCourse bSC = new BashStudentCourse();
    BashTrainerCourse bTC = new BashTrainerCourse();
    BashStudentAssignmentPerCourse bSAC = new BashStudentAssignmentPerCourse();
    StudentsPouAnhkounSeParapanwCourses studentsPouAnhkounSeParapanwCourses = new StudentsPouAnhkounSeParapanwCourses();

    Student s = new Student();
    Trainer t = new Trainer();
    Course c = new Course();
    AssignmentCourse ac = new AssignmentCourse();
    StudentCourse sc = new StudentCourse();
    TrainerCourse tc = new TrainerCourse();
    StudentAssignementPerCourse sac = new StudentAssignementPerCourse();

    Connection con = null;
    Statement stm;

    public MenouEpilogwn() {

    }

    public boolean menouMeToDikaiwmaEpiloghs() {
        try {
            int choise = 5;

//sthn periptwsh pou 8es na guriseis sthn arxikh lista menou
            String returnStoArxikoMenou = "";
            String returnMenouMeListes = "";
            //***********************GIA NA SUNDE8EI ME TH BASH PREPEI NA BALEIS TON KWDIKO**************************************************
            String password = "1234";

//dhmiourgw thn sundesh java - server auto to bazw giati den pairnei tis dates
            String connect = "jdbc:mysql://localhost:3306/school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
            con = DriverManager.getConnection(connect, "root", password);
            stm = con.createStatement();

            while (!returnStoArxikoMenou.equals("r")) {
                while (choise != 1 && choise != 2) {
                    System.out.println("*****************************O XRHSTHS PROS8ETEI TA DEDOMENA************************************");
                    System.out.println("1) EAN 8ES NA PROS8ESEIS ESY TA STOIXEIA ");
                    System.out.println("2) EAN 8ES NA TA DEIS TA DEDOMENA SOU ");
                    choise = em.ElegxosGiaIntMetablhth(choise); //ELEGXEI THN EPILOGH POU EDWSE AN EINAI INT
                }

                System.out.println("1. Για λιστα students ");
                System.out.println("2. Για λιστα Trainers ");
                System.out.println("3. Για λιστα Courses ");
                System.out.println("4. Για λιστα Assignments - Courses ");
                System.out.println("5. Για λιστα students - courses ");
                System.out.println("6. Εμφανιση λιστας Trainers - courses ");
                System.out.println("7. Εμφανιση λιστας Assignments - Students ");
                System.out.println("8. Εμφανιση λιστας Μαθητων που ανηκουν παραπανω απο ενα μαθηματα");

                System.out.println("Dwse poia epilogh 8es");
                i = em.ElegxosGiaIntMetablhth(i);
                while (i < 1 || i > 8) {
                    System.out.println("Edwses la8os epilogh 3anadwse");
                    i = Integer.parseInt(scan.nextLine());
                }
//*******************************************ta dhmiourgoume emeis**************************************************************************

                if (choise == 1) {
                    if (i == 1) {
                        System.out.println("*********************STUDENTS***********************************");
                        s.dhmiourgiaStudent(stm);
                    } else if (i == 2) {
                        System.out.println("*********************TRAINERS***********************************");
                        t.dhmiourgiaTrainer(stm);
                    } else if (i == 3) {
                        System.out.println("*********************COURSES***********************************");
                        c.dhmiourgiaCourse(stm);
                    } else if (i == 4) {
                        System.out.println("*********************ASSIGNMENTS - COURSES***********************************");
                        ac.dhmiourgiaAssignment(stm, bC.dhmiourgiaArraylistCourse(stm));
                    } else if (i == 5) {
                        System.out.println("*********************DHMIOURGIA ANTISTOIXIA STUDENTS - COURSES***********************************");
                        sc.antistoixiaStudentsMeCourses(stm, bS.dhmiourgiaArraylistStudent(stm), bC.dhmiourgiaArraylistCourse(stm));
                    } else if (i == 6) {
                        System.out.println("*********************DHMIOURGIA ANTISTOIXIA COURSES - TRAINERS***********************************");
                        tc.antistoixiaTrainersMeCourses(stm, bT.dhmiourgiaArraylistTrainer(stm), bC.dhmiourgiaArraylistCourse(stm));
                    } else if (i == 7) {
                        System.out.println("*********************DHMIOURGIA ANTISTOIXIA STUDENTS - ASSIGMENTS***********************************");
                        sac.antistoixiaStudentsAssignmentPerCourse(stm, bSC.dhmiourgiaArrayListStudentCourse(stm), bA.dhmiourgiaArrayListAssignementCourse(stm));
                    } else if (i == 8) {
                        System.out.println("*********************DHMIOURGIA ANTISTOIXIA STUDENTS - ASSIGMENTS***********************************");
                        System.out.println("Gia na deis tous Students pou anhkoun se parapanw apo 1 Course pata thn epilogh 2 k meta thn epilogh 8");
                    }

                } else if (choise == 2) {
                    if (i == 1) {
                        System.out.println("***************************STUDENTS***************************************");
                        bS.emfanishStudents(stm);

                    } else if (i == 2) {
                        System.out.println("***************************TRAINERS***************************************");
                        bT.emfanishTrainers(stm);
                    } else if (i == 3) {
                        System.out.println("****************************COURSES****************************************");
                        bC.emfanishCourses(stm);
                    } else if (i == 4) {
                        System.out.println("*********************ASSIGNMENTS - COURSES***********************************");
                        bA.emfanishAssignments(stm);
                    } else if (i == 5) {
                        System.out.println("*********************STUDENTS - COURSES***********************************");
                        bSC.emfanishStudentCourse(stm);
                    } else if (i == 6) {
                        System.out.println("*********************COURSES - TRAINERS***********************************");
                        bTC.emfanishTrainerCourse(stm);
                    } else if (i == 7) {
                        System.out.println("*********************STUDENTS - ASSIGMENTS***********************************");
                        bSAC.emfanishStudentAssignmentPerCourse(stm);
                    } else if (i == 8) {
                        System.out.println("*********************MA8HTES POU ANHKOUN SE PARAPANW APO 1 COURSE***********************************");
                        studentsPouAnhkounSeParapanwCourses.emfanishStudentsPouAnhkounSeParapanwCourses(stm);

                    }
                }

                    System.out.println("Ean 8es na guriseis sto arxiko menou gia na epile3eis 1)an 8es na mpeis sth bash dedomenwn "
                            + "2)h na pros8eseis dedemena    h pata 'r' alliws pata kapoia allo koumpi");
                    returnStoArxikoMenou = scan.nextLine();
                

                System.out.println("Ean 8es na termathsei to programma pata 'stop' alliws pata kapoio allo koumpi");
                String telos = scan.nextLine();
                if (telos.equals("stop")) {
                    return true;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(MenouEpilogwn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

}
