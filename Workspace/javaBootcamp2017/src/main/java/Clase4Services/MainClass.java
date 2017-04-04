package Clase4Services;

import Clase4Services.ServiceImp.ShoppingCartImp;
import Clase4Services.ServiceImp.User;
import Clase4Services.ServiceImp.ItemOfferImp.IndividualItem;
import Clase4Services.ServiceImp.ItemOfferImp.Offer;
import Clase4Services.ServiceImp.MarketImp.Market;
import Clase4Services.ServiceImp.MarketImp.MarketManager;
import Clase4Services.ServiceImp.PaymentImp.CashPayment;
import Clase4Services.ServiceImp.PaymentImp.CreditCardPayment;
import Clase4Services.ServiceImp.PaymentImp.PaypalPayment;

public class MainClass {
	
	 public static void main(String[] args) {  
		 
	        
	        ShoppingCartImp shoppingCart = ShoppingCartFactory.getLocalShoppingCart();
	        Market market = new Market("a name");
	        User user = new User("an username", "a password","anEmail",market);
	        market.addUser(user);
	        MarketManager marketManager = new MarketManager("a name", "an email");
	        market.addPersonToMailingList(marketManager);
	        
	      //Trying the shopping cart functionality
	        
	        shoppingCart.initialize(user);
	     
	        IndividualItem item = new IndividualItem("a name", (double)40);
	        IndividualItem item2= new IndividualItem("another name", (double)100);
	        IndividualItem item3= new IndividualItem("name 3", (double)20);
	        
	        shoppingCart.addItem(item);
	        shoppingCart.addItem(item2);
	        shoppingCart.addItem(item3);
	        
	        shoppingCart.removeItem(item2);
	        
	        System.out.println(shoppingCart.getPartialPrice());
	        shoppingCart.buy(new CashPayment()); 
	        
	        
	        shoppingCart.addItem(item2);
	        shoppingCart.addItem(item3);
	        System.out.println(shoppingCart.getPartialPrice());
	        shoppingCart.buy(new PaypalPayment()); 
	        
	        shoppingCart.addItem(item);
	        shoppingCart.addItem(item);
	        System.out.println(shoppingCart.getPartialPrice());
	        shoppingCart.buy(new CreditCardPayment()); 
	        
	        
	        //Trying the functionality to display items and offers
	        
	        Offer offer= new Offer("Offer Name",(double)40);
	        offer.add(item);
	        offer.add(item2);
	        
	        Offer offer2 = new Offer("Another Offer Name",(double)20);
	        offer.add(offer2);
	        offer.add(item3);
	        
	        offer.displayOffers();
	        
	        //Trying the mailing list functionality
	          
	        market.addAnItemOrOffer(item);
	        System.out.println(marketManager.getMessage());
	        
	        market.addAnItemOrOffer(offer);
	        System.out.println(marketManager.getMessage());
	        
	        market.changePriceItemOrOffer(item, (double)50);
	        System.out.println(marketManager.getMessage());
	       
	        market.changePriceItemOrOffer(offer, (double)50);
	        System.out.println(marketManager.getMessage());
	        
	        shoppingCart.addItem(item);
	        shoppingCart.buy(new CreditCardPayment());
	        System.out.println(marketManager.getMessage());
	        
	        System.out.println(market.getPaymentTransactions());
	        
	        
	    }  

}
