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
	Item item;
	@Mock
	Item item2;
	@Mock
	User user;
	
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
		double price= shoppingCart.getTotalPrice();
		assertEquals((double)60, price,delta);
		Mockito.verify(item).getPrice();
		Mockito.verify(item2).getPrice();
		
	}
	
	@Test
	public void whenBuyThenTheCartGetsEmptyAndMessageIsReturned(){
		Mockito.when(item.getPrice()).thenReturn((double)40);
		shoppingCart.addItem(item);
		shoppingCart.buy(new CashPayment());
		assertTrue(shoppingCart.getItems().isEmpty());
	}
	
	@Test
	public void whenBuyByCashThenThe90PercentOfTheMostExpensiveItemIsFree(){
		//delta is the difference allowed in the comparison
		double delta= 0.001;
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
		Mockito.when(item.getPrice()).thenReturn((double)40);
		Mockito.when(item2.getPrice()).thenReturn((double)10);
		shoppingCart.addItem(item);
		shoppingCart.addItem(item2);
		PaypalPayment paypalPayment =new PaypalPayment();
		shoppingCart.buy(paypalPayment);
		assertEquals((double)40,paypalPayment.getAmount(),delta);
	}
	
	@Test
	public void whenBuyCreditCardThenThe10PercentIsDiscounted(){
		//delta is the difference allowed in the comparison
		double delta= 0.001;
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
		List<Item> list = new ArrayList<Item>();
		shoppingCart.addItem(item);
		list.add(item);
		shoppingCart.addItem(item2);
		list.add(item2);
		assertEquals(list.size(),shoppingCart.getItems().size());
	}
}
