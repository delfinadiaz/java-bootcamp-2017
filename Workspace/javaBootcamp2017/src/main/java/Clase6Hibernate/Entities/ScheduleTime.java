package Clase6Hibernate.Entities;

import java.sql.Time;

import Clase6Hibernate.Day;

public class ScheduleTime implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int idScheduleTime;
	private Day day ;
	private Time fromHour;
	private Time toHour;
	private Course course;
	
	public ScheduleTime(){
		
	}

	public ScheduleTime(Day day, Time fromHour, Time toHour, Course course) {
		this.day = day;
		this.fromHour = fromHour;
		this.toHour = toHour;
		this.course = course;
	}

	public int getIdScheduleTime() {
		return idScheduleTime;
	}

	public void setIdScheduleTime(int idScheduleTime) {
		this.idScheduleTime = idScheduleTime;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Time getFromHour() {
		return fromHour;
	}

	public void setFromHour(Time fromHour) {
		this.fromHour = fromHour;
	}

	public Time getToHour() {
		return toHour;
	}

	public void setToHour(Time toHour) {
		this.toHour = toHour;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
