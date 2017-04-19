package ShoppingCart.Dto.ItemDTO;

import ShoppingCart.Model.Category;

public class InfoItemDTO {
	private String name;
	private double price;
	private Category category;
	private int quantity;
	
	
	public InfoItemDTO(){
		
	}
	
	public InfoItemDTO(String name, double price, Category category, int quantity) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.setQuantity(quantity);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
