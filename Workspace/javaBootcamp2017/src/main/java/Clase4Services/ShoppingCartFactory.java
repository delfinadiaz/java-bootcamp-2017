package Clase4Services;

import Clase4Services.ServiceImp.ShoppingCartImp;

public class ShoppingCartFactory {

	public ShoppingCartFactory(){
		
	}
	
	public static ShoppingCartImp getLocalShoppingCart(){
		return new ShoppingCartImp();
	}
}
