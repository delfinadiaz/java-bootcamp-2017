package ShoppingCart.DaoImp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;


import ShoppingCart.Dao.ShoppingCartDao;
import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.Entities.User;
import ShoppingCart.HibernateUtil.HibernateUtil;
import ShoppingCart.Model.Payment;

@Service
public class ShoppingCartDaoImp implements ShoppingCartDao{
	
	public ShoppingCartDaoImp(){
		
	}

	@Override
	public void createShoppingCart(User anUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItem(int idShoppingCart, IndividualItem anItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(int idShoppingCart, IndividualItem anItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShoppingCartEntity getShoppingCart(int idShoppingCart) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        ShoppingCartEntity shoppingCart =null;
        transaction = session.beginTransaction();
        shoppingCart = (ShoppingCartEntity) session.get(ShoppingCartEntity.class, new Integer(idShoppingCart));
		if (shoppingCart == null) {
			    return null;
		} 
		transaction.commit();
		session.close();
        HibernateUtil.shutdown();
		return shoppingCart;
        
	}

	@Override
	public List<IndividualItem> getItemsShoppingCart(int idShoppingCart) {
		// TODO Auto-generated method stub
		return null;
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
	public void removeShoppingCart(int idShoppingCart) {
		// TODO Auto-generated method stub
		
	}

}
