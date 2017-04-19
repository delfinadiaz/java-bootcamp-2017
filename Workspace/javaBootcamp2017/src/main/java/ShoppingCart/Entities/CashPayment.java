package ShoppingCart.Entities;

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
@Table(name = "cash_payment")
@DiscriminatorValue("1")
public class CashPayment extends Payment implements Serializable{
	

	/*
	 * @Transient private static int paymentID;
	 * 
	 * public CashPayment(){ paymentID = new Counter().generateUniqueID(); }
	 */
    
	public CashPayment(){
    }
    
	/*
	 * @Override public int getPaymentID() { // TODO Auto-generated method stub
	 * return paymentID; }
	 */
    
	@Override
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

	private void applyDiscount(double partialPrice, List<IndividualItem> cart) {
		// TODO Auto-generated method stub
		double total;
		double mostExpensiveItemPrice;
		if (cart.size() > 1 ){
			mostExpensiveItemPrice = getPriceMostExpensiveItem(cart);
		}
		else {
			mostExpensiveItemPrice = cart.get(0).getPrice();
		}
		total = (partialPrice - (mostExpensiveItemPrice * 0.90));
		setAmount(total);	
	}

	private double getPriceMostExpensiveItem(List<IndividualItem> cart) {
		// TODO Auto-generated method stub
		double maxPrice = cart.get(0).getPrice();
		Iterator<IndividualItem> it = cart.listIterator();
		while (it.hasNext()) {
			IndividualItem item = it.next();
		   if (item.getPrice() > maxPrice){
			   maxPrice = item.getPrice();
		   }
		}
		return maxPrice;
	}


/*
	@Override
	public void savePaymentTransaction(PaymentTransaction paymentTransaction, Market market) {
		market.addPaymentTransaction(paymentTransaction);
		
	}*/


}
