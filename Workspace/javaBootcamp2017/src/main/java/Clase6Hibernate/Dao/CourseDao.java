package Clase6Hibernate.Dao;

import Clase6Hibernate.Entities.Teacher;

public interface CourseDao {

	public void createCourse(String name, Teacher teacherAssigned, int hoursByWeek);
	public void getCourse();
	public void listCourses();
	public void updateCourseName(int idCourse, String newName);
	public void deleteCourse(int idCourse);
}
