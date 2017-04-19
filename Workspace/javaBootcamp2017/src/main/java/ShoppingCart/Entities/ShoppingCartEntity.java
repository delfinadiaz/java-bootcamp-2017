package ShoppingCart.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


import com.fasterxml.jackson.annotation.JsonIgnore;

import ShoppingCart.Model.ShoppingCartStatus;

@SuppressWarnings("serial")
@Entity
@Table(name = "cart")
public class ShoppingCartEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcart")
	private int idShoppingCart;
	
	@ManyToOne
	@JoinColumn(name="user",nullable=false)
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "cart",cascade=CascadeType.ALL)
	private Set<CartItem> cartItems= new HashSet<CartItem>(0);
	
	@Transient
	private List<IndividualItem> items = new ArrayList<IndividualItem>();
	
	
	private ShoppingCartStatus status;
	
	public ShoppingCartEntity(User anUser){
		this.user = anUser;
	}

	public ShoppingCartEntity(){
	}

	public void addItem(IndividualItem anItem, int quantity) {
		// TODO Auto-generated method stub
		CartItem newcartItem = new CartItem(this, anItem,quantity);
		getCartItems().add(newcartItem);
	}

	public void removeItem(IndividualItem item, int quantity) {
		// TODO Auto-generated method stub
		CartItem cartItem = getCartItem(this, item);
    	getCartItems().remove(cartItem);
	}
	
	private CartItem getCartItem(ShoppingCartEntity cart, IndividualItem item) {
		// TODO Auto-generated method stub
		for (CartItem cartItem : getCartItems()){
			if ((cartItem.getCart()==cart) && (cartItem.getItem()==item)){
				return cartItem;
			}
		}
		return null;
	}

	public void addItem(IndividualItem anItem){
		items.add(anItem);
	}

	public boolean removeItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		if (items.contains(anItem)){
			items.remove(anItem);
			return true;
		}
		System.out.println("The item to remove wasn't in the cart");
		return false;
		
	}

	public List<IndividualItem> getItems() {
		// TODO Auto-generated method stub
		return items;
	}

	
	public double getPartialPrice(){
		// TODO Auto-generated method stub
		double sumPrice=0;
		Iterator<IndividualItem> it = getItems().listIterator();
		while (it.hasNext()) {
			IndividualItem item = it.next();
			sumPrice+=item.getPrice();
		}
		return sumPrice;
	}
	
/*
	public void buy(Payment aPaymentOption) {
		// TODO Auto-generated method stub
		double partialPrice = getPartialPrice();
		boolean purchaseMade = aPaymentOption.buy(getUser(),items,partialPrice);
		if (purchaseMade){
			emptyCart();
		}
		else {
			throw new PaymentException();
		}	
	}*/


	public void emptyCart() {
		items.clear();
	}	
	

	public String showItems() {
		// TODO Auto-generated method stub
		Iterator<IndividualItem> it = items.listIterator();
		String message = null;
		StringBuilder sb = new StringBuilder();
		while (it.hasNext()) {
			IndividualItem item = it.next();
			sb.append("-");
			sb.append(item.getName());
			sb.append(" .....$");
			sb.append(item.getPrice());
			sb.append(System.getProperty("line.separator"));
		}
		message = sb.toString();
		return message;
		
	}
	
	public int getIdShoppingCart() {
		return idShoppingCart;
	}


	public void setIdShoppingCart(int idShoppingCart) {
		this.idShoppingCart = idShoppingCart;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	
}
