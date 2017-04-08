package Clase6Hibernate;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.ScheduleTime;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.StudentCourse;
import Clase6Hibernate.Entities.Teacher;
import Clase6Hibernate.Service.HighschoolServiceFactory;
import Clase6Hibernate.Service.HighschoolServiceImp;


public class MainClass {
	 
	
	public static void main(String[] args) throws ParseException {
	    HighschoolServiceImp highschool = HighschoolServiceFactory.getHighschoolService();
	    
		String inputString = "2017-04-02";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date inputDate = dateFormat.parse(inputString);
        String firstName="Kelsey";
        String lastName="Webster";
        int regNumber=11;
        int idnewstudent = highschool.createStudent(firstName, lastName, regNumber, inputDate);
       
        highschool.getStudent(idnewstudent);
        highschool.listStudents();
        highschool.updateFirstNameStudent(6, "Nathan");
        Student newStudent = highschool.getStudent(idnewstudent);
       
        
        
        int idTeacher = highschool.createTeacher("Tim", "Allen",inputDate);
        Teacher teacherAssigned = highschool.getTeacher(idTeacher);
        highschool.listTeachers();
        highschool.updateFirstNameTeacher(2, "Alfie");
        
        String name="Hibernate";
        int hoursByWeek = 4;
        int idnewcourse= highschool.createCourse(name, teacherAssigned, hoursByWeek);
        
        Course newCourse = highschool.getCourse(idnewcourse);
        highschool.listCourses();
        highschool.updateCourseName(2, "Rest");
        
        int idstudentCourse = highschool.addStudentToACourse(newStudent, newCourse);
        
        StudentCourse studentCourse = highschool.getStudentCourse(idstudentCourse);
        highschool.insert1stPartialNote(studentCourse, 9);
        highschool.insert2ndPartialNote(studentCourse, 7);
        highschool.insert3rdPartialNote(studentCourse, 8);
        highschool.insertFinalNote(studentCourse, 8);
        
        Course courseCompleted= highschool.getCourse(2);
        List<Student> studentPassed = highschool.getStudentsThatPassed(courseCompleted);
        Iterator<Student> iterator = studentPassed.iterator();
        while(iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println("Student " + student.getFirstName()+" " + student.getLastName());
        }
        
        List<Student> studentFailed = highschool.getStudentsThatFailed(courseCompleted);
        Iterator<Student> iteratorfail = studentFailed.iterator();
        while(iteratorfail.hasNext()) {
            Student studentf = iteratorfail.next();
            System.out.println("Student " + studentf.getFirstName()+" " + studentf.getLastName());
        }
        
       List<Student> allStudents= highschool.getStudentsFromACourse(courseCompleted);
       Iterator<Student> it = allStudents.iterator();
       while(it.hasNext()) {
           Student astudent = it.next();
           System.out.println("Student " + astudent.getFirstName()+" " + astudent.getLastName());
       }
       
       List<Course> allCourses= highschool.getCoursesFromAStudent(newStudent);
       Iterator<Course> itc = allCourses.iterator();
       while(itc.hasNext()) {
           Course acourse = itc.next();
           System.out.println("Course " + acourse.getName());
       }
       Day day= Day.Monday;
       Time fromhour = Time.valueOf("09:00:00");
       Time tohour =Time.valueOf("13:00:00");
       int idschedule = highschool.createScheduleTime(day, fromhour, tohour, newCourse);
       ScheduleTime schedule = highschool.getScheduleTime(idschedule);
       highschool.listSchedulesTimesOfACourse(courseCompleted);
       day = Day.Friday;
       highschool.updateDayScheduleTime(idschedule,day);
      
       highschool.deleteScheduleTime(schedule);
   	   highschool.deleteStudentCourse(studentCourse);
       highschool.deleteStudent(newStudent);
       highschool.deleteCourse(newCourse);
       highschool.deleteTeacher(teacherAssigned);
        
        
       highschool.shutdown();
  
	  }
	
}
