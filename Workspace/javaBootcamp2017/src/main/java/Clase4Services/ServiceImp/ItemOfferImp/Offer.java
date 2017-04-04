package Clase4Services.ServiceImp.ItemOfferImp;

import java.util.ArrayList;
import java.util.List;

import Clase4Services.Service.Item;

public class Offer implements Item{

	private String name;
	private double price;
	

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
	
}
