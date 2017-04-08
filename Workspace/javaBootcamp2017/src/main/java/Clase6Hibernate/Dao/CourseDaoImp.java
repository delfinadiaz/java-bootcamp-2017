package Clase6Hibernate.Dao;



import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Teacher;
import Clase6Hibernate.util.HibernateUtil;

public class CourseDaoImp implements CourseDao {
	
	public CourseDaoImp(){
			
	}

	@Override
	public int createCourse(String name, Teacher teacherAssigned, int hoursByWeek) {
		// TODO Auto-generated method stub
		   Session session = HibernateUtil.getSessionFactory().openSession();
		    Transaction transaction = null;
		    int idCourse= 0;
	        try {
	            transaction = session.beginTransaction();
	            Course course = new Course(name,teacherAssigned, hoursByWeek);
	            idCourse= (int) session.save(course);
	            transaction.commit();
	        }catch (HibernateException e) {
	            transaction.rollback();
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return idCourse;
	}

	@Override
	public Course getCourse(int idCourse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Course course =null;
        try {
              
            transaction = session.beginTransaction();
			course = (Course) session.get(Course.class, new Integer(idCourse));
			if (course == null) {
			    System.out.println("There is no Course with id " + idCourse);
			    return null;
			} else {
			    System.out.println("Course name: " + course.getName());
			}
			transaction.commit();
			return course;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return course;
	}

	@Override
	public void listCourses() {
		// TODO Auto-generated method stub
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction transaction = null;
	        try {
	              
	            transaction = session.beginTransaction();
				TypedQuery<Course> query = session.createQuery("FROM Course",Course.class );
	            List<Course> result = query.getResultList();
	            Iterator<Course> iterator = result.iterator();
	            while(iterator.hasNext()) {
	                Course course = iterator.next();
	                System.out.println("Name " + course.getName());
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
	public void updateCourseName(int idCourse, String newName) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Course course = (Course) session.get(Course.class, idCourse);
            if (course == null) {
            	System.out.println("There is no course with id " + idCourse);
            }
            else {
	            course.setName(newName);
	            System.out.println("Course new name is " + course.getName());
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
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int idCourse= course.getIdCourse();
        	session.delete(course);
            transaction.commit();
            System.out.println("Course with id " +idCourse + " was deleted successfully");
		    
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

}
