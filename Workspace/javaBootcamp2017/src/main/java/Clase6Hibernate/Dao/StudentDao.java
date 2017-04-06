package Clase6Hibernate.Dao;

import java.util.Date;


public interface StudentDao {
	
	public int createStudent( String aFirstName, String aLastName, int aRegNumber,Date aDate);
	public int getIdStudent(String firstName, String lastName,Date birthDate);
	public void listStudents();
	public void updateFirstNameStudent(int idStudent,String aFirstName);
	public void deleteStudent(int idStudent);

}
