package ShoppingCart.DaoImp;


import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ShoppingCart.Dao.ShoppingCartDao;
import ShoppingCart.HibernateUtil.HibernateUtil;
import ShoppingCart.Model.ShoppingCartStatus;
import ShoppingCart.Model.Entities.CartItem;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Payment;
import ShoppingCart.Model.Entities.ShoppingCartEntity;
import ShoppingCart.Model.Entities.User;

@Service
public class ShoppingCartDaoImp implements ShoppingCartDao{
	
	public ShoppingCartDaoImp(){
		
	}

	@Override
	@Transactional
	public boolean createShoppingCart(ShoppingCartEntity cart) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction=null;
		transaction = session.beginTransaction();
		try {
			session.save(cart);
			}
		catch(HibernateException e){
			return false;
		}
	    transaction.commit();
	    session.close();
		return true;	
	}


	@Override
	@Transactional
	public boolean updateShoppingCart(ShoppingCartEntity cart) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.update(cart);
		success= true;
	    transaction.commit();
	    session.close();
		return success;	
	}


	@Override
	public boolean removeItems(ShoppingCartEntity cart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ShoppingCartEntity getShoppingCart(int idShoppingCart) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ShoppingCartEntity shoppingCart = (ShoppingCartEntity) session.get(ShoppingCartEntity.class, new Integer(idShoppingCart));
        transaction.commit();
		session.close();
		return shoppingCart;
        
	}


	@Override
	public double getPartialPrice(int idShoppingCart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void buy(Payment aPaymentMethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeShoppingCart(ShoppingCartEntity cart) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.delete(cart);
		success= true;
	    transaction.commit();
	    session.close();
		return success;
		
	}

	@Override
	public CartItem getCartItem(ShoppingCartEntity cart, IndividualItem item) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CartItem> criteria = builder.createQuery(CartItem.class);
			Root<CartItem> cartItemRoot = criteria.from(CartItem.class);
			criteria.select(cartItemRoot);
			criteria.where(
					builder.equal(cartItemRoot.get("cart"),cart),
					builder.equal(cartItemRoot.get("item"),item)
					);
			CartItem cartItem = session.createQuery(criteria).getSingleResult();
			transaction.commit();
			session.close();
			return cartItem;
		}
		 catch (NoResultException nre) {
	         session.close();
	         return null;
	     }
	}

	@Override
	public boolean createCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.save(cartItem);
		success= true;
	    transaction.commit();
	    session.close();
		return success;	
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.update(cartItem);
		success= true;
	    transaction.commit();
	    session.close();
		return success;
	}

	@Override
	public boolean removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.delete(cartItem);
		success= true;
	    transaction.commit();
	    session.close();
		return success;	
	}

	@Override
	public List<ShoppingCartEntity> getShoppingCartsByStatus(ShoppingCartStatus status) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<ShoppingCartEntity> criteria = builder.createQuery(ShoppingCartEntity.class);
			Root<ShoppingCartEntity> cartRoot = criteria.from(ShoppingCartEntity.class);
			criteria.select(cartRoot);
			criteria.where(builder.equal(cartRoot.get("status"),status));
			List<ShoppingCartEntity> cart = session.createQuery(criteria).getResultList();
			transaction.commit();
			session.close();
			return cart;
		}
		 catch (NoResultException nre) {
	         session.close();
	         return null;
	     }
	}

	@Override
	public Payment getPayment(int idPayment) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Payment payment = (Payment) session.get(Payment.class, new Integer(idPayment));
        transaction.commit();
		session.close();
		return payment;
	}

	@Override
	public boolean createPayment(Payment aPayment) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.save(aPayment);
		success= true;
	    transaction.commit();
	    session.close();
		return success;
	}

	@Override
	public List<Payment> getPaymentsByType(int paymentType) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Payment> criteria = builder.createQuery(Payment.class);
			Root<Payment> paymentRoot = criteria.from(Payment.class);
			criteria.select(paymentRoot);
			criteria.where(builder.equal(paymentRoot.type(),paymentType));
			List<Payment> cart = session.createQuery(criteria).getResultList();
			transaction.commit();
			session.close();
			return cart;
		}
		 catch (NoResultException nre) {
	         session.close();
	         return null;
	     }
	}

	@Override
	public List<Payment> getPaymentsByUser(User anUser) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Payment> criteria = builder.createQuery(Payment.class);
			Root<Payment> paymentRoot = criteria.from(Payment.class);
			criteria.select(paymentRoot);
			criteria.where(builder.equal(paymentRoot.get("user"),anUser));
			List<Payment> cart = session.createQuery(criteria).getResultList();
			transaction.commit();
			session.close();
			return cart;
		}
		 catch (NoResultException nre) {
	         session.close();
	         return null;
	     }
	}


}
