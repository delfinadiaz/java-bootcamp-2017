package Clase6Hibernate.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import Clase6Hibernate.Day;
import Clase6Hibernate.Dao.CourseDao;
import Clase6Hibernate.Dao.CourseDaoImp;
import Clase6Hibernate.Dao.ScheduleTimeDao;
import Clase6Hibernate.Dao.ScheduleTimeDaoImp;
import Clase6Hibernate.Dao.StudentCourseDao;
import Clase6Hibernate.Dao.StudentCourseDaoImp;
import Clase6Hibernate.Dao.StudentDao;
import Clase6Hibernate.Dao.StudentDaoImp;
import Clase6Hibernate.Dao.TeacherDao;
import Clase6Hibernate.Dao.TeacherDaoImp;
import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.ScheduleTime;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.StudentCourse;
import Clase6Hibernate.Entities.Teacher;
import Clase6Hibernate.util.HibernateUtil;

public class HighschoolServiceImp implements HighschoolService{
	
	StudentDao studentDao = new StudentDaoImp();
	CourseDao courseDao= new CourseDaoImp();
	TeacherDao teacherDao = new TeacherDaoImp();
	StudentCourseDao studentCourseDao= new StudentCourseDaoImp();
	ScheduleTimeDao scheduleDao = new ScheduleTimeDaoImp();
	

	public HighschoolServiceImp(){
		
	}
	@Override
	public int createStudent(String aFirstName, String aLastName, int aRegNumber, Date aDate) {
		// TODO Auto-generated method stub
		return studentDao.createStudent(aFirstName, aLastName, aRegNumber, aDate);
		
	}

	@Override
	public Student getStudent(int idStudent) {
		// TODO Auto-generated method stub
		return studentDao.getStudent(idStudent);
		
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
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(student);
	}

	@Override
	public int createCourse(String name, Teacher teacherAssigned, int hoursByWeek) {
		// TODO Auto-generated method stub
		return courseDao.createCourse(name, teacherAssigned, hoursByWeek);
		
	}

	@Override
	public Course getCourse(int idCourse) {
		// TODO Auto-generated method stub
		return courseDao.getCourse(idCourse);
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
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.deleteCourse(course);
	}
	
	@Override
	public int createTeacher(String firstName, String lastName, Date birthDate) {
		// TODO Auto-generated method stub
		return teacherDao.createTeacher(firstName, lastName, birthDate);
	}
	@Override
	public Teacher getTeacher(int idTeacher) {
		// TODO Auto-generated method stub
		return teacherDao.getTeacher(idTeacher);
	}
	@Override
	public void listTeachers() {
		// TODO Auto-generated method stub
		teacherDao.listTeachers();
	}
	@Override
	public void updateFirstNameTeacher(int idTeacher, String newName) {
		// TODO Auto-generated method stub
		teacherDao.updateFirstNameTeacher(idTeacher, newName);
	}
	@Override
	public void deleteTeacher(Teacher aTeacher) {
		// TODO Auto-generated method stub
		teacherDao.deleteTeacher(aTeacher);
		
	}
	
	@Override
	public int addStudentToACourse(Student student, Course aCourse) {
		// TODO Auto-generated method stub
		return studentCourseDao.addStudentToACourse(student, aCourse);
		
	}
	
	@Override
	public List<Student> getStudentsThatPassed(Course aCourse) {
		// TODO Auto-generated method stub
		return studentCourseDao.getStudentsThatPassed(aCourse);
	}
	@Override
	public List<Student> getStudentsThatFailed(Course aCourse) {
		// TODO Auto-generated method stub
		return studentCourseDao.getStudentsThatFailed(aCourse);
	}

	@Override
	public void insert1stPartialNote(StudentCourse studentCourse, int aNote) {
		// TODO Auto-generated method stub
		studentCourseDao.insert1stPartialNote(studentCourse, aNote);
		
	}
	@Override
	public void insert2ndPartialNote(StudentCourse studentCourse, int aNote) {
		// TODO Auto-generated method stub
		studentCourseDao.insert2ndPartialNote(studentCourse, aNote);
		
	}
	@Override
	public void insert3rdPartialNote(StudentCourse studentCourse, int aNote) {
		// TODO Auto-generated method stub
		studentCourseDao.insert3rdPartialNote(studentCourse, aNote);
		
	}
	@Override
	public void insertFinalNote(StudentCourse studentCourse, int aNote) {
		// TODO Auto-generated method stub
		studentCourseDao.insertFinalNote(studentCourse, aNote);
	}
	@Override
	public List<Student> getStudentsFromACourse(Course aCourse) {
		// TODO Auto-generated method stub
		return studentCourseDao.getStudentsFromACourse(aCourse);
	}
	@Override
	public List<Course> getCoursesFromAStudent(Student aStudent) {
		// TODO Auto-generated method stub
		return studentCourseDao.getCoursesFromAStudent(aStudent);
	}
	
	@Override
	public void deleteStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		studentCourseDao.deleteStudentCourse(studentCourse);
	}
	
	@Override
	public StudentCourse getStudentCourse(int idstudentCourse) {
		// TODO Auto-generated method stub
		return studentCourseDao.getStudentCourse(idstudentCourse);
	}
	
	@Override
	public int createScheduleTime(Day day, Time from_hour, Time to_hour, Course aCourse) {
		// TODO Auto-generated method stub
		return scheduleDao.createScheduleTime(day, from_hour, to_hour, aCourse);
	}
	@Override
	public ScheduleTime getScheduleTime(int idScheduleTime) {
		// TODO Auto-generated method stub
		return scheduleDao.getScheduleTime(idScheduleTime);
	}
	@Override
	public void listSchedulesTimesOfACourse(Course aCourse) {
		// TODO Auto-generated method stub
		scheduleDao.listSchedulesTimesOfACourse(aCourse);
	}
	@Override
	public void updateDayScheduleTime(int idScheduleTime, Day aDay) {
		// TODO Auto-generated method stub
		scheduleDao.updateDayScheduleTime(idScheduleTime, aDay);
		
	}
	@Override
	public void deleteScheduleTime(ScheduleTime scheduleTime) {
		// TODO Auto-generated method stub
		scheduleDao.deleteScheduleTime(scheduleTime);
		
	}
	
	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		HibernateUtil.shutdown();
	}
}
