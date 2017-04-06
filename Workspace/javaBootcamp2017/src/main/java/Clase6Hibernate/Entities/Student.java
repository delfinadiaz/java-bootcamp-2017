package Clase6Hibernate.Entities;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idStudent;
	private String firstName;
	private String lastName;
	private int registrationNumber;
	private Date birthDate;
	private Set<StudentCourse> studentCourses = new HashSet<StudentCourse>(0);
	
	public Student(){
		
	}
	
	public Student(String firstName, String lastName, int registrationNumber, Date birthDate){
		this.firstName = firstName;
		this.lastName = lastName;
		this.registrationNumber = registrationNumber;
		this.birthDate = birthDate;
	}
	
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
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
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}



}
