package ShoppingCart.Dto.CartDTO;

import java.util.HashMap;
import java.util.List;

import ShoppingCart.Dto.ItemDTO.InfoItemDTO;
import ShoppingCart.Model.Category;

public class StadisticShoppingCartDTO {

	private String user;
	private String status;
	private int amountItems;
	private HashMap<Category,Integer> categories= new HashMap<Category,Integer>();
	private List<InfoItemDTO> items;
	
	public StadisticShoppingCartDTO(List<InfoItemDTO> items){
	    this.amountItems=items.size();
		this.items=items;
		generateCategories();
	}
	
	public void generateCategories() {
		// TODO Auto-generated method stub
		for (InfoItemDTO item : items){
			Category category = item.getCategory();
			if (categories.containsKey(category)){
				categories.put(category, categories.get(category)+1);
			}
			else {
				categories.put(category, 1);
			}
		}
		
	}

	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getAmountItems() {
		return amountItems;
	}
	public void setAmountItems(int amountItems) {
		this.amountItems = amountItems;
	}
	

	public HashMap<Category,Integer> getCategories() {
		return categories;
	}

	public void setCategories(HashMap<Category,Integer> categories) {
		this.categories = categories;
	}

	public List<InfoItemDTO> getItems() {
		return items;
	}

	public void setItems(List<InfoItemDTO> items) {
		this.items = items;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	
}
