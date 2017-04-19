package ShoppingCart.Model;

@SuppressWarnings("serial")
public class PaymentException extends RuntimeException {
	
	public PaymentException(){
		super("Your Purchase Couldn't Be Completed, Please Try Again Later");
	}

}
