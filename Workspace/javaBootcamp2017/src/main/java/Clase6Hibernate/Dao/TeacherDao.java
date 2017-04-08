package Clase6Hibernate.Dao;

import java.util.Date;

import Clase6Hibernate.Entities.Teacher;

public interface TeacherDao {
	
	public int createTeacher(String firstName,String lastName, Date birthDate );
	public Teacher getTeacher(int idTeacher);
	public void listTeachers();
	public void updateFirstNameTeacher(int idTeacher, String newName);
	public void deleteTeacher(Teacher aTeacher);

}
