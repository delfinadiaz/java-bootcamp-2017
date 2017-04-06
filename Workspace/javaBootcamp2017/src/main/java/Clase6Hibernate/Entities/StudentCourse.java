package Clase6Hibernate.Entities;

public class StudentCourse implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int idStudentCourse;
	private Student student;
	private Course course;
	private int firstPartialNote;
	private int secondPartialNote;
	private int thirdPartialNote;
	private int finalNote;
	
	public StudentCourse(){
		
	}
	
	public StudentCourse(Student student, Course course) {
		this.student = student;
		this.course = course;
	}
	public int getIdStudentCourse() {
		return idStudentCourse;
	}
	public void setIdStudentCourse(int idStudentCourse) {
		this.idStudentCourse = idStudentCourse;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getFirstPartialNote() {
		return firstPartialNote;
	}
	public void setFirstPartialNote(int firstPartialNote) {
		this.firstPartialNote = firstPartialNote;
	}
	public int getSecondPartialNote() {
		return secondPartialNote;
	}
	public void setSecondPartialNote(int secondPartialNote) {
		this.secondPartialNote = secondPartialNote;
	}
	public int getThirdPartialNote() {
		return thirdPartialNote;
	}
	public void setThirdPartialNote(int thirdPartialNote) {
		this.thirdPartialNote = thirdPartialNote;
	}
	public int getFinalNote() {
		return finalNote;
	}
	public void setFinalNote(int finalNote) {
		this.finalNote = finalNote;
	}
	

}
