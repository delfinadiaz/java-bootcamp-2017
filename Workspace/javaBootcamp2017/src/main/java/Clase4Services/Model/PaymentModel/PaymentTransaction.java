package Clase4Services.Model.PaymentModel;

public class PaymentTransaction {

	private int number;
	private double amount;
	private String paymentMethod;
	
	public PaymentTransaction(int aNumber, double anAmount, String aPaymentMethod){
		this.number= aNumber;
		this.amount= anAmount;
		this.paymentMethod=aPaymentMethod;
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String description) {
		this.paymentMethod = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
