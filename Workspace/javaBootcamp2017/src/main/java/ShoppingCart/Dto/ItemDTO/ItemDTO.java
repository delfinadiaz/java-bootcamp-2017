package ShoppingCart.Dto.ItemDTO;

import ShoppingCart.Model.Category;

public class ItemDTO {

	private String name;
	private double price;
	private Category category;
	private int stock;
	
	
	public ItemDTO(){
		
	}
	
	public ItemDTO(String name, double price, Category category, int stock) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.stock = stock;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
