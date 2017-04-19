package ShoppingCart.Dto.ItemDTO;


public class ItemCartDTO {

	private int idItem;
	private int quantity;
	
	public ItemCartDTO(){
		
	}
	
	public ItemCartDTO(int idItem,int quantity) {
		this.setIdItem(idItem);
		this.setQuantity(quantity);
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}
}
