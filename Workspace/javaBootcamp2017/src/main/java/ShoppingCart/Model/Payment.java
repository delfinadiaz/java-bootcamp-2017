package ShoppingCart.Model;

import java.util.List;

import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.PaymentTransaction;
import ShoppingCart.Entities.User;
import ShoppingCart.Model.MarketModel.Market;

public interface Payment {

	//Generate a unique sequential id
	public int getPaymentID();
	
	//Saves the payment transaction to the market where the user bought the items
	public void savePaymentTransaction(PaymentTransaction paymentTransaction, Market market);
	
	/* Buy the items in the cart saving if necessary information of the user who is buying the items*/
	public boolean buy(User user, List<IndividualItem> cart, double totalPrice);
	
	//Gets the amount of the payment to do
	public double getAmount();
	
	//Sets the amount of the payment to do, this method should be called from the buy() method
	public void setAmount(double amount);
}
