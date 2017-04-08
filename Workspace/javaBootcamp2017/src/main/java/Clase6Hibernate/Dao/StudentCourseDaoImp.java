package Clase6Hibernate.Dao;


import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Clase6Hibernate.Entities.Course;
import Clase6Hibernate.Entities.Student;
import Clase6Hibernate.Entities.StudentCourse;
import Clase6Hibernate.util.HibernateUtil;

public class StudentCourseDaoImp implements StudentCourseDao{

	@Override
	public int addStudentToACourse(Student student, Course aCourse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    int idStudentCourse= 0;
        try {
            transaction = session.beginTransaction();
            StudentCourse studentCourse = new StudentCourse(student,aCourse);
            idStudentCourse= (int) session.save(studentCourse);
            transaction.commit();
        }catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idStudentCourse;
	  
	}
	
	@Override
	public StudentCourse getStudentCourse(int idstudentCourse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        StudentCourse studentCourse =null;
        try {
              
            transaction = session.beginTransaction();
			studentCourse = (StudentCourse) session.get(StudentCourse.class, new Integer(idstudentCourse));
			if (studentCourse == null) {
			    System.out.println("There is no StudentCourse with id " + idstudentCourse);
			    return null;
			} 
			transaction.commit();
			return studentCourse;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentCourse;
	}

	@Override
	public void insert1stPartialNote(StudentCourse studentCourse, int aNote) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
	        studentCourse.setFirstPartialNote(aNote);
	        transaction.commit();
	    } catch (HibernateException e) {
	        transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }	
	}

	@Override
	public void insert2ndPartialNote(StudentCourse studentCourse, int aNote) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
	        studentCourse.setSecondPartialNote(aNote);
	        transaction.commit();
	    } catch (HibernateException e) {
	        transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		
	}

	@Override
	public void insert3rdPartialNote(StudentCourse studentCourse, int aNote) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
	        studentCourse.setThirdPartialNote(aNote);
	        transaction.commit();
	    } catch (HibernateException e) {
	        transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		
	}

	@Override
	public void insertFinalNote(StudentCourse studentCourse, int aNote) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
	        studentCourse.setFinalNote(aNote);
	        transaction.commit();
	    } catch (HibernateException e) {
	        transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
		
	}

	@Override
	public List<Student> getStudentsThatPassed(Course aCourse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Student> list=null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Student> query = session.createQuery(
					        "select  s " +
							"from StudentCourse sc join sc.student s " +
							"join sc.course c " +
							"where sc.finalNote > 6 and c= :course",Student.class )
					        .setParameter("course", aCourse);
            list = query.getResultList();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}

	@Override
	public List<Student> getStudentsThatFailed(Course aCourse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Student> list=null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Student> query = session.createQuery(
					        "select  s " +
							"from StudentCourse sc join sc.student s " +
							"join sc.course c " +
							"where sc.finalNote < 6 and c= :course",Student.class )
					        .setParameter("course", aCourse);
            list = query.getResultList();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}

	@Override
	public List<Student> getStudentsFromACourse(Course aCourse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Student> list=null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Student> query = session.createQuery(
					        "select  s " +
							"from StudentCourse sc join sc.student s " +
							"join sc.course c " +
							"where c= :course",Student.class )
					        .setParameter("course", aCourse);
            list = query.getResultList();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}

	@Override
	public List<Course> getCoursesFromAStudent(Student aStudent) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Course> list=null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Course> query = session.createQuery(
					        "select  c " +
							"from StudentCourse sc join sc.student s " +
							"join sc.course c " +
							"where s= :student",Course.class )
					        .setParameter("student", aStudent);
            list = query.getResultList();
            transaction.commit();
            return list;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
	}

	@Override
	public void deleteStudentCourse(StudentCourse studentCourse) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            int idStudentCourse= studentCourse.getIdStudentCourse();
        	session.delete(studentCourse);
            transaction.commit();
            System.out.println("StudentCourse with id " +idStudentCourse + " was deleted successfully");
		    
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
		
	}
		
	

	
}
