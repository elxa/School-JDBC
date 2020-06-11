package dhmiourgiaBasewndedomenwn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentsPouAnhkounSeParapanwCourses {

    public void emfanishStudentsPouAnhkounSeParapanwCourses(Statement stm) {
        //  public void emfanishStudents() {
        try {
            //ftiaxnw to query mou
            String sqlStudentPouAnhkounSeParapanwCourses = "SELECT STUDENTS.STUDENT_ID, STUDENTS.FIRST_NAME, STUDENTS.LAST_NAME, COUNT(COURSES.COURSE_ID) AS NUMBER_OF_COURSE\n"
                    + "FROM STUDENTS , STUDENTS_COURSES , COURSES \n"
                    + "WHERE STUDENTS.STUDENT_ID = STUDENTS_COURSES.STUDENT_ID\n"
                    + "AND STUDENTS_COURSES.COURSE_ID = COURSES.COURSE_ID\n"
                    + "GROUP BY STUDENTS_COURSES.STUDENT_ID\n"
                    + " HAVING COUNT(STUDENTS_COURSES.COURSE_ID) > 1;"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlStudentPouAnhkounSeParapanwCourses); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
            System.out.format("%10s %13s %15s  %n", "STUDENT_ID", "First Name", "Last Name");
            System.out.println("---------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %15s %15s  %n", rs.getInt("STUDENT_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
