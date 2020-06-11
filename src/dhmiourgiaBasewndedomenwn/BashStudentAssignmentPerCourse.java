package dhmiourgiaBasewndedomenwn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BashStudentAssignmentPerCourse {

    public void emfanishStudentAssignmentPerCourse(Statement stm) {
        try {
            //ftiaxnw to query mou
            String sqlBashStudentCourse = "SELECT S.STUDENT_ID, S.FIRST_NAME, S.LAST_NAME, C.COURSE_ID, C.TITLE, C.STREAM, C.TYPE, A.ASSIGNMENT_ID, A.TITLE, A.SUBDATE_TIME, SA.ORAL_MARK, SA.TOTAL_MARK\n"
                    + "FROM STUDENTS S, STUDENTS_ASSIGNMENTS SA, COURSES C, ASSIGNMENTS A \n"
                    + "WHERE S.STUDENT_ID = SA.STUDENT_ID\n"
                    + "AND SA.COURSE_ID = C.COURSE_ID\n"
                    + "AND A.COURSE_ID = C.COURSE_ID";
            ResultSet rs = stm.executeQuery(sqlBashStudentCourse); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
            System.out.format("%10s %13s %15s %18s %10s %10s %10s    %10s %10s %10s  %n", "STUDENT_ID", "First Name", "Last Name", "Course Id", "Tittle", "Stream", "Type", "Assigment Id", "Oral Mark", "Total Mark");
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %14s %16s %16s %14s %11s %12s   %10s %10s %10s %n", rs.getInt("STUDENT_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), 
                        rs.getInt("COURSE_ID"), rs.getString("TITLE"),
                        rs.getString("STREAM"), rs.getString("TYPE"),
                rs.getInt("ASSIGNMENT_ID"),rs.getDouble("ORAL_MARK"), rs.getDouble("TOTAL_MARK")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudentCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
