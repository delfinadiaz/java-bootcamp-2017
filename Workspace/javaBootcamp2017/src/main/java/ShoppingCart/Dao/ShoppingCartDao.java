package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.Entities.User;
import ShoppingCart.Model.Payment;

public interface ShoppingCartDao {
	
   public void createShoppingCart(User anUser);
   public void addItem(int idShoppingCart, IndividualItem anItem);
   public void removeItem(int idShoppingCart, IndividualItem anItem);
   public ShoppingCartEntity getShoppingCart(int idShoppingCart);
   public List<IndividualItem> getItemsShoppingCart(int idShoppingCart);
   public double getPartialPrice(int idShoppingCart);
   public void buy(Payment aPaymentMethod);
   public void removeShoppingCart(int idShoppingCart);
   
}
