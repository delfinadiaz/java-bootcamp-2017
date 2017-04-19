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

import ShoppingCart.Dao.OfferDao;
import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.Offer;
import ShoppingCart.Entities.Payment;
import ShoppingCart.HibernateUtil.HibernateUtil;

@Service
public class OfferDaoImp implements OfferDao {

	@Override
	public boolean createOffer(Offer anOffer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.clear();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.save(anOffer);
		for (IndividualItem item : anOffer.getItems()){
			item.addOffer(anOffer);
			session.update(item);
		}
		success= true;
	    transaction.commit();
	    session.close();
		return success;
	}

	@Override
	public Offer getOffer(int idOffer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Offer offer = (Offer) session.get(Offer.class, new Integer(idOffer));
        transaction.commit();
        session.close();
		return offer;
	}

	@Override
	public List<Offer> getOffers() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Offer> criteria = builder.createQuery(Offer.class);
		Root<Offer> offerRoot = criteria.from(Offer.class);
		criteria.select(offerRoot);
		List<Offer> offers = session.createQuery(criteria).getResultList();
        transaction.commit();
        session.close();
        return offers;
	}

	@Override
	public List<Offer> getOffersByPayment(int paymentType) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
		try {
			transaction=session.beginTransaction();
	        CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Offer> criteria = builder.createQuery(Offer.class);
			Root<Offer> offerRoot = criteria.from(Offer.class);
			criteria.select(offerRoot);
			criteria.where(builder.equal(offerRoot.get("paymentType"),paymentType));
			List<Offer> offers = session.createQuery(criteria).getResultList();
			transaction.commit();
			session.close();
			return offers;
		}
		 catch (NoResultException nre) {
	         session.close();
	         return null;
	     }
	}


	@Override
	public boolean updateOffer(Offer anOffer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.clear();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		session.merge(anOffer);
		success= true;
	    transaction.commit();
	    session.close();
		return success;	
	}

	@Override
	public boolean removeOffer(Offer anOffer) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.clear();
		Boolean success= false;
		Transaction transaction=null;
		transaction = session.beginTransaction();
		for (IndividualItem item : anOffer.getItems()){
			item.removeOffer(anOffer);
			session.update(item);
		}
		session.delete(anOffer);
		success= true;
	    transaction.commit();
	    session.close();
		return success;
	}

	@Override
	public Offer getOffersByItem(int idItem,Payment aPayment) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        Offer offer = null;
        try {
              
            transaction = session.beginTransaction();
			TypedQuery<Offer> query = session.createQuery(
					        "select  o " +
							"from Offer o join o.items i " +
							"where i.id= :item and o.payment = :payment",Offer.class )
					        .setParameter("item", idItem)
			 				.setParameter("payment",  aPayment);
            offer = query.getSingleResult();
            transaction.commit();
            return offer;
        } catch (NoResultException nre) {
            transaction.rollback();
           return null;
        } finally {
            session.close();
        }

	}


}
