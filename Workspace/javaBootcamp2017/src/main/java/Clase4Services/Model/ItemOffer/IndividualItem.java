package Clase4Services.Model.ItemOffer;

import Clase4Services.Model.Item;

public class IndividualItem implements Item {
	private String name;
	private double price;
	
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
	
}
