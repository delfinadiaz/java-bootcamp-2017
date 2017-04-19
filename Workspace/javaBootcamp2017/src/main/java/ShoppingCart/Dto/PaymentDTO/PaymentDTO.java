package ShoppingCart.Dto.PaymentDTO;

public class PaymentDTO {
	private int paymentType;
	
	public PaymentDTO(){
		
	}
	
	public PaymentDTO(int idPayment){
		this.paymentType =idPayment;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int idPayment) {
		this.paymentType = idPayment;
	}
}
