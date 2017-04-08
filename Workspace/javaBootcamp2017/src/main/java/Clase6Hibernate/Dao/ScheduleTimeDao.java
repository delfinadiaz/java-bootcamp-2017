package Clase6Hibernate.Dao;

import java.sql.Time;

import Clase6Hibernate.Day;
import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.ScheduleTime;

public interface ScheduleTimeDao {
	
	public int createScheduleTime(Day day, Time from_hour, Time to_hour, Course aCourse);
	public ScheduleTime getScheduleTime(int idScheduleTime);
	public void listSchedulesTimesOfACourse(Course aCourse);
	public void updateDayScheduleTime(int idScheduleTime,Day aDay);
	public void deleteScheduleTime(ScheduleTime scheduleTime);

}
