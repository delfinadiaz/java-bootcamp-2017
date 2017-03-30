package Clase4Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ShoppingCartImp implements ShoppingCartAPI {
	private List<Item> cart;
	
	protected ShoppingCartImp(){
		cart = new ArrayList<Item>();
	}

	@Override
	public void addItem(Item anItem) {
		// TODO Auto-generated method stub
		cart.add(anItem);
	}

	@Override
	public boolean removeItem(Item anItem) {
		// TODO Auto-generated method stub
		if (cart.contains(anItem)){
			cart.remove(anItem);
			return true;
		}
		System.out.println("The item to remove wasn't in the cart");
		return false;
		
	}

	@Override
	public List<Item> getItems() {
		// TODO Auto-generated method stub
		return cart;
	}

	@Override
	public int getTotalPrice(){
		// TODO Auto-generated method stub
		int sumPrice=0;
		Iterator<Item> it = getItems().listIterator();
		while (it.hasNext()) {
			Item item = it.next();
			sumPrice+=item.getPrice();
		}
		return sumPrice;
	}
	
	@Override
	public void buy() {
		// TODO Auto-generated method stub
		int amount = getTotalPrice();
		System.out.println("The amount to pay is " + amount);
		emptyCart();
		
	}

	@Override
	public void emptyCart() {
		cart.clear();
		
	}	
	

}
