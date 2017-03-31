package Clase4Services;

import java.util.Iterator;
import java.util.List;

public class CashPayment implements Payment{

	private static int paymentID;
    private double amount;
    
    public CashPayment(){
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
			applyDiscount(totalPrice, cart);
			System.out.printf( "Transaction Number %d - Amount paid in cash: $%f %n",paymentID,amount);
			return true;
		}
		catch (PaymentException e) {
            e.printStackTrace();
            return false;
        }
	}

	private void applyDiscount(double totalPrice, List<Item> cart) {
		// TODO Auto-generated method stub
		double total;
		double mostExpensiveItemPrice;
		if (cart.size() > 1 ){
			mostExpensiveItemPrice = getPriceMostExpensiveItem(cart);
		}
		else {
			mostExpensiveItemPrice = cart.get(0).getPrice();
		}
		total = (totalPrice - (mostExpensiveItemPrice * 0.90));
		setAmount(total);	
	}

	private double getPriceMostExpensiveItem(List<Item> cart) {
		// TODO Auto-generated method stub
		double maxPrice = cart.get(0).getPrice();
		Iterator<Item> it = cart.listIterator();
		while (it.hasNext()) {
			Item item = it.next();
		   if (item.getPrice() > maxPrice){
			   maxPrice = item.getPrice();
		   }
		}
		return maxPrice;
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
