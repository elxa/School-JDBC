package tools;

import dhmiourgiaBasewndedomenwn.BashCourse;
import dhmiourgiaBasewndedomenwn.BashStudentCourse;
import elegxoi.ElegxoiMetablhtwn;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import klaseis.Course;
import klaseis.Student;
import klaseis.StudentCourse;

public class Ypar3hStoixeiwnSthnLista {

    ElegxoiMetablhtwn em = new ElegxoiMetablhtwn();

    public int upar3hStoixeiwnSthnListaCourse(int id, ArrayList<Course> courses) {
        boolean existelement = false;
        do {
            id = em.ElegxosGiaIntMetablhth(id);
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getCourseId() == id) {
                    existelement = true;
                }
            }
        } while (existelement == false);
        return id;

    }

    public int upar3hStoixeiwnSthnListaStudent(int id, ArrayList<Student> students) {
        boolean existelement = false;
        do {
            id = em.ElegxosGiaIntMetablhth(id);
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentId() == id) {
                    existelement = true;
                }
            }
        } while (existelement == false);
        return id;
    }

  /*  public ArrayList upar3hStoixeiwnSthnListaStudentCourse(Statement stm, StudentCourse sc, ArrayList<StudentCourse> studentCourses, ArrayList<StudentCourse> newstudentCourses, ArrayList<Student> students, int epiloghStudent, ArrayList<Course> courses, int epiloghCourses) throws SQLException {
        boolean existelement = false;

        // do {
        // id = em.ElegxosGiaIntMetablhth(id);
        for (int i = 0; i < studentCourses.size(); i++) {
            if (newstudentCourses.get(i).getCourse().getCourseId() != sc.getCourse().getCourseId()
                    && studentCourses.get(i).getStudent().getStudentId() != sc.getStudent().getStudentId()) {

                newstudentCourses.add(sc);
                //gemizoume thn bash me ta dedomena
                int studentid = students.get(epiloghStudent - 1).getStudentId();
                int courseid = courses.get(epiloghCourses - 1).getCourseId();
                String sqlStudentCourse = "INSERT INTO STUDENTS_COURSES VALUES (" + studentid + "," + courseid + ")";
                stm.executeUpdate(sqlStudentCourse);
            } else {
                System.out.println("to stoixeio uparxei hdh");
            }
        }
        return studentCourses;
    } */ 

    public boolean upar3hStoixeiwnSthnListaStudentCourse(ArrayList<BashStudentCourse> studentAndCourses, StudentCourse studentAndCourse1) {
        int count = 0;
        for (int i = 0; i < studentAndCourses.size(); i++) {
            // if (trainerAndCourse.contains(trainerAndCourse1)) {
            /* if (studentAndCourses.get(i).getCourse().getTitle().equals(studentAndCourse1.getCourse().getTitle())
                    && studentAndCourses.get(i).getCourse().getStream().equals(studentAndCourse1.getCourse().getStream())
                    && studentAndCourses.get(i).getStudent().getFirstName().equals(studentAndCourse1.getStudent().getFirstName())
                    && studentAndCourses.get(i).getStudent().getLastName().equals(studentAndCourse1.getStudent().getLastName()))  */
            if ((studentAndCourses.get(i).getCourseId() == studentAndCourse1.getCourse().getCourseId())                   
                    && (studentAndCourses.get(i).getStudentId() == studentAndCourse1.getStudent().getStudentId()) ) {
                System.out.println("dddddddddddddd");
                count++;
                if (count == 1) {
                    System.out.println("O student exei hdh proste8ei se auto to ma8hma");
                    return true;
                }

            }
        }
        return false;

    }

}
