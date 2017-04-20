package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Model.ShoppingCartStatus;
import ShoppingCart.Model.Entities.CartItem;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Payment;
import ShoppingCart.Model.Entities.ShoppingCartEntity;
import ShoppingCart.Model.Entities.User;

public interface ShoppingCartDao {
	
   public ShoppingCartEntity getShoppingCart(int idShoppingCart);
   public boolean createShoppingCart(ShoppingCartEntity cart);
   public boolean updateShoppingCart(ShoppingCartEntity cart);
   public List<ShoppingCartEntity> getShoppingCartsByStatus(ShoppingCartStatus status);
   public CartItem getCartItem(ShoppingCartEntity cart, IndividualItem item);
   public boolean removeShoppingCart(ShoppingCartEntity cart);
   public boolean createCartItem(CartItem cartItem);
   public boolean updateCartItem(CartItem cartItem);
   public boolean removeCartItem(CartItem cartItem);
   public Payment getPayment(int idPayment);
   public boolean createPayment(Payment aPayment);
   public List<Payment> getPaymentsByType(int paymentType);
   public List<Payment> getPaymentsByUser(User anUser);
   
}
