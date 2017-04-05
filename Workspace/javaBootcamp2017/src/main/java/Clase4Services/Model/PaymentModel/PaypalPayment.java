package Clase4Services.Model.PaymentModel;

import java.util.Iterator;
import java.util.List;

import Clase4Services.Model.Payment;
import Clase4Services.Model.ItemOffer.IndividualItem;
import Clase4Services.Model.MarketModel.Market;
import Clase4Services.Model.MarketModel.User;

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
	public boolean buy(User user, List<IndividualItem> cart, double partialPrice) {
		// TODO Auto-generated method stub
		try {
			setEmail(user.getEmail());
			setPassword(user.getPassword());
			applyDiscount(partialPrice, cart);
			PaymentTransaction aPaymentTransaction= new PaymentTransaction(paymentID, amount,"Paypal");
			savePaymentTransaction(aPaymentTransaction,user.getMarket());
			System.out.printf( "Transaction Number %d - Amount paid by Paypal: $%f %n", paymentID,amount);
			return true;
		}
		catch (PaymentException e) {
            e.printStackTrace();
            return false;
        }
	}
	
	public void applyDiscount(double partialPrice, List<IndividualItem> cart) {
		double total;
		double cheapestItemPrice;
		if (cart.size() > 1 ){
			cheapestItemPrice = getPriceCheapestItem(cart);
		}
		else {
			cheapestItemPrice = cart.get(0).getPrice();
		}
		total = (partialPrice - cheapestItemPrice);
		setAmount(total);	
	}

	protected double getPriceCheapestItem(List<IndividualItem> cart) {
		// TODO Auto-generated method stub
		double minPrice = cart.get(0).getPrice();
		Iterator<IndividualItem> it = cart.listIterator();
		while (it.hasNext()) {
			IndividualItem item = it.next();
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

	@Override
	public void savePaymentTransaction(PaymentTransaction paymentTransaction, Market market) {
		// TODO Auto-generated method stub
		market.addPaymentTransaction(paymentTransaction);
		
	}


}
