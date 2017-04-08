package Clase6Hibernate.Dao;

import java.util.Date;

import Clase6Hibernate.Entities.Student;


public interface StudentDao {
	
	public int createStudent( String aFirstName, String aLastName, int aRegNumber,Date aDate);
	public Student getStudent(int idStudent);
	public void listStudents();
	public void updateFirstNameStudent(int idStudent,String aFirstName);
	public void deleteStudent(Student student);

}
