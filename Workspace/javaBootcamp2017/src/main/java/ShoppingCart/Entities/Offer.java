package ShoppingCart.Entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import ShoppingCart.Model.Item;

@Entity
@Table(name = "offer")
public class Offer implements Item{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iditem_offer")
	private int idOffer;
	
	private String name;
	private double price;
	
	@OneToMany(mappedBy = "offer")
	private Set<ItemOffer> itemOffer= new HashSet<ItemOffer>(0);
	
	@Transient
    List<Item> components = new ArrayList<Item>();
	
	public Offer(){
		
	}
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
	public Set<ItemOffer> getItemOffer() {
		return itemOffer;
	}
	public void setItemOffer(Set<ItemOffer> itemOffer) {
		this.itemOffer = itemOffer;
	}
	
}
