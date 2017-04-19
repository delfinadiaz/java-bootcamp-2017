package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Model.Category;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.ShoppingCartEntity;

public interface ItemDao {
	
	public boolean createItem(IndividualItem anItem);
	public IndividualItem getItem(int idItem);
	public List<IndividualItem> getItems();
	public List<IndividualItem> getItemsByCategory(Category category);
	public List<IndividualItem> getItemsByName(String aName);
	public List<IndividualItem> getItemsByCart(ShoppingCartEntity aCart);
	public boolean updateItem(IndividualItem anItem);
	public boolean removeItem(IndividualItem anItem);
	public int getOfferItemWithGivenPaymentType(int idItem, int paymentType);
}
