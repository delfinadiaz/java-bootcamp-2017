package Clase4Services.Model.ItemOffer;

import java.util.ArrayList;
import java.util.List;

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

@Entity
@Table(name = "item_offer")
public class Offer implements Item{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iditem_offer")
	private int idOffer;
	
	private String name;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="market",nullable=false)
	private Market market;
	

	List<Item> components = new ArrayList<Item>();
	
	public Offer(String name, double price){
		this.name= name;
		this.price=price;
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public void setName(String aName) {
		// TODO Auto-generated method stub
		this.name= aName;
		
	}
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	@Override
	public void setPrice(double aPrice) {
		// TODO Auto-generated method stub
		this.price = aPrice;
	}
	
	public void add(Item anItemOrOffer) {
		components.add(anItemOrOffer);
	}

	public void remove(Item anItemOrOffer) {
		components.remove(anItemOrOffer);
	}

	public List<Item> getComponents() {
		return components;
	}
	
	public void displayOffers(){
		showNameAndPrice();
		for (Item component : components){
			component.showNameAndPrice();
		}
	}
	@Override
	public String showNameAndPrice() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder("-");
		sb.append(getName());
		sb.append("..... $");
		sb.append(getPrice());
		sb.append(System.getProperty("line.separator"));
		String message = sb.toString();
		System.out.println(message);
		return message;
	}
	public int getIdOffer() {
		return idOffer;
	}
	public void setIdOffer(int idOffer) {
		this.idOffer = idOffer;
	}
	public Market getMarket() {
		return market;
	}
	public void setMarket(Market market) {
		this.market = market;
	}
	
}
