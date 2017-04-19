package ShoppingCart.Dto.ItemDTO;

import java.util.Set;

public class ListIdItemDTO {
	private Set<IdItemDTO> items;

	public ListIdItemDTO(){
		
	}
	
	public ListIdItemDTO(Set<IdItemDTO> items){
		this.items=items;
	}

	public Set<IdItemDTO> getItems() {
		return items;
	}

	public void setItems(Set<IdItemDTO> items) {
		this.items = items;
	}
}
