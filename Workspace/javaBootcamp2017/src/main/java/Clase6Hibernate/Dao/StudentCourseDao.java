package Clase6Hibernate.Dao;

import java.util.List;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.StudentCourse;

public interface StudentCourseDao {

	public int addStudentToACourse(Student student, Course aCourse);
	public StudentCourse getStudentCourse(int idstudentCourse);
	public void insert1stPartialNote(StudentCourse studentCourse, int aNote);
	public void insert2ndPartialNote(StudentCourse studentCourse, int aNote);
	public void insert3rdPartialNote(StudentCourse studentCourse, int aNote);
	public void insertFinalNote(StudentCourse studentCourse, int aNote);
	public List<Student> getStudentsThatPassed(Course aCourse);
	public List<Student> getStudentsThatFailed(Course aCourse);
	public List<Student> getStudentsFromACourse(Course aCourse);
	public List<Course> getCoursesFromAStudent(Student aStudent);
	public void deleteStudentCourse(StudentCourse studentCourse);
}
