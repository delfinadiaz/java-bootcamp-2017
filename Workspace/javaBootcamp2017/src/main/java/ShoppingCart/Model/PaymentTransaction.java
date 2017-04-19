package ShoppingCart.Model;



public class PaymentTransaction{
  
	

	private int number;
	
	private double amount;

	

	
	public PaymentTransaction(){
		
	}
	public PaymentTransaction(int aNumber, double anAmount){
		this.number= aNumber;
		this.amount= anAmount;
		
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
