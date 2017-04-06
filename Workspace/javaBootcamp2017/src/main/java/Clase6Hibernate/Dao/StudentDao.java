package Clase6Hibernate.Dao;

import java.util.Date;


public interface StudentDao {
	
	public void createStudent( String aFirstName, String aLastName, int aRegNumber,Date aDate);
	public void listStudents();
	public void updateFirstNameStudent(int idStudent,String aFirstName);
	public void deleteStudent(int idStudent);

}
