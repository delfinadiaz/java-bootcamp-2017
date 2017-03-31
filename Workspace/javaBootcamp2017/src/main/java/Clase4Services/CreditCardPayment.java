package Clase4Services;

import java.util.List;


public class CreditCardPayment implements Payment {

	private String name;
	private int creditNumber; 
	private double amount;
	
	@Override
	public boolean buy(User user, List<Item> cart, double totalPrice) {
		try { 
			setName(user.getName());
			setCreditNumber(user.getCreditNumber());
			applyDiscount(totalPrice);
			System.out.printf( "Amount paid by Credit Card: $%f %n",amount);
			return true;
		}
		catch (PaymentException e) {
            e.printStackTrace();
            return false;
        }
	}

	public void applyDiscount(double totalPrice) {
		double total = (totalPrice - (0.10 * totalPrice));
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

}
