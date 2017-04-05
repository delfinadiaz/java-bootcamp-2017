package Clase4Services.Model.PaymentModel;

import java.util.List;

import Clase4Services.Model.Payment;
import Clase4Services.Model.ItemOffer.IndividualItem;
import Clase4Services.Model.MarketModel.Market;
import Clase4Services.Model.MarketModel.User;


public class CreditCardPayment implements Payment {

	private static int paymentID;
	private String name;
	private int creditNumber; 
	private double amount;
	
	
	public CreditCardPayment(){
		paymentID = new Counter().generateUniqueID();
	}
	@Override
	public int getPaymentID() {
		// TODO Auto-generated method stub
		return paymentID;
	}
	
	@Override
	public boolean buy(User user, List<IndividualItem> cart, double partialPrice) {
		try { 
			setName(user.getName());
			setCreditNumber(user.getCreditNumber());
			applyDiscount(partialPrice);
			PaymentTransaction aPaymentTransaction= new PaymentTransaction(paymentID, amount,"Credit Card");
			savePaymentTransaction(aPaymentTransaction,user.getMarket());
			System.out.printf( "Transaction Number %d - Amount paid by Credit Card: $%f %n",paymentID,amount);
			return true;
		}
		catch (PaymentException e) {
            e.printStackTrace();
            return false;
        }
	}

	public void applyDiscount(double partialPrice) {
		double total = (partialPrice - (0.10 * partialPrice));
		setAmount(total);	
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCreditNumber() {
		return creditNumber;
	}
	public void setCreditNumber(int creditNumber) {
		this.creditNumber = creditNumber;
	}

	@Override
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public void savePaymentTransaction(PaymentTransaction paymentTransaction, Market market) {
		// TODO Auto-generated method stub
		market.addPaymentTransaction(paymentTransaction);
	}
	

}
