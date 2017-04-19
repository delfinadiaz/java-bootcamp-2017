package ShoppingCart.Dto.PaymentDTO;

import ShoppingCart.Dto.CartDTO.ShoppingCartDTO;

public class StadisticPaymentDTO {

	private int idPayment;
	private double amount;
	private ShoppingCartDTO cart;
	
	public StadisticPaymentDTO() {
		
	}
	
	public StadisticPaymentDTO(int idPayment,double amount, ShoppingCartDTO cart) {
		this.idPayment = idPayment;
		this.amount = amount;
		this.setCart(cart);
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ShoppingCartDTO getCart() {
		return cart;
	}

	public void setCart(ShoppingCartDTO cart) {
		this.cart = cart;
	}

	public int getIdPayment() {
		return idPayment;
	}

	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}

}
