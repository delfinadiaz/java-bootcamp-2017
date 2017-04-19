package ShoppingCart.Model.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ShoppingCart.Model.Category;
import ShoppingCart.Model.Item;

@SuppressWarnings("serial")
@Entity
@Table(name = "item")
public class IndividualItem implements Item,Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iditem")
	private int idItem;
	
	@Column(length = 45)
	private String name;
	
	private double price;
	private Category category;
	private int stock;

	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "item")
	private Set<CartItem> cartItem= new HashSet<CartItem>(0);
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "item_offer", joinColumns = {
			@JoinColumn(name = "iditem", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "idoffer",
					nullable = false, updatable = false) })
	private Set<Offer> offers = new HashSet<Offer>(0);

	public IndividualItem() {

	}

	public IndividualItem(String aName, double aPrice,Category aCategory, int aStock) {
		this.name = aName;
		this.price = aPrice;
		this.category= aCategory;
		this.stock = aStock;
	}

	public IndividualItem(String aName, double aPrice) {
		this.name = aName;
		this.price = aPrice;
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



	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void addOffer(Offer anOffer){
		this.getOffers().add(anOffer);
	}
	
	public void removeOffer(Offer anOffer){
		this.getOffers().remove(anOffer);
	}
	
	@JsonIgnore
	public Set<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@JsonIgnore
	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public void removeItem(ShoppingCartEntity cart, int quantity) {
		// TODO Auto-generated method stub
		CartItem cartItem = getCartItem(cart, this);
    	getCartItem().remove(cartItem);
	}
	
	private CartItem getCartItem(ShoppingCartEntity cart, IndividualItem item) {
		// TODO Auto-generated method stub
		for (CartItem cartItem : getCartItem()){
			if ((cartItem.getCart()==cart) && (cartItem.getItem()==item)){
				return cartItem;
			}
		}
		return null;
	}
}
