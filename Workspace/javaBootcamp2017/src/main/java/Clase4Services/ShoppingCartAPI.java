package Clase4Services;

import java.util.List;

public interface ShoppingCartAPI {
	
	//Assign the shopping cart to an user
	public void initialize(User anUser);
	
	// Receives an item that is added to the cart
	public void addItem(IndividualItem anItem);
	
	/*Receives an item,
	  If the item already exists in the cart then the item is deleted and the method returns True 
	  If the item doesn't exist in the car then the method returns False and shows a message */
	public boolean removeItem(IndividualItem anItem);
	
	//Returns the addition of all the prices of the items in the cart
	public double getTotalPrice();
	
	//Returns all the items in the cart
	public List<IndividualItem> getItems();
	
	/*Receives a payment option and call its buy() method
	 and after calls the method emptyCart() to remove all the items that were bought */
	public void buy(Payment aPaymentOption);
	
	//Removes all the items in the cart, this method is called from the method buy()
	public void emptyCart();

	//Shows all the items in the cart next to their price
	public String showItems();
}
