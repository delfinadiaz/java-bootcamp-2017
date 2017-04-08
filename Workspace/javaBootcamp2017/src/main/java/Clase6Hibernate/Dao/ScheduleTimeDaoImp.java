package Clase6Hibernate.Dao;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.Day;
import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.ScheduleTime;
import Clase6Hibernate.util.HibernateUtil;

public class ScheduleTimeDaoImp implements ScheduleTimeDao{

	@Override
	public int createScheduleTime(Day day, Time from_hour, Time to_hour, Course aCourse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    int idSchedule= 0;
        try {
            transaction = session.beginTransaction();
            ScheduleTime schedule = new ScheduleTime(day,from_hour, to_hour,aCourse);
            idSchedule= (int) session.save(schedule);
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idSchedule;
	}

	@Override
	public ScheduleTime getScheduleTime(int idScheduleTime) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        ScheduleTime schedule =null;
        try {
              
            transaction = session.beginTransaction();
			schedule = (ScheduleTime) session.get(ScheduleTime.class, new Integer(idScheduleTime));
			if (schedule == null) {
			    System.out.println("There is no ScheduleTime with id " + idScheduleTime);
			    return null;
			} 
			transaction.commit();
			return schedule;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return schedule;
	}

	@Override
	public void listSchedulesTimesOfACourse(Course aCourse) {
		// TODO Auto-generated method stub
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {
	              
	            transaction = session.beginTransaction();
				TypedQuery<ScheduleTime> query = session.createQuery(
						"FROM ScheduleTime where course = :course",ScheduleTime.class )
						.setParameter("course", aCourse);
	            List<ScheduleTime> result = query.getResultList();
	            Iterator<ScheduleTime> iterator = result.iterator();
	            while(iterator.hasNext()) {
	                ScheduleTime schedule = iterator.next();
	                System.out.println("Day " + schedule.getDay()+" From hour: "+schedule.getFromHour() +" To hour: "+ schedule.getToHour());
	            }
	            transaction.commit();
	        } catch (HibernateException e) {
	            transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	}

	@Override
	public void updateDayScheduleTime(int idScheduleTime, Day aDay) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            ScheduleTime schedule = (ScheduleTime) session.get(ScheduleTime.class, idScheduleTime);
            if (schedule == null) {
            	System.out.println("There is no ScheduleTime with id " + idScheduleTime);
            }
            else {
            	schedule.setDay(aDay);
	            System.out.println("ScheduleTime new day is " + schedule.getDay());
            }
	        transaction.commit();
	    } catch (HibernateException e) {
	        transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		
	}

	@Override
	public void deleteScheduleTime(ScheduleTime scheduleTime) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int idSchedule= scheduleTime.getIdScheduleTime();
        	session.delete(scheduleTime);
            transaction.commit();
            System.out.println("ScheduleTime with id " +idSchedule + " was deleted successfully");
		    
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

}
