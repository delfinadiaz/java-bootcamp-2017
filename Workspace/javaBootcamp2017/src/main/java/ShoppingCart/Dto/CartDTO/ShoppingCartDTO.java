package ShoppingCart.Dto.CartDTO;

import java.util.List;

import ShoppingCart.Dto.ItemDTO.ItemCartDTO;


public class ShoppingCartDTO {
    private int idUser;
    private List<ItemCartDTO> items;
    
    public ShoppingCartDTO(int idUser,List<ItemCartDTO> items){
    	this.idUser =idUser;
    	this.items = items;
    }
    
    public ShoppingCartDTO(){
    	
    }
    
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public List<ItemCartDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemCartDTO> items) {
		this.items = items;
	}

	
}
