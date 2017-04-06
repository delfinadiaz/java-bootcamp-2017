package Clase6Hibernate.Dao;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.util.HibernateUtil;

public class StudentDaoImp implements StudentDao {

	public void createStudent( String aFirstName, String aLastName, int aRegNumber,Date aDate) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
        try {
              
            transaction = session.beginTransaction();
            Student student = new Student(aFirstName,aLastName,aRegNumber,aDate);
            session.save(student);
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

	    HibernateUtil.shutdown();
	  }
	
	public void listStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Student> query = session.createQuery("FROM Student",Student.class);
            List<Student> result = query.getResultList();
            Iterator<Student> iterator = result.iterator();
            while(iterator.hasNext()) {
                Student student = iterator.next();
                System.out.println("Name " + student.getFirstName());
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        HibernateUtil.shutdown();
    }


	@Override
	public void updateFirstNameStudent(int idStudent, String aFirstName) {
	
    }

	@Override
	public void deleteStudent(int idStudent) {
		// TODO Auto-generated method stub
		
	}
}
