package Clase6Hibernate.Service;

import java.util.Date;

import Clase6Hibernate.Entities.Teacher;

public interface HighschoolService {

	public int createStudent(String aFirstName, String aLastName, int aRegNumber,Date aDate);
	public int getIdStudent(String firstName, String lastName,Date birthDate);
	public void getStudent(int idStudent);
	public void listStudents();
	public void updateFirstNameStudent(int idStudent, String aFirstName);
	public void deleteStudent(int idStudent);
	
	public void createCourse(String name, Teacher teacherAssigned, int hoursByWeek);
	public void getCourse();
	public void listCourses();
	public void updateCourseName(int idCourse, String newName);
	public void deleteCourse(int idCourse);
	
	public void shutdown();
	
}
