package ShoppingCart.Model.Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

//import ShoppingCart.Model.Counter;
import ShoppingCart.Model.PaymentException;
//import ShoppingCart.Model.MarketModel.Market;

@SuppressWarnings("serial")
@Entity
@Table(name = "creditcard_payment")
@DiscriminatorValue("2")
public class CreditCardPayment extends Payment implements Serializable {

	//@Transient
	//private static int paymentID;
	@Transient
	private String name;
	@Transient
	private int creditNumber; 
	@Transient
	private double amount;
	
	
	public CreditCardPayment(){
	}
	/*
	public CreditCardPayment(){
		paymentID = new Counter().generateUniqueID();
	}*/
/*	@Override
	public int getPaymentID() {
		// TODO Auto-generated method stub
		return paymentID;
	}*/
	
	@Override
	public boolean buy(User user, List<IndividualItem> cart, double partialPrice) {
		try { 
			applyDiscount(partialPrice);
			setUser(user);
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


	/*@Override
	public void savePaymentTransaction(PaymentTransaction paymentTransaction, Market market) {
		// TODO Auto-generated method stub
		market.addPaymentTransaction(paymentTransaction);
		
	}*/
	
	

}
