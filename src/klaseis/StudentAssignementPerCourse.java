package klaseis;

import dhmiourgiaBasewndedomenwn.BashAssignment;
import dhmiourgiaBasewndedomenwn.BashCourse;
import dhmiourgiaBasewndedomenwn.BashStudent;
import dhmiourgiaBasewndedomenwn.BashStudentCourse;
import elegxoi.ElegxoiMetablhtwn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentAssignementPerCourse {

    BashCourse bc = new BashCourse();
    BashStudent bS = new BashStudent();
    BashStudentCourse bSC = new BashStudentCourse();
    BashAssignment bA = new BashAssignment();
    Scanner scan = new Scanner(System.in);
    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn();

    public void antistoixiaStudentsAssignmentPerCourse(Statement stm, ArrayList<BashStudentCourse> studentsCourses, ArrayList<AssignmentCourse> assignmentsCourses) {
        String stop = " ";
        String epilogh = " ";
        String sunexeiaGiaBa8mologhshStudent = "";
        boolean existList = true;
        String akurswshDhmiourgiaStudentAssignment = "";
        int courseId = 0;
        int studentId = 0;
        int assignmentId = 0;
        double oralMark = 0;
        double totalMark = 0;

        if (studentsCourses.isEmpty()) {
            System.out.println("Den uparxoun dedomena students - courses");
            existList = false; //efoson den uparxei bgainoume e3w apo th me8odo
        }
        if (assignmentsCourses.isEmpty()) {
            System.out.println("Den uparxoun Den uparxoun dedomena assignments - courses");
            existList = false;
        } else {
            while (!epilogh.equals("s") && existList == true) {
                System.out.println("******************Exoume ta e3hs Courses************************");
                System.out.println("");
                bc.emfanishCourses(stm);
                System.out.println("");
                System.out.println("Diale3e to Course ");
                int epiloghCourses = 0;
                epiloghCourses = em.ElegxosGiaIntMetablhth(epiloghCourses);
                courseId = bc.courseId(stm, epiloghCourses);//PAIRNOUME TO ID APO TON PINAKA

                System.out.println("*************************STUDENTS POU ANHKOUN STO SUGKEKRIMENO COURSE**************************************************");
                bSC.emfanishStudentsMesugkekrimenoCourseId(stm, courseId);//emfanish twn students pou anhkoun se ena sugkekrimeno course sumfena me thn epilogh pou kanei o xrhsths                 
                System.out.println("");
                System.out.println("*************************ASSIGNMENTS TOU SUGKEKRIMENOY COURSE*******************************");
                bA.emfanishAssignmentsMesugkekrimenoCourseId(stm, courseId);//emfanish twn assignments pou anhkoun se ena sugkekrimeno course sumfena me thn epilogh pou kanei o xrhsths                 
                System.out.println("");

                System.out.println("Diale3e to Id tou student pou 8es");
                studentId = em.ElegxosGiaIntMetablhth(studentId);
                studentId = bSC.studentIdGiaSugkekrimenoCourse(stm, studentId, courseId);

                System.out.println(studentId);
                System.out.println("Diale3e to Id tou assignment pou 8es");
                assignmentId = em.ElegxosGiaIntMetablhth(studentId);
                assignmentId = bA.assignmentId(stm, assignmentId, courseId);
                System.out.println(assignmentId);

                //   String sqlStudentCourse = " INSERT INTO STUDENTS_ASSIGNMENTS VALUES (" + courseId + "," + studentId + "," + assignmentId + ","+oralMark+","+totalMark+")";
                String sqlStudentCourse = " INSERT INTO STUDENTS_ASSIGNMENTS VALUES (" + courseId + "," + studentId + "," + assignmentId + ",NULL,NULL)";
                try {
                    stm.executeUpdate(sqlStudentCourse);
                    System.out.println("pata 'n' gia na baleis tous ba8mous ston student ");
                    sunexeiaGiaBa8mologhshStudent = scan.nextLine();
                    while (!sunexeiaGiaBa8mologhshStudent.equals("n")) {
                        System.out.println("Den edwses ton char 'n' ");
                        sunexeiaGiaBa8mologhshStudent = scan.nextLine();
                    }
                } catch (SQLException ex) {
                    System.out.println("1)XRHSIMOPOIHSES ARI8MO POU DEN UPARXEI h 2)YPARXEI HDH STH BASH H KATAXWRHSH POU KANEIS");
                    System.out.println("pata 'q' gia akurwsh dhmiourgias student - assignment ");
                    akurswshDhmiourgiaStudentAssignment = scan.nextLine();
                    while (!akurswshDhmiourgiaStudentAssignment.equals("q")) {
                        System.out.println("Den edwses tous char 'q' ");
                        akurswshDhmiourgiaStudentAssignment = scan.nextLine();
                    }
                    //Logger.getLogger(StudentAssignementPerCourse.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (akurswshDhmiourgiaStudentAssignment.equals("q")) {
                    System.out.println("akurwsh eisagwghs student - assignement");
                }
                if (sunexeiaGiaBa8mologhshStudent.equals("n") && !akurswshDhmiourgiaStudentAssignment.equals("q")) {
                    System.out.println("egine h kataxwrhsh ston pinaka");
                    oralMark = oralMarkStudent();
                    totalMark = totalMarkStudent();
                    String sqlStudentCourseUpdate = " UPDATE students_assignments\n"
                            + " SET ORAL_MARK = '" + oralMark + "', TOTAL_MARK = '" + totalMark + "'\n"
                            + " WHERE COURSE_ID = " + courseId + " \n"
                            + " AND STUDENT_ID = " + studentId + "\n"
                            + " AND ASSIGNMENT_ID = " + assignmentId + ";"; 
                    try {
                        stm.executeUpdate(sqlStudentCourseUpdate);
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentAssignementPerCourse.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                System.out.println("8ES NA SUNEXISEIS PATA 'n' -> GIA SUNEXEIA  's' -> gia stop ");
                epilogh = scan.nextLine();
                while (!epilogh.equals("s") && !epilogh.equals("n")) {
                    System.out.println("Den edwses tous char 'n' or 's'");
                    epilogh = scan.nextLine();
                }
            }
        }

    }

    private double oralMarkStudent() {
        System.out.println("DWSE TON BA8MO THS KA8E ERGASIAS O OPOIOS 0 <= ORAL MARK < 40");
        double oralM = 0;
        oralM = em.ElegxosGiaDoubleMetablhth(oralM);
        while (oralM < 0 || oralM > 40) {
            System.out.println("O oral Mark prepei na einai 0 < oral Mark < 40");
            oralM = em.ElegxosGiaDoubleMetablhth(oralM);
        }
        return oralM;
    }

    private double totalMarkStudent() {
        System.out.println("DWSE TON SUNOLIKO BA8MO O OPOIOS 0 <= TOTAL MARK < 60");
        double totalM = 0;
        totalM = em.ElegxosGiaDoubleMetablhth(totalM);
        while (totalM < 0 || totalM > 60) {
            System.out.println("O total Mark prepei na einai 0 < total Mark < 60");
            totalM = em.ElegxosGiaDoubleMetablhth(totalM);
        }
        return totalM;
    }

}
