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
	
	ShoppingCartImp shoppingCart; 
	
	@Before
	public void init() {
		shoppingCart = ShoppingCartFactory.getLocalShoppingCart();
		MockitoAnnotations.initMocks(this);
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
		
		Mockito.when(item.getPrice()).thenReturn(40);
		Mockito.when(item2.getPrice()).thenReturn(20);
		shoppingCart.addItem(item);
		shoppingCart.addItem(item2);
		assertEquals(60,shoppingCart.getTotalPrice());
		Mockito.verify(item).getPrice();
		Mockito.verify(item2).getPrice();
		
	}
	
	@Test
	public void whenBuyThenTheCartGetsEmptyAndMessageIsReturned(){
		Mockito.when(item.getPrice()).thenReturn(40);
		shoppingCart.addItem(item);
		shoppingCart.buy();
		assertTrue(shoppingCart.getItems().isEmpty());
		Mockito.verify(item).getPrice();
		
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
