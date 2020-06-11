package dhmiourgiaBasewndedomenwn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import klaseis.Student;
import klaseis.StudentCourse;

public class BashStudentCourse {

    private int studentId;
    private int courseId;

    public BashStudentCourse() {
    }

    public BashStudentCourse(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public void emfanishStudentCourse(Statement stm) {
        try {
            //ftiaxnw to query mou
            String sqlBashStudentCourse = "SELECT S.STUDENT_ID, S.FIRST_NAME, S.LAST_NAME, C.COURSE_ID, C.TITLE, C.STREAM, C.TYPE\n"
                    + "FROM STUDENTS S, STUDENTS_COURSES SC, COURSES C\n"
                    + "WHERE S.STUDENT_ID = SC.STUDENT_ID\n"
                    + "AND SC.COURSE_ID = C.COURSE_ID";
            ResultSet rs = stm.executeQuery(sqlBashStudentCourse); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
            System.out.format("%10s %13s %15s %18s %10s %10s %10s %n", "STUDENT_ID", "First Name", "Last Name", "Course Id", "Tittle", "Stream", "Type");
            System.out.println("----------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %14s %16s %16s %14s %11s %12s  %n", rs.getString("STUDENT_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("COURSE_ID"), rs.getString("TITLE"),
                        rs.getString("STREAM"), rs.getString("TYPE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudentCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList dhmiourgiaArrayListStudentCourse(Statement stm) {
        ArrayList<BashStudentCourse> bashStudentCourses = new ArrayList<BashStudentCourse>();
        try {
            //ftiaxnw to query mou
            String sqlBashStudentCourse = "select * from students_courses";
            ResultSet rs = stm.executeQuery(sqlBashStudentCourse); //emfanizoume ta apotelesmata ths bashs mas        
            while (rs.next()) {
                int studentId = rs.getInt("STUDENT_ID");
                int courseId = rs.getInt("COURSE_ID");
                BashStudentCourse bsc = new BashStudentCourse(studentId, courseId);
                bashStudentCourses.add(bsc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudentCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bashStudentCourses;
    }

    public void emfanishStudentsMesugkekrimenoCourseId(Statement stm, int courseId) {
        try {
            String sqlStudent = "SELECT COURSES.COURSE_ID, STUDENTS.STUDENT_ID, STUDENTS.FIRST_NAME, STUDENTS.LAST_NAME \n"
                    + "FROM  COURSES ,  students_courses , STUDENTS \n"
                    + "WHERE students_courses.COURSE_ID =  COURSES.COURSE_ID\n"
                    + " AND students_courses.STUDENT_ID = STUDENTS.STUDENT_ID\n"
                    + " AND COURSES.COURSE_ID = " + courseId; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlStudent);
            System.out.format("%10s %13s %15s %18s %n", "Course Id", "STUDENT_ID", "First Name", "Last Name");
            System.out.println("----------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %14s %16s %16s  %n", rs.getString("COURSE_ID"), rs.getString("STUDENT_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudentCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int studentIdGiaSugkekrimenoCourse(Statement stm, int i, int courseId) {
        int studentId = 0;
        try {
            String sqlCourses = " SELECT *\n"
                    + "FROM STUDENTS_COURSES\n" +
            "WHERE STUDENTS_COURSES.COURSE_ID = "+ courseId; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlCourses); //emfanizoume ta apotelesmata ths bashs mas
            while (rs.next()) {
                //  if (rs.getInt("COURSE_ID") == courseId && rs.getInt("STUDENT_ID") == i) {
                if ( rs.getInt("STUDENTS_COURSES.STUDENT_ID") == i) {
                    studentId = rs.getInt("STUDENT_ID");
                    System.out.println("ddddd");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

}
