package Clase6Hibernate.Entities;

import java.util.HashSet;
import java.util.Set;

public class Course implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int idCourse;
	private String name;
	private Teacher teacherAssigned;
	private int hoursByWeek;
	private Set<ScheduleTime> schedules= new HashSet<ScheduleTime>(0);
	private Set<StudentCourse> studentCourses = new HashSet<StudentCourse>(0);

	public Course(){
		
	}
	
	public Course(String name, Teacher teacherAssigned, int hoursByWeek) {
		this.name = name;
		this.teacherAssigned = teacherAssigned;
		this.hoursByWeek = hoursByWeek;
	}

	public int getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teacher getTeacherAssigned() {
		return teacherAssigned;
	}
	public void setTeacherAssigned(Teacher teacherAssigned) {
		this.teacherAssigned = teacherAssigned;
	}
	public int getHoursByWeek() {
		return hoursByWeek;
	}
	public void setHoursByWeek(int hoursByWeek) {
		this.hoursByWeek = hoursByWeek;
	}
	public Set<ScheduleTime> getSchedules() {
		return schedules;
	}
	public void setSchedules(Set<ScheduleTime> schedules) {
		this.schedules = schedules;
	}

	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

}
