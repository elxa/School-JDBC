package dhmiourgiaBasewndedomenwn;

import com.mysql.cj.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import klaseis.Student;

public class BashStudent {

    public BashStudent() {
    }

    ArrayList<Student> students = new ArrayList();
    ArrayList<Student> newStudents = new ArrayList();

    public void emfanishStudents(Statement stm) {
        //  public void emfanishStudents() {
        try {
            //ftiaxnw to query mou
            String sqlStudent = "SELECT * FROM STUDENTS"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlStudent); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
            System.out.format("%10s %13s %15s %17s %17s %n", "STUDENT_ID", "First Name", "Last Name", "Date Of Birth", "Tuition Fees");           
            System.out.println("----------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %16s %16s %16s %16s %n", rs.getInt("STUDENT_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("DATE_OF_BIRTH"), rs.getDouble("TUITION_FEES"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int studentId(Statement stm, int i) {
        int studentId = 0;
        try {
            String sqlCourses = "SELECT * FROM STUDENTS"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlCourses); //emfanizoume ta apotelesmata ths bashs mas
            while (rs.next()) {
                if (rs.getInt("STUDENT_ID") == i) {
                    studentId = rs.getInt("STUDENT_ID");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentId;
    }  

    public ArrayList dhmiourgiaArraylistStudent(Statement stm) throws SQLException {
        //ftiaxnw to query mou
        ArrayList<Student> students = new ArrayList();
        String sqlStudent = "SELECT * FROM STUDENTS"; //8a emfanisei olous tous students
        ResultSet rs = stm.executeQuery(sqlStudent); //emfanizoume ta apotelesmata ths bashs mas
        while (rs.next()) {
            Student s = new Student(rs.getInt("STUDENT_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("DATE_OF_BIRTH"), rs.getDouble("TUITION_FEES"));
            students.add(s);
        }
        return students;
    }

    public ArrayList<Student> getNewStudents() {
        return newStudents;
    }

}
