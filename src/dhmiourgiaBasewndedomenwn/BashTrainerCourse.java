package dhmiourgiaBasewndedomenwn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BashTrainerCourse {

    public BashTrainerCourse() {
    }

    public void emfanishTrainerCourse(Statement stm) {
        try {
            //ftiaxnw to query mou
            String sqlBashTrainerCourse = "SELECT T.TRAINER_ID, T.FIRST_NAME, T.LAST_NAME, C.COURSE_ID, C.TITLE, C.STREAM, C.TYPE\n"
                    + "FROM TRAINERS T, TRAINERS_COURSES TC, COURSES C\n"
                    + "WHERE T.TRAINER_ID = TC.TRAINER_ID\n"
                    + "AND TC.COURSE_ID = C.COURSE_ID;"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlBashTrainerCourse); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
            System.out.format("%10s %13s %15s %18s %10s %10s %10s %n", "Trainer Id", "First Name", "Last Name", "Course Id", "Tittle", "Stream", "Type");
            System.out.println("----------------------------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %16s %16s %16s %12s %10s %15s  %n", rs.getString("TRAINER_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("COURSE_ID"), rs.getString("TITLE"),
                        rs.getString("STREAM"), rs.getString("TYPE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashTrainerCourse.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
