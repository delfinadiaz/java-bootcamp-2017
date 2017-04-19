package ShoppingCart.Dto.PaymentDTO;

import java.util.List;

public class ListStadisticPaymentDTO {
	private int amountPayments;
	private List<StadisticPaymentDTO> payments;
	
	public ListStadisticPaymentDTO(List<StadisticPaymentDTO> payments){
		this.amountPayments=payments.size();
		this.setPayments(payments);
	}
	
	public ListStadisticPaymentDTO(){
	}
	public int getAmountPayments() {
		return amountPayments;
	}
	public void setAmountPayments(int amountPayments) {
		this.amountPayments = amountPayments;
	}

	public List<StadisticPaymentDTO> getPayments() {
		return payments;
	}

	public void setPayments(List<StadisticPaymentDTO> payments) {
		this.payments = payments;
	}


}
