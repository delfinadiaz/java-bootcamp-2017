package Clase4Services.ServiceImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import Clase4Services.Model.Payment;
import Clase4Services.Model.ItemOffer.IndividualItem;
import Clase4Services.Model.MarketModel.User;
import Clase4Services.Model.PaymentModel.PaymentException;
import Clase4Services.Service.ShoppingCartAPI;


@Entity
@Table(name = "shopping_cart")
public class ShoppingCartImp implements ShoppingCartAPI {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idshopping_cart")
	private int idShoppingCart;
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private User user;
	
	private List<IndividualItem> cart;
	
	public ShoppingCartImp(){
		cart = new ArrayList<IndividualItem>();
	}
	

	@Override
	public void initialize(User anUser) {
		this.user = anUser;
		
	}

	@Override
	public void addItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		cart.add(anItem);
	}

	@Override
	public boolean removeItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		if (cart.contains(anItem)){
			cart.remove(anItem);
			return true;
		}
		System.out.println("The item to remove wasn't in the cart");
		return false;
		
	}

	@Override
	public List<IndividualItem> getItems() {
		// TODO Auto-generated method stub
		return cart;
	}

	@Override
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
	
	@Override
	public void buy(Payment aPaymentOption) {
		// TODO Auto-generated method stub
		double partialPrice = getPartialPrice();
		boolean purchaseMade = aPaymentOption.buy(user,cart,partialPrice);
		if (purchaseMade){
			emptyCart();
		}
		else {
			throw new PaymentException();
		}	
	}

	@Override
	public void emptyCart() {
		cart.clear();
	}	
	
	@Override
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
	

}
