package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Model.Category;
import ShoppingCart.Model.Item;

public interface ItemDao {
	
	public void createItem(String aName, double aPrice, Category aCategory, int aStock);
	public void changeItemName(int idItem,String aName);
	public void changeItemPrice(int idItem, double aPrice);
	public void changeItemCategory(int idItem, Category aCategory);
	public void changeStock(int idItem, int Stock);
    public Item getItem(int idItem);
    public List<Item> getItems();
    public void removeItem(int idItem);
}
