package ShoppingCart.Entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ShoppingCart.Model.Item;

@Entity
@Table(name = "item")
public class IndividualItem implements Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iditem")
	private int idItem;
	
	private String name;
	private double price;
	
	
	@OneToMany(mappedBy = "item")
	private Set<CartItem> cartItem= new HashSet<CartItem>(0);
	
	@OneToMany(mappedBy = "item")
	private Set<ItemOffer> itemOffer= new HashSet<ItemOffer>(0);
	
	public IndividualItem(){
		
	}
	
	public IndividualItem(String aName, double aPrice){
		this.name= aName;
		this.price= aPrice;
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
	@Override
	public String showNameAndPrice() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("\t -");
		sb.append(getName());
		sb.append("..... $");
		sb.append(getPrice());
		sb.append(System.getProperty("line.separator"));
		String message = sb.toString();
		System.out.println(message);
		return message;
	}

	public int getIdItem() {
		return idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Set<ItemOffer> getItemOffer() {
		return itemOffer;
	}

	public void setItemOffer(Set<ItemOffer> itemOffer) {
		this.itemOffer = itemOffer;
	}

	public Set<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	
}
