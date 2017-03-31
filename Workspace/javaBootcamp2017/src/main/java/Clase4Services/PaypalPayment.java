package Clase4Services;

import java.util.Iterator;
import java.util.List;

public class PaypalPayment implements Payment{
	
	private static int paymentID;
	private String email;
	private String password;
	private double amount;
	
	public PaypalPayment(){
		paymentID = new Counter().generateUniqueID();
	}
	
	@Override
	public int getPaymentID() {
		// TODO Auto-generated method stub
		return paymentID;
	}
	
	@Override
	public boolean buy(User user, List<Item> cart, double totalPrice) {
		// TODO Auto-generated method stub
		try {
			setEmail(user.getEmail());
			setPassword(user.getPassword());
			applyDiscount(totalPrice, cart);
			System.out.printf( "Transaction Number %d - Amount paid by Paypal: $%f %n",paymentID,amount);
			return true;
		}
		catch (PaymentException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public void applyDiscount(double totalPrice, List<Item> cart) {
		double total;
		double cheapestItemPrice;
		if (cart.size() > 1 ){
			cheapestItemPrice = getPriceCheapestItem(cart);
		}
		else {
			cheapestItemPrice = cart.get(0).getPrice();
		}
		total = (totalPrice - cheapestItemPrice);
		setAmount(total);	
	}

	protected double getPriceCheapestItem(List<Item> cart) {
		// TODO Auto-generated method stub
		double minPrice = cart.get(0).getPrice();
		Iterator<Item> it = cart.listIterator();
		while (it.hasNext()) {
			Item item = it.next();
		   if (item.getPrice() < minPrice){
			   minPrice = item.getPrice();
		   }
		}
		return minPrice;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
