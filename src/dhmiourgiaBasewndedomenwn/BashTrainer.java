package dhmiourgiaBasewndedomenwn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import klaseis.Course;
import klaseis.Trainer;

public class BashTrainer {

    public BashTrainer() {
    }
    ArrayList<Trainer> trainers = new ArrayList();
    ArrayList<Trainer> newtrainers = new ArrayList();

    public void emfanishTrainers(Statement stm) {
        try {
            //ftiaxnw to query mou
            String sqlTrainers = "SELECT * FROM TRAINERS;"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlTrainers); //emfanizoume ta apotelesmata ths bashs mas

            //emfanizoume oti uparxei sthn bash mas
            System.out.format("%10s %12s %18s %17s %n", "Trainer Id", "Last Name", "First Name", "Subject");
            System.out.println("----------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%5s %17s %18s %16s %n", rs.getInt("TRAINER_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("SUBJECT"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashTrainer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int trainerId(Statement stm, int i) {
        int trainerId = 0;
        try {
            String sqlTrainers = "SELECT * FROM TRAINERS"; //8a emfanisei olous tous students
            ResultSet rs = stm.executeQuery(sqlTrainers); //emfanizoume ta apotelesmata ths bashs mas
            while (rs.next()) {
                if (rs.getInt("TRAINER_ID") == i) {
                    trainerId = rs.getInt("TRAINER_ID");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BashStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trainerId;
    }

    public ArrayList dhmiourgiaArraylistTrainer(Statement stm) throws SQLException {
        //ftiaxnw to query mou
        String sqlTrainers = "SELECT * FROM TRAINERS;"; //8a emfanisei olous tous students
        ResultSet rs = stm.executeQuery(sqlTrainers); //emfanizoume ta apotelesmata ths bashs mas
        while (rs.next()) {
            Trainer t = new Trainer(rs.getInt("TRAINER_ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("SUBJECT"));
            trainers.add(t);
        }
        for (int i = 0; i < trainers.size(); i++) {
            if (newtrainers.contains(trainers.get(i))) {
            } else {
                newtrainers.add(trainers.get(i));
            }
        }
        return newtrainers;
    }

}
