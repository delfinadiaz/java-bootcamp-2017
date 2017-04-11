package ShoppingCart.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcart_item")
	private int idCartItem;
	
	@ManyToOne()
    @JoinColumn(name = "idShoppingCart",nullable=false) 
	private ShoppingCartEntity cart;
	
	@ManyToOne()
    @JoinColumn(name = "idItem",nullable=false) 
	private IndividualItem item;
	
	private int quantity;
	
	public CartItem(){
		
	}
	
	public int getIdCartItem() {
		return idCartItem;
	}
	public void setIdCartItem(int idCartItem) {
		this.idCartItem = idCartItem;
	}
	public ShoppingCartEntity getCart() {
		return cart;
	}
	public void setCart(ShoppingCartEntity cart) {
		this.cart = cart;
	}
	public IndividualItem getItem() {
		return item;
	}
	public void setItem(IndividualItem item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
