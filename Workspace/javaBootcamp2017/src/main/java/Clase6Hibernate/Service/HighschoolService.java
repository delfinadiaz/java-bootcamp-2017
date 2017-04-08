package Clase6Hibernate.Service;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import Clase6Hibernate.Day;
import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.ScheduleTime;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.StudentCourse;
import Clase6Hibernate.Entities.Teacher;

public interface HighschoolService {
	
    /**
     * This creates a Student with a specified first name, last name, 
     * registration number and date of birth.
     * @param aFirstName student's first name 
     * @param aLastName student's last name
     * @param aRegNumber the registration number of the student to create
     * @param aDate student's birth date 
     * @return the student created
     */
	public int createStudent(String aFirstName, String aLastName, int aRegNumber,Date aDate);
	
	/**
	 * This gets the Student with the specified id
	 * @param idStudent id of the student to get
	 * @return the student with the same id that was sent it in the parameter
	 */
	public Student getStudent(int idStudent);
	
	/**
	 * This shows all the students 
	 */
	public void listStudents();
	
	/**
	 * This updates the first name of a student 
	 * @param idStudent the id of the student
	 * @param aFirstName the new name of the student
	 */
	public void updateFirstNameStudent(int idStudent, String aFirstName);
	
	/**
	 * This deletes a student
	 * @param student the student to delete
	 */
	public void deleteStudent(Student student);
	
	/**
	 * This creates a teacher with a specified first name, last name and date of birth.
	 * @param firstName teacher's first name 
	 * @param lastName teacher's last name 
	 * @param birthDate teacher's date of birth 
	 * @return the teacher created
	 */
	public int createTeacher(String firstName,String lastName, Date birthDate );
	
	/**
	 * This gets a teacher 
	 * @param idTeacher id of the teacher to get
	 * @return the teacher with the same id that was sent it as a parameter
	 */
	public Teacher getTeacher(int idTeacher);
	
	/**
	 * This list all the teachers
	 */
	public void listTeachers();
	
	/**
	 * This updates the first name of a teacher 
	 * @param idTeacher the id of the teacher to update
	 * @param firstName the new first name of the teacher
	 */
	public void updateFirstNameTeacher(int idTeacher, String firstName);
	
	/**
	 * This deletes a teacher
	 * @param aTeacher the teacher to delete
	 */
	public void deleteTeacher(Teacher aTeacher);
	
	/**
	 * This creates a course with a specified name, teacher and hours by week
	 * @param name the name of the course
	 * @param teacherAssigned the teacher assigned to the course
	 * @param hoursByWeek the hours by week of the course
	 * @return the course created
	 */
	public int createCourse(String name, Teacher teacherAssigned, int hoursByWeek);
	
	/** 
	 * This gets a course
	 * @param idCourse id of the course to get
	 * @return the course with the same id that was sent it as a parameter
	 */
	public Course getCourse(int idCourse);
	
	/**
	 * This list all the courses
	 */
	public void listCourses();
	
	/**
	 * This updates the name of a course
	 * @param idCourse id of the course 
	 * @param newName new name of the course 
	 */
	public void updateCourseName(int idCourse, String newName);
	
	/**
	 * This deletes a course
	 * @param course course to delete
	 */
	public void deleteCourse(Course course);
	
	/**
	 * This adds a student to a course
	 * @param student student to add
	 * @param aCourse course where the student will be added
	 * @return the id of the StudentCourse created
	 */
	public int addStudentToACourse(Student student, Course aCourse);
	
	/**
	 * This gets a StudentCourse
	 * @param idstudentCourse id of the StudentCourse to get
	 * @return the StudentCourse with the same id that was sent it as a parameter
	 */
	public StudentCourse getStudentCourse(int idstudentCourse);
	
	/**
	 * This inserts the first partial note of a StudentCourse
	 * @param studentCourse the studentCourse where the partial note will be added
	 * @param aNote the note to add 
	 */
	public void insert1stPartialNote(StudentCourse studentCourse, int aNote);
	
	/**
	 * This inserts the second partial note of a StudentCourse
	 * @param studentCourse the studentCourse where the partial note will be added
	 * @param aNote the note to add 
	 */
	public void insert2ndPartialNote(StudentCourse studentCourse, int aNote);
	
	/**
	 * This inserts the third partial note of a StudentCourse
	 * @param studentCourse the studentCourse where the partial note will be added
	 * @param aNote the note to add 
	 */
	public void insert3rdPartialNote(StudentCourse studentCourse, int aNote);
	
	/**
	 * This inserts the final note of a StudentCourse
	 * @param studentCourse the studentCourse where the partial note will be added
	 * @param aNote the note to add 
	 */
	public void insertFinalNote(StudentCourse studentCourse, int aNote);
	
	/**
	 * This gets the students that passed a specified course
	 * @param aCourse a course
	 * @return list of students with final note higher than 6 in the course sent it as parameter
	 */
	public List<Student> getStudentsThatPassed(Course aCourse);
	
	/**
	 * This gets the students that failed a specified course
	 * @param aCourse a course
	 * @return list of students with final note lower than 6 in the course sent it as parameter
	 */
	public List<Student> getStudentsThatFailed(Course aCourse);
	
	/**
	 * This gets all the students of a specified course
	 * @param aCourse a course
	 * @return all the students that took the course sent it as parameter
	 */
	public List<Student> getStudentsFromACourse(Course aCourse);
	
	/**
	 * This gets all the courses that a specified student took
	 * @param aStudent a student
	 * @return all the courses that took the student sent it as parameter
	 */
	public List<Course> getCoursesFromAStudent(Student aStudent);
	
	/**
	 * This deletes the studentCourse that is send it as parameter
	 * @param studentCourse to delete
	 */
	public void deleteStudentCourse(StudentCourse studentCourse);
	
	/**
	 * This creates a ScheduleTime with a specified day, from hour, to hour and course
	 * @param day day of the course
	 * @param from_hour hour that the course starts
	 * @param to_hour hour that the course finishes
	 * @param aCourse a course
	 * @return the ScheduleTime created
	 */
	public int createScheduleTime(Day day, Time from_hour, Time to_hour, Course aCourse);
	
	/**
	 * This gets a Schedule Time with the specified id
	 * @param idScheduleTime id of the schedule time to get
	 * @return the schedule with the same id that the id sent as a parameter
	 */
	public ScheduleTime getScheduleTime(int idScheduleTime);
	
	/**
	 * This list all the schedules times of a specified course
	 * @param aCourse a course
	 */
	public void listSchedulesTimesOfACourse(Course aCourse);
	
	/**
	 * This updates the day of a specified ScheduleTime
	 * @param idScheduleTime id of the schedule time to update
	 * @param aDay new day of the schedule time
	 */
	public void updateDayScheduleTime(int idScheduleTime,Day aDay);
	
	/**
	 * This deletes a specified schedule time
	 * @param scheduleTime schedule time to delete
	 */
	public void deleteScheduleTime(ScheduleTime scheduleTime);
	
	/**
	 * This destroys the registry builder service
	 * this method must be called at last after all the operations are done
	 */
	public void shutdown();
	
}
