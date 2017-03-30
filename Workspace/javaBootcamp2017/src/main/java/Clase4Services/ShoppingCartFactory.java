package Clase4Services;

public class ShoppingCartFactory {

	public ShoppingCartFactory(){
		
	}
	
	public static ShoppingCartImp getLocalShoppingCart(){
		return new ShoppingCartImp();
	}
}
