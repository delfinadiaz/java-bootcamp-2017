package Clase4Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ShoppingCartImp implements ShoppingCartAPI {
	
	private User user;
	private List<Item> cart;
	
	protected ShoppingCartImp(){
		cart = new ArrayList<Item>();
	}
	

	@Override
	public void initialize(User anUser) {
		this.user = anUser;
		
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
	public double getTotalPrice(){
		// TODO Auto-generated method stub
		double sumPrice=0;
		Iterator<Item> it = getItems().listIterator();
		while (it.hasNext()) {
			Item item = it.next();
			sumPrice+=item.getPrice();
		}
		return sumPrice;
	}
	
	@Override
	public void buy(Payment aPaymentOption) {
		// TODO Auto-generated method stub
		double totalPrice = getTotalPrice();
		boolean purchaseMade = aPaymentOption.buy(user,cart,totalPrice);
		if (purchaseMade){
			emptyCart();
		}
		else {
			throw new PaymentException();
		}	
	}

	@Override
	public void emptyCart() {
		cart.clear();
	}	
	
	@Override
	public void showItem() {
		// TODO Auto-generated method stub
		Iterator<Item> it = cart.listIterator();
		String message;
		while (it.hasNext()) {
			Item item = it.next();
			StringBuilder sb = new StringBuilder("Item: ");
			sb.append(item.getName());
			sb.append(" .....$");
			sb.append(item.getPrice());
			message = sb.toString();
			System.out.println(message);
		}
		
	}
	

}
