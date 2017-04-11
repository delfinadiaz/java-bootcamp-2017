package ShoppingCart.ServiceImp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoppingCart.DaoImp.ShoppingCartDaoImp;
import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.Entities.User;
import ShoppingCart.Model.Payment;
import ShoppingCart.Service.ShoppingCartAPI;

@Service
public class ShoppingCartImp implements ShoppingCartAPI {
	
	
	private ShoppingCartDaoImp shoppingcartDao;
	
	@Autowired
	public ShoppingCartImp(ShoppingCartDaoImp shoppingcartDao){
		this.shoppingcartDao = shoppingcartDao;
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
		return shoppingcartDao.getShoppingCart(idShoppingCart);
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
