package Clase6Hibernate.Entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idTeacher;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private Set<Course> courses= new HashSet<Course>(0);
	
	public Teacher(){
		
	}
	public Teacher(String firstName, String lastName,Date birthDate){
		this.firstName= firstName;
		this.lastName =lastName;
		this.birthDate =birthDate;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
