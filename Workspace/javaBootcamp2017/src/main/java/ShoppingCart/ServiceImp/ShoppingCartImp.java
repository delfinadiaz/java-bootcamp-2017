package ShoppingCart.ServiceImp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoppingCart.DaoImp.ShoppingCartDaoImp;
import ShoppingCart.Model.ShoppingCartStatus;
import ShoppingCart.Model.Entities.CartItem;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Payment;
import ShoppingCart.Model.Entities.ShoppingCartEntity;
import ShoppingCart.Model.Entities.User;
import ShoppingCart.Service.ShoppingCartAPI;

@Service
public class ShoppingCartImp implements ShoppingCartAPI {
	
	
	private ShoppingCartDaoImp shoppingcartDao;
	
	@Autowired
	public ShoppingCartImp(ShoppingCartDaoImp shoppingcartDao){
		this.shoppingcartDao = shoppingcartDao;
	}

	@Override
	public boolean createShoppingCart(ShoppingCartEntity cart) {
		// TODO Auto-generated method stub
		return shoppingcartDao.createShoppingCart(cart);
	}

	@Override
	public boolean updateShoppingCart(ShoppingCartEntity cart) {
		// TODO Auto-generated method stub
		return shoppingcartDao.updateShoppingCart(cart);
	}
	

	@Override
	public boolean removeItems(ShoppingCartEntity cart) {
		// TODO Auto-generated method stub
		return shoppingcartDao.removeItems(cart);
	}

	@Override
	public ShoppingCartEntity getShoppingCart(int idShoppingCart) {
		// TODO Auto-generated method stub
		return shoppingcartDao.getShoppingCart(idShoppingCart);
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
		return shoppingcartDao.removeShoppingCart(cart);
	}

	@Override
	public CartItem getCartItem(ShoppingCartEntity cart, IndividualItem item) {
		// TODO Auto-generated method stub
		return shoppingcartDao.getCartItem(cart, item);
	}

	@Override
	public boolean createCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return shoppingcartDao.createCartItem(cartItem);
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return shoppingcartDao.updateCartItem(cartItem);
	}

	@Override
	public boolean removeCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return shoppingcartDao.removeCartItem(cartItem);
	}

	@Override
	public List<ShoppingCartEntity> getShoppingCartsByStatus(ShoppingCartStatus status) {
		// TODO Auto-generated method stub
		return shoppingcartDao.getShoppingCartsByStatus(status);
	}

	@Override
	public Payment getPayment(int idPayment) {
		// TODO Auto-generated method stub
		return shoppingcartDao.getPayment(idPayment);
	}

	@Override
	public boolean createPayment(Payment aPayment) {
		// TODO Auto-generated method stub
		return shoppingcartDao.createPayment(aPayment);
	}

	@Override
	public List<Payment> getPaymentsByType(int paymentType) {
		// TODO Auto-generated method stub
		return shoppingcartDao.getPaymentsByType(paymentType);
	}

	@Override
	public List<Payment> getPaymentsByUser(User anUser) {
		// TODO Auto-generated method stub
		return shoppingcartDao.getPaymentsByUser(anUser);
	}

	
	
	

}
