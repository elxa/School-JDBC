package klaseis;

import dhmiourgiaBasewndedomenwn.BashCourse;
import dhmiourgiaBasewndedomenwn.BashTrainer;
import elegxoi.ElegxoiMetablhtwn;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import tools.Ypar3hStoixeiwnSthnLista;

public class TrainerCourse {

    Trainer trainer = new Trainer();
    Course course = new Course();
    BashCourse bc = new BashCourse();
    BashTrainer bT = new BashTrainer();
    Scanner scan = new Scanner(System.in);
    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn();
    Ypar3hStoixeiwnSthnLista up = new Ypar3hStoixeiwnSthnLista();

    public TrainerCourse() {
    }

    public void antistoixiaTrainersMeCourses(Statement stm, ArrayList<Trainer> trainers, ArrayList<Course> courses) {
        String stop = " ";
        boolean existList = true;
        int courseId = 0;
        int trainerId = 0;
        if (courses.isEmpty()) {
            System.out.println("Den uparxoun courses");
            existList = false; //efoson den uparxei bgainoume e3w apo th me8odo
        }
        if (trainers.isEmpty()) {
            System.out.println("Den uparxoun trainers");
            existList = false;
        } else {
            while (!stop.equals("stop") && existList == true) {
                try {
                    System.out.println("******************Exoume ta e3hs Courses************************");
                    System.out.println("");
                    bc.emfanishCourses(stm);
                    System.out.println("");
                    System.out.println("*****************Exoume tous e3hs Trainers*************************");
                    System.out.println("");
                    bT.emfanishTrainers(stm);

                    System.out.println("Diale3e to Course ");
                    int epiloghCourses = 0;
                    epiloghCourses = em.ElegxosGiaIntMetablhth(epiloghCourses);

                    courseId = bc.courseId(stm, epiloghCourses);

                    System.out.println("Diale3e ton Trainer");
                    int epiloghTrainer = 0;
                    epiloghTrainer = em.ElegxosGiaIntMetablhth(epiloghTrainer);
                    trainerId = bT.trainerId(stm, epiloghTrainer);

                    String sqlStudentCourse = "INSERT INTO TRAINERS_COURSES VALUES (" + trainerId + "," + courseId + ")";
                    stm.executeUpdate(sqlStudentCourse);

                } catch (SQLException ex) {
                    System.out.println("1)XRHSIMOPOIHSES ARI8MO POU DEN UPARXEI h 2)YPARXEI HDH STH BASH H KATAXWRHSH POU KANEIS");
                }
                //   }
                System.out.println("ean 8es na stamathseis pata 'stop' alliws pata kapoion allon xarakthra");
                stop = scan.nextLine();
            }
        }
    }

}
