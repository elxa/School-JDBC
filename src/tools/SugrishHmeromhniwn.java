package tools;

public class SugrishHmeromhniwn {

    public static boolean sugkrishDates(String date1, String date2) {
        if (date1.compareTo(date2) > 0) {
            System.out.println("The start date " + date1 + " is after The end date " + date2);
            return true;
        } else if (date1.compareTo(date2) < 0) {
            // System.out.println("The start date " + date1 + " is before " + date2 + " The end date");
            return false;
        } else if (date1.compareTo(date2) == 0) {
            System.out.println(date1 + " is equal " + date2);
            return true;
        }
        return false;
    }
    
    public static boolean sugkrishDatesAssignmentCourse(String subdateAssignment, String dateCourse) {
        if (subdateAssignment.compareTo(dateCourse) > 0) {
            System.out.println("The subdateAssignment date " + subdateAssignment + " is after dateCourse " + dateCourse);  //to assignment einai meta apo thn startdate
            return true;
        }
        if (subdateAssignment.compareTo(dateCourse) < 0) {
           
             System.out.println("The subdateAssignment date " + subdateAssignment + " is before dateCourse " + dateCourse );//to assignment einai prin apo thn enddate
            return false;
        } else if (subdateAssignment.compareTo(dateCourse) == 0) {
            System.out.println(subdateAssignment + " is equal " + dateCourse);
            return true;
        }
        return false;
    }

}
