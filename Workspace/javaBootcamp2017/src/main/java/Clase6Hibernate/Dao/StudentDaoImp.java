package Clase6Hibernate.Dao;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.StudentCourse;
import Clase6Hibernate.util.HibernateUtil;

public class StudentDaoImp implements StudentDao {
	
	public StudentDaoImp(){
	}

	public int createStudent( String aFirstName, String aLastName, int aRegNumber,Date aDate) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    int idStudent= 0;
        try {
            transaction = session.beginTransaction();
            Student student = new Student(aFirstName,aLastName,aRegNumber,aDate);
            idStudent= (int) session.save(student);
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idStudent;
	  }
	
	public Student getStudent(int idStudent){
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Student student =null;
        try {
              
            transaction = session.beginTransaction();
			student = (Student) session.get(Student.class, new Integer(idStudent));
			if (student == null) {
			    System.out.println("There is no Student with id " + idStudent);
			    return null;
			} else {
			    System.out.println("Student name: " + student.getFirstName()+ " " + student.getLastName());
			}
			transaction.commit();
			return student;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }
	
	
	public void listStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Student> query = session.createQuery("FROM Student",Student.class );
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
    }


	@Override
	public void updateFirstNameStudent(int idStudent, String aFirstName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Student student = (Student) session.get(Student.class, idStudent);
            if (student == null) {
            	System.out.println("There is no Student with id " + idStudent);
            }
            else {
	            student.setFirstName(aFirstName);
	            System.out.println("Student new name is " + student.getFirstName());
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
	public void deleteStudent(Student student) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int idStudent = student.getIdStudent();
            TypedQuery<StudentCourse> query = session.createQuery("FROM StudentCourse WHERE student = :student",StudentCourse.class );
            query.setParameter("student", student);
            List<StudentCourse> result = query.getResultList();
            if (!(result.isEmpty())){
            	String hqlStudentCourse = "DELETE FROM StudentCourse WHERE student = :student";
            	session.createQuery(hqlStudentCourse).setParameter("student", student).executeUpdate();
            }
        	String hqlStudent ="DELETE FROM Student WHERE idStudent = :idstudent";
        	session.createQuery(hqlStudent).setParameter("idstudent", idStudent).executeUpdate();
        	transaction.commit();
            System.out.println("Student with id " +idStudent + " was deleted successfully");
		    
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}

}
