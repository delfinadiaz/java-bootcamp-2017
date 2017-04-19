package ShoppingCart.Model.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ShoppingCart.Model.Item;

@SuppressWarnings("serial")
@Entity
@Table(name = "offer")
public class Offer implements Item,Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idoffer")
	private int idOffer;
	
	@Column(length = 45)
	private String name;

	private int paymentType;
	
	@Transient
	private double price;
	
	private int discount;
	

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "offers")
	private Set<IndividualItem> items= new HashSet<IndividualItem>(0);
	
	@Transient
    List<Item> components = new ArrayList<Item>();
	
	public Offer(){
		
	}
	/*public Offer(String name, double price){
		this.name= name;
		this.price=price;
	}*/
	
	public Offer(String name, int discount, int paymentType,Set<IndividualItem> items ){
		this.name= name;
		this.discount=discount;
		this.setPaymentType(paymentType);
		this.setItems(items);
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
	
	/*public void add(Item anItemOrOffer) {
		components.add(anItemOrOffer);
	}

	public void remove(Item anItemOrOffer) {
		components.remove(anItemOrOffer);
	}*/

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

	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public void addItem(IndividualItem item){
		getItems().add(item);
	}
	
	public void removeItem(IndividualItem item){
		getItems().remove(item);
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public Set<IndividualItem> getItems() {
		return items;
	}

	public void setItems(Set<IndividualItem> items) {
		this.items = items;
	}




	
}
