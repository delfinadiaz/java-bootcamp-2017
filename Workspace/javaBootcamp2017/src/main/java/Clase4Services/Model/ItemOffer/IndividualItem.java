package Clase4Services.Model.ItemOffer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Clase4Services.Model.Item;
import Clase4Services.Model.MarketModel.Market;
import Clase4Services.ServiceImp.ShoppingCartImp;

@Entity
@Table(name = "item_offer")
public class IndividualItem implements Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iditem_offer")
	private int idItem;
	
	private String name;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="market",nullable=false)
	private Market market;
	
	
	private ShoppingCartImp shoppingCart;
	
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
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	public ShoppingCartImp getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCartImp shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	
}
