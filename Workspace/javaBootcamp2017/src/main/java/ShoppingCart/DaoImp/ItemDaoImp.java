package ShoppingCart.DaoImp;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import ShoppingCart.Dao.ItemDao;
import ShoppingCart.HibernateUtil.HibernateUtil;
import ShoppingCart.Model.Category;
import ShoppingCart.Model.Entities.CartItem;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Offer;
import ShoppingCart.Model.Entities.ShoppingCartEntity;

@Service
public class ItemDaoImp implements ItemDao {

	@Override
	public boolean createItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.save(anItem);
		success= true;
	    transaction.commit();
	    session.close();
		return success;
	}

	@Override
	public IndividualItem getItem(int idItem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        IndividualItem item = (IndividualItem) session.get(IndividualItem.class, new Integer(idItem));
        transaction.commit();
        session.close();
		return item;
	}

	@Override
	public List<IndividualItem> getItems() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<IndividualItem> criteria = builder.createQuery(IndividualItem.class);
		Root<IndividualItem> itemRoot = criteria.from(IndividualItem.class);
		criteria.select(itemRoot);
		List<IndividualItem> items = session.createQuery(criteria).getResultList();
        transaction.commit();
        session.close();
        return items;
	}

	@Override
	public List<IndividualItem> getItemsByCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<IndividualItem> criteria = builder.createQuery(IndividualItem.class);
		Root<IndividualItem> itemRoot = criteria.from(IndividualItem.class);
		criteria.select(itemRoot);
		criteria.where(builder.equal(itemRoot.get("category"),category));
		List<IndividualItem> items = session.createQuery(criteria).getResultList();
        transaction.commit();
        session.close();
        return items;
	}

	@Override
	public List<IndividualItem> getItemsByName(String aName) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<IndividualItem> criteria = builder.createQuery(IndividualItem.class);
		Root<IndividualItem> itemRoot = criteria.from(IndividualItem.class);
		criteria.select(itemRoot);
		criteria.where(builder.equal(itemRoot.get("name"),aName));
		List<IndividualItem> items = session.createQuery(criteria).getResultList();
        transaction.commit();
        session.close();
        return items;
	}

	
	@Override
	public List<IndividualItem> getItemsByCart(ShoppingCartEntity aCart) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<IndividualItem> criteria = builder.createQuery(IndividualItem.class);
		Root<IndividualItem> itemRoot = criteria.from(IndividualItem.class);
		Join<IndividualItem,CartItem> cartItem = itemRoot.join( "cartItem" );
		criteria.select(itemRoot);
		criteria.where(builder.equal(cartItem.get("cart"),aCart));
		List<IndividualItem> items = session.createQuery(criteria).getResultList();
        transaction.commit();
        session.close();
        return items;
	}
	@Override
	public boolean updateItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.update(anItem);
		success= true;
	    transaction.commit();
	    session.close();
		return success;	
	}

	@Override
	public boolean removeItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.delete(anItem);
		success= true;
	    transaction.commit();
	    session.close();
		return success;
	}

	@Override
	public int getOfferItemWithGivenPaymentType(int idItem, int paymentType) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Offer offer = null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Offer> query = session.createQuery(
					        "select  o " +
							"from Offer o join o.items i "+
							"where i.id= :item and o.paymentType = :paymentType",Offer.class )
					        .setParameter("item", idItem)
			 				.setParameter("paymentType", paymentType);
            offer = query.getSingleResult();
            transaction.commit();
            return offer.getDiscount();
        } catch (NoResultException nre) {
            transaction.rollback();
           return 0;
        } finally {
            session.close();
        }
	}





	

}
