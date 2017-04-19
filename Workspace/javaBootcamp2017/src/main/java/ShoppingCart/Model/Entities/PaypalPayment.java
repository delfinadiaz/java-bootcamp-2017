package ShoppingCart.Model.Entities;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

//import ShoppingCart.Model.Counter;
import ShoppingCart.Model.PaymentException;
//import ShoppingCart.Model.MarketModel.Market;

@SuppressWarnings("serial")
@Entity
@Table(name = "paypal_payment")
@DiscriminatorValue("3")
public class PaypalPayment extends Payment implements Serializable{
	
	//@Transient
	//private static int paymentID;

	/*
	public PaypalPayment(){
		paymentID = new Counter().generateUniqueID();
	}*/
	
	public PaypalPayment(){
	}
	
/*	@Override
	public int getPaymentID() {
		// TODO Auto-generated method stub
		return paymentID;
	}*/
	

	public boolean buy(User user, List<IndividualItem> cart, double partialPrice) {
		// TODO Auto-generated method stub
		try {
			applyDiscount(partialPrice, cart);
			setUser(user);
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




	/*@Override
	public void savePaymentTransaction(PaymentTransaction paymentTransaction, Market market) {
		// TODO Auto-generated method stub
		market.addPaymentTransaction(paymentTransaction);
		
	}*/



}
