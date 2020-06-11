package dhmiourgiaBasewndedomenwn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import klaseis.AssignmentCourse;
import klaseis.Course;

public class BashAssignment {

    public BashAssignment() {
    }

  /*  public void emfanishAssignments(Statement stm) {
        try {
            //ftiaxnw to query mou
            String sqlAssignment = "SELECT A.ASSIGNMENT_ID , A.TITLE , A.DESCRIPTION, A.SUBDATE_TIME, A.COURSE_ID "
                    + ", C.TITLE, C.STREAM, C.TYPE, C.START_DATE, C.END_DATE\n"
                    + "FROM ASSIGNMENTS A, COURSES C\n"
                    + "WHERE A.COURSE_ID = C.COURSE_ID;"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlAssignment); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
            System.out.format("%5s %8s %15s %15s %10s  %8s %9s %8s %13s %12s  %n", "Assignment Id", "Title", "Subdate Time", "Description", "Course Id", "Title", "Stream", "Type", "Start Date", "End Date");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%6s %14s %15s %12s %10s  %12s %9s %8s %13s %12s  %n", rs.getInt("ASSIGNMENT_ID"), rs.getString("TITLE"),
                        rs.getString("SUBDATE_TIME"), rs.getString("DESCRIPTION"), rs.getInt("COURSE_ID"), rs.getString("TITLE"),
                        rs.getString("STREAM"), rs.getString("TYPE"), rs.getString("START_DATE"), rs.getString("END_DATE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/
    public void emfanishAssignments(Statement stm) {
        try {
            //ftiaxnw to query mou
            String sqlAssignment = "SELECT A.ASSIGNMENT_ID , A.TITLE , A.DESCRIPTION, A.SUBDATE_TIME, A.COURSE_ID "
                    + ", C.TITLE, C.STREAM, C.TYPE, C.START_DATE, C.END_DATE\n"
                    + "FROM ASSIGNMENTS A, COURSES C\n"
                    + "WHERE A.COURSE_ID = C.COURSE_ID;"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlAssignment); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
           // System.out.format("%5s %8s %15s %15s %10s  %8s %9s %8s %13s %12s  %n", "Assignment Id", "Title", "Subdate Time", "Description", "Course Id", "Title", "Stream", "Type", "Start Date", "End Date");
            System.out.format("%5s %8s %15s  %10s  %8s %9s %8s %13s %12s  %n", "Assignment Id", "Title", "Subdate Time", "Course Id", "Title", "Stream", "Type", "Start Date", "End Date");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
            /*    System.out.format("%6s %14s %15s %12s %10s  %12s %9s %8s %13s %12s  %n", rs.getInt("ASSIGNMENT_ID"), rs.getString("TITLE"),
                        rs.getString("SUBDATE_TIME"), rs.getString("DESCRIPTION"), rs.getInt("COURSE_ID"), rs.getString("TITLE"),
                        rs.getString("STREAM"), rs.getString("TYPE"), rs.getString("START_DATE"), rs.getString("END_DATE"));  */
                System.out.format("%6s %14s %15s  %10s  %12s %9s %8s %13s %12s  %n", rs.getInt("ASSIGNMENT_ID"), rs.getString("TITLE"),
                        rs.getString("SUBDATE_TIME"),  rs.getInt("COURSE_ID"), rs.getString("TITLE"),
                        rs.getString("STREAM"), rs.getString("TYPE"), rs.getString("START_DATE"), rs.getString("END_DATE")); 

            }
        } catch (SQLException ex) {
            Logger.getLogger(BashAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    public ArrayList dhmiourgiaArrayListAssignementCourse(Statement stm) {
        ArrayList<AssignmentCourse> assignmentsCourses = new ArrayList<AssignmentCourse>();
        try {
            //ftiaxnw to query mou
            String sqlBashAssignementCourse = "SELECT * FROM ASSIGNMENTS";
            ResultSet rs = stm.executeQuery(sqlBashAssignementCourse); //emfanizoume ta apotelesmata ths bashs mas        
            while (rs.next()) {
                int assignmentId = rs.getInt("ASSIGNMENT_ID");
                String title = rs.getString("TITLE");
                String description = rs.getString("DESCRIPTION");
                String subDateTime = rs.getString("SUBDATE_TIME");
                int courseId = rs.getInt("COURSE_ID");

                AssignmentCourse bsc = new AssignmentCourse(assignmentId, title, description, subDateTime, courseId);
                assignmentsCourses.add(bsc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudentCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assignmentsCourses;
    }

    public void emfanishAssignmentsMesugkekrimenoCourseId(Statement stm, int courseId) {
        try {
            String sqlStudent = " SELECT COURSES.COURSE_ID, ASSIGNMENTS.ASSIGNMENT_ID, ASSIGNMENTS.TITLE, ASSIGNMENTS.SUBDATE_TIME \n"
                    + "FROM  ASSIGNMENTS ,  COURSES\n"
                    + "WHERE ASSIGNMENTS.COURSE_ID =  COURSES.COURSE_ID\n"
                    + "  AND ASSIGNMENTS.COURSE_ID = " + courseId; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlStudent);
            System.out.format("%10s %13s %15s %18s %n", "Course Id", "Assignment_ID", "Title", "Subdate Time");
            System.out.println("----------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %14s %16s %16s  %n", rs.getInt("COURSE_ID"), rs.getInt("ASSIGNMENT_ID"), rs.getString("TITLE"), rs.getString("SUBDATE_TIME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudentCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public int assignmentId(Statement stm, int i , int courseId) {
        int assignmentId = 0;
        try {
            String sqlAssignment = "SELECT * FROM ASSIGNMENTS;"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlAssignment); //emfanizoume ta apotelesmata ths bashs mas
            while (rs.next()) {
                if (rs.getInt("COURSE_ID") == courseId && rs.getInt("ASSIGNMENT_ID") == i) {
                    assignmentId = rs.getInt("ASSIGNMENT_ID");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return assignmentId;
    }

}
