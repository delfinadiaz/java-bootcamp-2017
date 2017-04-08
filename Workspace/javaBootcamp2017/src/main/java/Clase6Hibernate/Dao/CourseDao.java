package Clase6Hibernate.Dao;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Teacher;

public interface CourseDao {

	public int createCourse(String name, Teacher teacherAssigned, int hoursByWeek);
	public Course getCourse(int idCourse);
	public void listCourses();
	public void updateCourseName(int idCourse, String newName);
	public void deleteCourse(Course course);
}
