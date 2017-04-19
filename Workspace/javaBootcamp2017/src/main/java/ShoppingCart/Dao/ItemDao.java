package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.Model.Category;

public interface ItemDao {
	
	public boolean createItem(IndividualItem anItem);
	public IndividualItem getItem(int idItem);
	public List<IndividualItem> getItems();
	public List<IndividualItem> getItemsByCategory(Category category);
	public List<IndividualItem> getItemsByName(String aName);
	public List<IndividualItem> getItemsByCart(ShoppingCartEntity aCart);
	public int getOfferItemWithGivenPaymentType(int idItem, int paymentType);
	public boolean updateItem(IndividualItem anItem);
	public boolean removeItem(IndividualItem anItem);
}
