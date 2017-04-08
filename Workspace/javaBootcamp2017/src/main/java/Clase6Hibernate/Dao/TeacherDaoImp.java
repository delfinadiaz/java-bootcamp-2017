package Clase6Hibernate.Dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.Entities.Teacher;
import Clase6Hibernate.util.HibernateUtil;

public class TeacherDaoImp implements TeacherDao {

	@Override
	public int createTeacher(String firstName, String lastName,Date birthDate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    int idTeacher= 0;
        try {
            transaction = session.beginTransaction();
            Teacher teacher = new Teacher(firstName,lastName,birthDate);
            idTeacher= (int) session.save(teacher);
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idTeacher;
	}

	@Override
	public Teacher getTeacher(int idTeacher) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Teacher teacher =null;
        try {
              
            transaction = session.beginTransaction();
			teacher = (Teacher) session.get(Teacher.class, new Integer(idTeacher));
			if (teacher == null) {
			    System.out.println("There is no teacher with id " + idTeacher);
			} else {
			    System.out.println("Teacher name: " + teacher.getFirstName()+ " " + teacher.getLastName());
			}
			transaction.commit();
			return teacher;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return teacher;
	}

	@Override
	public void listTeachers() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Teacher> query = session.createQuery("FROM Teacher",Teacher.class );
            List<Teacher> result = query.getResultList();
            Iterator<Teacher> iterator = result.iterator();
            while(iterator.hasNext()) {
                Teacher teacher = iterator.next();
                System.out.println("Name " + teacher.getFirstName());
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
	public void updateFirstNameTeacher(int idteacher, String newName) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Teacher teacher = (Teacher) session.get(Teacher.class, idteacher);
            if (teacher == null) {
            	System.out.println("There is no teacher with id " + idteacher);
            }
            else {
	            teacher.setFirstName(newName);
	            System.out.println("teacher new name is " + teacher.getFirstName());
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
	public void deleteTeacher(Teacher aTeacher) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int idteacher= aTeacher.getIdTeacher();
        	session.delete(aTeacher);
            transaction.commit();
            System.out.println("teacher with id " +idteacher + " was deleted successfully");
		    
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

}
