package klaseis;

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
import tools.Ypar3hStoixeiwnSthnLista;

public class StudentCourse {

    Course course = new Course();
    Student student = new Student();
    BashCourse bc = new BashCourse();
    BashStudent bS = new BashStudent();
    BashStudentCourse bSC = new BashStudentCourse();
    Scanner scan = new Scanner(System.in);
    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn();
    // Ypar3hStoixeiwnSthnLista up = new Ypar3hStoixeiwnSthnLista();

    public StudentCourse() {
    }

    public StudentCourse(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public void antistoixiaStudentsMeCourses(Statement stm, ArrayList<Student> students, ArrayList<Course> courses) {
        String epilogh = " ";
        boolean existList = true;
        int courseId = 0;
        int studentId = 0;
        if (courses.isEmpty()) {
            System.out.println("Den uparxoun courses");
            existList = false; //efoson den uparxei bgainoume e3w apo th me8odo
        }
        if (students.isEmpty()) {
            System.out.println("Den uparxoun students");
            existList = false;
        } else {
            while (!epilogh.equals("s") && existList == true) {
                try {
                    System.out.println("******************Exoume ta e3hs Courses************************");
                    System.out.println("");
                    bc.emfanishCourses(stm);
                    System.out.println("");
                    System.out.println("*****************Exoume tous e3hs Students*************************");
                    System.out.println("");
                    bS.emfanishStudents(stm);

                    System.out.println("Diale3e to Course ");
                    int epiloghCourses = 0;
                    epiloghCourses = em.ElegxosGiaIntMetablhth(epiloghCourses);

                    courseId = bc.courseId(stm, epiloghCourses);

                    System.out.println("Diale3e to Student");
                    int epiloghStudent = 0;
                    epiloghStudent = em.ElegxosGiaIntMetablhth(epiloghStudent);
                    studentId = bS.studentId(stm, epiloghStudent);

                    String sqlStudentCourse = "INSERT INTO STUDENTS_COURSES VALUES (" + studentId + "," + courseId + ")";
                    stm.executeUpdate(sqlStudentCourse);

                } catch (SQLException ex) {
                    System.out.println("1)XRHSIMOPOIHSES ARI8MO POU DEN UPARXEI h 2)YPARXEI HDH STH BASH H KATAXWRHSH POU KANEIS");
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

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public BashCourse getBc() {
        return bc;
    }

    public BashStudent getbS() {
        return bS;
    }

}
