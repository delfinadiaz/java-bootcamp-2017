package ShoppingCart.Dto.CartDTO;

import java.util.List;

public class ListShoppingCartsDTO {

	private String status;
	private int amountShoppingCarts;
	private List<ShoppingCartDTO> shoppingCarts;
	
	public ListShoppingCartsDTO() {
	}

	public ListShoppingCartsDTO(List<ShoppingCartDTO> shoppingCarts, String status) {
		this.amountShoppingCarts = shoppingCarts.size();
		this.shoppingCarts = shoppingCarts;
		this.status=status;
	}

	public int getAmountShoppingCarts() {
		return amountShoppingCarts;
	}

	public void setAmountShoppingCarts(int amountShoppingCarts) {
		this.amountShoppingCarts = amountShoppingCarts;
	}

	public List<ShoppingCartDTO> getShoppingCarts() {
		return shoppingCarts;
	}

	public void setShoppingCarts(List<ShoppingCartDTO> shoppingCarts) {
		this.shoppingCarts = shoppingCarts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
