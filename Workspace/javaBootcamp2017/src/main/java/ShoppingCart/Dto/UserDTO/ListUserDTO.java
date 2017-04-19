package ShoppingCart.Dto.UserDTO;

import java.util.List;

public class ListUserDTO {

	private int total;
	private List<UserDTO> users;
	
	
	public ListUserDTO(List<UserDTO> users) {
		this.total = users.size();
		this.users = users;
	}
	
	public ListUserDTO(){
		
	}
	
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
