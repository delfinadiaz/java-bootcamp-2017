package ShoppingCart.Dto.OfferDTO;

import java.util.List;

import ShoppingCart.Dto.ItemDTO.IdItemDTO;

public class OfferDTO {
	
	private String name;
	private int discount;
	private int paymentType;
	private List<IdItemDTO> items;
	
	public OfferDTO() {
	}
	
	public OfferDTO(String name, int discount,int idPayment, List<IdItemDTO> items) {
		this.name = name;
		this.discount = discount;
		this.setPaymentType(idPayment);
		this.items=items;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public List<IdItemDTO> getItems() {
		return items;
	}

	public void setItems(List<IdItemDTO> items) {
		this.items = items;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}


	
}
