package ShoppingCart.Dto.ItemDTO;

import java.util.HashMap;
import java.util.List;

import ShoppingCart.Model.Category;

public class ListItemDTO {
	
	private int amountItems;
	private HashMap<Category,Integer> categories= new HashMap<Category,Integer>();
	private List<ItemDTO> items;
	
	public ListItemDTO(List<ItemDTO> items){
		this.amountItems=items.size();
		this.items=items;
		generateCategories();
	}
	
	public ListItemDTO(){
	}
	
	
	public void generateCategories() {
		// TODO Auto-generated method stub
		for (ItemDTO item : items){
			Category category = item.getCategory();
			if (categories.containsKey(category)){
				categories.put(category, categories.get(category)+1);
			}
			else {
				categories.put(category, 1);
			}
		}
		
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

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}


}
