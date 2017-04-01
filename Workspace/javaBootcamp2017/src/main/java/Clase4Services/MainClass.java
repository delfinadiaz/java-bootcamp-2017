package Clase4Services;

public class MainClass {
	
	 public static void main(String[] args) {  
		 
	        
	        ShoppingCartImp shoppingCart = ShoppingCartFactory.getLocalShoppingCart();
	        
	        User user = new User("an username", "a password","anEmail");
	        shoppingCart.initialize(user);
	        
	        IndividualItem item = new IndividualItem("a name", 40);
	        IndividualItem item2= new IndividualItem("another name", 100);
	        IndividualItem item3= new IndividualItem("name 3", 20);
	        
	        shoppingCart.addItem(item);
	        shoppingCart.addItem(item2);
	        shoppingCart.addItem(item3);
	        
	        shoppingCart.removeItem(item2);
	        
	        shoppingCart.getTotalPrice();
	        shoppingCart.buy(new CashPayment());  
	        
	        Offer offer= new Offer("Offer Name",(double)40);
	        offer.add(item);
	        offer.add(item2);
	        
	        Offer offer2 = new Offer("Another Offer Name",(double)20);
	        offer.add(offer2);
	        offer.add(item3);
	        
	        offer.displayOffers();
	          
	    }  

}
