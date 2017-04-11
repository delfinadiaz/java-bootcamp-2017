package ShoppingCart.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;


import ShoppingCart.Model.Payment;
import ShoppingCart.Model.PaymentModel.PaymentException;

@Entity
@Table(name = "cart")
public class ShoppingCartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcart")
	private int idShoppingCart;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	
	@OneToMany(mappedBy = "cart")
	private Set<CartItem> cartItem= new HashSet<CartItem>(0);
	
	@Transient
	private List<IndividualItem> cart = new ArrayList<IndividualItem>();
	
	public ShoppingCartEntity(){
	}
	

	public void initialize(User anUser) {
		this.setUser(anUser);
		
	}

	public void addItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		cart.add(anItem);
	}


	public boolean removeItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		if (cart.contains(anItem)){
			cart.remove(anItem);
			return true;
		}
		System.out.println("The item to remove wasn't in the cart");
		return false;
		
	}


	public List<IndividualItem> getItems() {
		// TODO Auto-generated method stub
		return cart;
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
	

	public void buy(Payment aPaymentOption) {
		// TODO Auto-generated method stub
		double partialPrice = getPartialPrice();
		boolean purchaseMade = aPaymentOption.buy(getUser(),cart,partialPrice);
		if (purchaseMade){
			emptyCart();
		}
		else {
			throw new PaymentException();
		}	
	}


	public void emptyCart() {
		cart.clear();
	}	
	

	public String showItems() {
		// TODO Auto-generated method stub
		Iterator<IndividualItem> it = cart.listIterator();
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}
