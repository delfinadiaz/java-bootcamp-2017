package Clase4Services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ShoppingCartImpTest {
	
	@Mock
	IndividualItem item;
	@Mock
	IndividualItem item2;
	@Mock
	User user;
	@Mock
	Market market;
	@Mock
	Offer offer;
	
	
	ShoppingCartImp shoppingCart; 
	
	@Before
	public void init() {
		shoppingCart = ShoppingCartFactory.getLocalShoppingCart();
		MockitoAnnotations.initMocks(this);
		shoppingCart.initialize(user);
	}
	
	@Test
	public void whenShoppingCartIsCreatedThenTheCartIsEmpty(){
		assertTrue(shoppingCart.getItems().isEmpty());
	}
	
	@Test
	public void whenItemIsAddedThenTheItemIsAddedToTheCart(){
		shoppingCart.addItem(item);
		assertTrue(shoppingCart.getItems().contains(item));
	}
	
	@Test
	public void whenItemIsRemovedThenTheItemIsRemovedFromTheCartAndReturnsTrue(){
		shoppingCart.addItem(item);
		assertTrue(shoppingCart.removeItem(item));
		assertFalse(shoppingCart.getItems().contains(item));
	}
	
	@Test
	public void whenItemToRemoveIsntInTheCartThenReturnsFalseAndShowsAMessage(){
		assertFalse(shoppingCart.removeItem(item));
	}
	
	@Test
	public void whenGetTotalPriceThenTheAdditionOfAllTheItemsInTheCartIsReturned(){
		//delta is the difference allowed in the comparison
		double delta= 0.001;
		Mockito.when(item.getPrice()).thenReturn((double) 40);
		Mockito.when(item2.getPrice()).thenReturn((double)20);
		shoppingCart.addItem(item);
		shoppingCart.addItem(item2);
		double price= shoppingCart.getPartialPrice();
		assertEquals((double)60, price,delta);
		Mockito.verify(item).getPrice();
		Mockito.verify(item2).getPrice();
		
	}
	
	@Test
	public void whenBuyThenTheCartGetsEmptyAndMessageIsReturned(){
		Mockito.when(user.getMarket()).thenReturn(market);
		Mockito.when(item.getPrice()).thenReturn((double)40);
		shoppingCart.addItem(item);
		shoppingCart.buy(new CashPayment());
		assertTrue(shoppingCart.getItems().isEmpty());
		Mockito.verify(user).getMarket();
	}
	
	@Test
	public void whenBuyByCashThenThe90PercentOfTheMostExpensiveItemIsFree(){
		//delta is the difference allowed in the comparison
		double delta= 0.001;
		Mockito.when(user.getMarket()).thenReturn(market);
		Mockito.when(item.getPrice()).thenReturn((double)40);
		Mockito.when(item2.getPrice()).thenReturn((double)10);
		shoppingCart.addItem(item);
		shoppingCart.addItem(item2);
		CashPayment cashPayment =new CashPayment();
		shoppingCart.buy(cashPayment);
		assertEquals((double)14,cashPayment.getAmount(),delta);
	}
	
	@Test
	public void whenBuyByPayPalThenTheCheapestItemIsFree(){
		//delta is the difference allowed in the comparison
		double delta= 0.001;
		Mockito.when(user.getMarket()).thenReturn(market);
		Mockito.when(item.getPrice()).thenReturn((double)40);
		Mockito.when(item2.getPrice()).thenReturn((double)10);
		shoppingCart.addItem(item);
		shoppingCart.addItem(item2);
		PaypalPayment paypalPayment =new PaypalPayment();
		shoppingCart.buy(paypalPayment);
		assertEquals((double)40,paypalPayment.getAmount(),delta);
	}
	
	@Test
	public void whenBuyByCreditCardThenThe10PercentIsDiscounted(){
		//delta is the difference allowed in the comparison
		double delta= 0.001;
		Mockito.when(user.getMarket()).thenReturn(market);
		Mockito.when(item.getPrice()).thenReturn((double)40);
		Mockito.when(item2.getPrice()).thenReturn((double)10);
		shoppingCart.addItem(item);
		shoppingCart.addItem(item2);
		CreditCardPayment creditCardPayment =new CreditCardPayment();
		shoppingCart.buy(creditCardPayment);
		assertEquals((double)45,creditCardPayment.getAmount(),delta);
	}
	
	@Test
	public void whenGetItemsThenAllTheItemsInTheCartAreReturned(){
		List<IndividualItem> list = new ArrayList<IndividualItem>();
		shoppingCart.addItem(item);
		list.add(item);
		shoppingCart.addItem(item2);
		list.add(item2);
		assertEquals(list.size(),shoppingCart.getItems().size());
	}
	
	@Test
	public void whenShowItemsThenTheItemsAreDisplayedNextToTheirPrices(){
		
		Mockito.when(item.getPrice()).thenReturn((double)10);
		Mockito.when(item.getName()).thenReturn("A name");
		shoppingCart.addItem(item);
		Mockito.when(item2.getPrice()).thenReturn((double)20);
		Mockito.when(item2.getName()).thenReturn("Another name");
		shoppingCart.addItem(item2);
		
		StringBuilder sb = new StringBuilder();
		sb.append("-");
		sb.append(item.getName());
		sb.append(" .....$");
		sb.append(item.getPrice());
		sb.append(System.getProperty("line.separator"));
		sb.append("-");
		sb.append(item2.getName());
		sb.append(" .....$");
		sb.append(item2.getPrice());
		sb.append(System.getProperty("line.separator"));
		String message = sb.toString();
		assertEquals(message, shoppingCart.showItems());
	}
	
	@Test
	public void whenMarketIsCreatedThenListOfUsersIsEmpty(){
		assertTrue(market.getUsers().isEmpty());
	}
	
	@Test
	public void whenMarketIsCreatedThenMailingListIsEmpty(){
		assertTrue(market.getMailingList().isEmpty());
	}
	
	@Test
	public void whenMarketIsCreatedThenListOfItemsAndOffersIsEmpty(){
		assertTrue(market.getItemsAndOffers().isEmpty());
	}
	
	@Test
	public void whenMarketIsCreatedThenListOfPaymentTransactionsIsEmpty(){
		assertTrue(market.getPaymentTransactions().isEmpty());
	}
	
	@Test
	public void whenAnItemIsAddedThenTheMarketManagerIsNotified(){
		Market market2 = new Market("a name");
        market2.addUser(user);
        MarketManager marketManager = new MarketManager("a name", "an email");
        market2.addPersonToMailingList(marketManager);
        market2.addAnItemOrOffer(item);
        String message = "A new Item has been added";
        assertEquals(message, marketManager.getMessage());
	}
	
	@Test
	public void whenAnOfferIsAddedThenTheMarketManagerIsNotified(){
		Market market2 = new Market("a name");
        market2.addUser(user);
        MarketManager marketManager = new MarketManager("a name", "an email");
        market2.addPersonToMailingList(marketManager);
        market2.addAnItemOrOffer(offer);
        String message = "A new Offer has been added";
        assertEquals(message, marketManager.getMessage());
	}
	
	@Test
	public void whenanItemPriceHasChangedThenTheMarketManagerIsNotified(){
		Market market2 = new Market("a name");
        market2.addUser(user);
        MarketManager marketManager = new MarketManager("a name", "an email");
        market2.addPersonToMailingList(marketManager);
        Mockito.when(item.getName()).thenReturn("name item");
        Mockito.when(item.getPrice()).thenReturn((double)40);
        market2.addAnItemOrOffer(item);
        market2.changePriceItemOrOffer(item, (double)50);
        String message = "The Price of the item: name item has changed";
        assertEquals(message, marketManager.getMessage());
	}
	
	@Test
	public void whenanOfferPriceHasChangedThenTheMarketManagerIsNotified(){
		Market market2 = new Market("a name");
        market2.addUser(user);
        MarketManager marketManager = new MarketManager("a name", "an email");
        market2.addPersonToMailingList(marketManager);
        Mockito.when(offer.getName()).thenReturn("name offer");
        Mockito.when(offer.getPrice()).thenReturn((double)40);
        market2.addAnItemOrOffer(offer);
        market2.changePriceItemOrOffer(offer, (double)50);
        String message = "The Price of the offer: name offer has changed";
        assertEquals(message, marketManager.getMessage());
	}
	
	@Test
	public void whenAPaymentTransactionIsMadeThenTheMarketManagerIsNotified(){
		Market market2 = new Market("a name");
        market2.addUser(user);
        Mockito.when(user.getMarket()).thenReturn(market2);
        MarketManager marketManager = new MarketManager("a name", "an email");
        market2.addPersonToMailingList(marketManager);
        IndividualItem item = new IndividualItem("a name", (double)40);
		shoppingCart.addItem(item);
		shoppingCart.buy(new CreditCardPayment());
        String message = "A new Transaction has been made";
        System.out.println(marketManager.getMessage());
        assertEquals(message, marketManager.getMessage());
	}

}
