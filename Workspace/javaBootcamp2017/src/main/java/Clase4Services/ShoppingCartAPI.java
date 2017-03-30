package Clase4Services;

import java.util.List;

public interface ShoppingCartAPI {
	
	public void addItem(Item anItem);
	public boolean removeItem(Item anItem);
	public int getTotalPrice();
	public List<Item> getItems();
	public void buy();
	public void emptyCart();
}
