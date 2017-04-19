package ShoppingCart.Service;

import java.util.List;

import ShoppingCart.Entities.CartItem;
import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.Payment;
import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.Model.ShoppingCartStatus;

public interface ShoppingCartAPI {
	
	   public ShoppingCartEntity getShoppingCart(int idShoppingCart);
	   public boolean createShoppingCart(ShoppingCartEntity cart);
	   public boolean updateShoppingCart(ShoppingCartEntity cart);
	   public boolean removeItems(ShoppingCartEntity cart);
	   public double getPartialPrice(int idShoppingCart);
	   public void buy(Payment aPaymentMethod);
	   public List<ShoppingCartEntity> getShoppingCartsByStatus(ShoppingCartStatus status);
	   public boolean removeShoppingCart(ShoppingCartEntity cart);
	   public CartItem getCartItem(ShoppingCartEntity cart, IndividualItem item);
	   public boolean createCartItem(CartItem cartItem);
	   public boolean updateCartItem(CartItem cartItem);
	   public boolean removeCartItem(CartItem cartItem);
	   public Payment getPayment(int idPayment);
	   public boolean createPayment(Payment aPayment);
	   public List<Payment> getPaymentsByType(int paymentType);
}
