package dhmiourgiaBasewndedomenwn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import klaseis.Course;
import klaseis.Student;

public class BashCourse {

    ArrayList<Course> courses = new ArrayList();
    ArrayList<Course> newCourses = new ArrayList();
    Scanner scan = new Scanner(System.in);

    public BashCourse() {
    }

    public void emfanishCourses(Statement stm) {
        try {
            //ftiaxnw to query mou
            String sqlCourses = "SELECT * FROM COURSES"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlCourses); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
            System.out.format("%5s %8s %9s %10s %16s %11s %n", "Course Id", "Title", "Stream", "Type", "Start Date", "End Date");
            System.out.println("----------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %11s %9s %14s %13s %12s %n", rs.getInt("COURSE_ID"), rs.getString("TITLE"),
                        rs.getString("STREAM"), rs.getString("TYPE"), rs.getString("START_DATE"), rs.getString("END_DATE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int courseId(Statement stm, int i) {
        int courseId = 0;
        try {
            String sqlCourses = "SELECT * FROM COURSES"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlCourses); //emfanizoume ta apotelesmata ths bashs mas
            while (rs.next()) {
                if (rs.getInt("COURSE_ID") == i) {
                    courseId = rs.getInt("COURSE_ID");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseId;
    }
    
        public String courseStartDate(Statement stm, int i) {
        String courseStartDate = "";
        try {
            String sqlCourses = "SELECT * FROM COURSES"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlCourses); //emfanizoume ta apotelesmata ths bashs mas
            while (rs.next()) {
                if (rs.getInt("COURSE_ID") == i) {
                    courseStartDate = rs.getString("START_DATE");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseStartDate;
    }
        
        public String courseEndDate(Statement stm, int i) {
        String courseEndDate = "";
        try {
            String sqlCourses = "SELECT * FROM COURSES"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlCourses); //emfanizoume ta apotelesmata ths bashs mas
            while (rs.next()) {
                if (rs.getInt("COURSE_ID") == i) {
                    courseEndDate = rs.getString("END_DATE");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseEndDate;
    }

    public ArrayList dhmiourgiaArraylistCourse(Statement stm) throws SQLException {
        ArrayList<Course> courses = new ArrayList();
        //ftiaxnw to query mou
        String sqlCourses = "SELECT * FROM COURSES"; //8a emfanisei olous tous students
        ResultSet rs = stm.executeQuery(sqlCourses); //emfanizoume ta apotelesmata ths bashs mas
        while (rs.next()) {
            Course c = new Course(rs.getInt("COURSE_ID"), rs.getString("TITLE"),
                    rs.getString("STREAM"), rs.getString("TYPE"), rs.getString("START_DATE"), rs.getString("END_DATE"));
            courses.add(c);
        }
        return courses;
    }

    public ArrayList<Course> getNewCourses() {
        return newCourses;
    }

}
