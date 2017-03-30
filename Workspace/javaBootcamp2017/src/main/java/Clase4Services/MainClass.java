package Clase4Services;

public class MainClass {
	
	 public static void main(String[] args) {  
		 
	        
	        ShoppingCartImp shoppingCart = ShoppingCartFactory.getLocalShoppingCart();
	        
	        Item item = new Item("a name", 40);
	        Item item2= new Item("another name", 100);
	        Item item3= new Item("name 3", 20);
	        
	        shoppingCart.addItem(item);
	        shoppingCart.addItem(item2);
	        shoppingCart.addItem(item3);
	        
	        shoppingCart.removeItem(item2);
	        
	        shoppingCart.getTotalPrice();
	        shoppingCart.buy();  
	          
	    }  

}
