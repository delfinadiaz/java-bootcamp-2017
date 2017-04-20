package ShoppingCart.DaoImp;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;


import ShoppingCart.Dao.UserDao;
import ShoppingCart.HibernateUtil.HibernateUtil;
import ShoppingCart.Model.PaymentTransaction;
import ShoppingCart.Model.Entities.User;

@Service
public class UserDaoImp implements UserDao {

	@Override
	public boolean createUser(User anUser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.save(anUser);
		success= true;
	    transaction.commit();
	    session.close();
		return success;	
		
	}



	@Override
	public User getUser(int idUser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user = (User) session.get(User.class, new Integer(idUser));
        transaction.commit();
        session.close();
		return user;
	}


	@Override
	public boolean removeUser(User anUser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.delete(anUser);
		success= true;
	    transaction.commit();
	    session.close();
		return success;	
	}

	@Override
	public User userExists(String anUsername) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		User user;
		 try {
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> userRoot = criteria.from(User.class);
			criteria.select(userRoot);
			criteria.where(builder.equal(userRoot.get("username"),anUsername));
			user = session.createQuery(criteria).getSingleResult();
			transaction.commit();
			return user;
		 }
		 catch (NoResultException nre) {
	         transaction.rollback();
	         return null;
	         
	     } finally {
	         session.close();
	     }
		}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> userRoot = criteria.from(User.class);
		criteria.select(userRoot);
        List<User> list = session.createQuery(criteria).getResultList();
        transaction.commit();
        session.close();
        return list;
	}


	@Override
	public boolean updateUser(User anUser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.update(anUser);
		success= true;
	    transaction.commit();
	    session.close();
		return success;	
	}


	@Override
	public User getUserByName(String aName) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		User user;
		 try {
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> criteria = builder.createQuery(User.class);
			Root<User> userRoot = criteria.from(User.class);
			criteria.select(userRoot);
			criteria.where(builder.equal(userRoot.get("name"),aName));
			user = session.createQuery(criteria).getSingleResult();
			transaction.commit();
			return user;
		 }
		 catch (NoResultException nre) {
	         transaction.rollback();
	         return null;
	         
	     } finally {
	         session.close();
	     }
	}

}
