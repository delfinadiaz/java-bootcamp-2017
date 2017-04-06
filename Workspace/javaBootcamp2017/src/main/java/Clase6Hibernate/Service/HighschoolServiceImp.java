package Clase6Hibernate.Service;

import java.util.Date;

import Clase6Hibernate.Dao.CourseDaoImp;
import Clase6Hibernate.Dao.StudentDaoImp;
import Clase6Hibernate.Entities.Teacher;
import Clase6Hibernate.util.HibernateUtil;

public class HighschoolServiceImp implements HighschoolService{
	
	StudentDaoImp studentDao = new StudentDaoImp();
	CourseDaoImp courseDao= new CourseDaoImp();

	public HighschoolServiceImp(){
		
	}
	@Override
	public int createStudent(String aFirstName, String aLastName, int aRegNumber, Date aDate) {
		// TODO Auto-generated method stub
		return studentDao.createStudent(aFirstName, aLastName, aRegNumber, aDate);
		
	}
	
	@Override
	public int getIdStudent(String firstName, String lastName, Date birthDate) {
		// TODO Auto-generated method stub
		return studentDao.getIdStudent(firstName,lastName,birthDate);
	}

	@Override
	public void getStudent(int idStudent) {
		// TODO Auto-generated method stub
		studentDao.getStudent(idStudent);
		
	}

	@Override
	public void listStudents() {
		// TODO Auto-generated method stub
		studentDao.listStudents();
		
	}

	@Override
	public void updateFirstNameStudent(int idStudent, String aFirstName) {
		// TODO Auto-generated method stub
		studentDao.updateFirstNameStudent(idStudent, aFirstName);
		
	}

	@Override
	public void deleteStudent(int idStudent) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(idStudent);
	}

	@Override
	public void createCourse(String name, Teacher teacherAssigned, int hoursByWeek) {
		// TODO Auto-generated method stub
		courseDao.createCourse(name, teacherAssigned, hoursByWeek);
		
	}

	@Override
	public void getCourse() {
		// TODO Auto-generated method stub
		courseDao.getCourse();
	}

	@Override
	public void listCourses() {
		// TODO Auto-generated method stub
		courseDao.listCourses();
	}

	@Override
	public void updateCourseName(int idCourse, String newName) {
		// TODO Auto-generated method stub
		courseDao.updateCourseName(idCourse, newName);
	}

	@Override
	public void deleteCourse(int idCourse) {
		// TODO Auto-generated method stub
		courseDao.deleteCourse(idCourse);
	}
	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		HibernateUtil.shutdown();
	}
	

}
