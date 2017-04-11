package ShoppingCart.RestService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.ServiceImp.ShoppingCartImp;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartRestService {
    
	
	private ShoppingCartImp service;
	
	@Autowired
	public ShoppingCartRestService(ShoppingCartImp service){
		this.service = service;
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/{idShoppingCart}")
	public String getShoppingCart(@PathVariable int idShoppingCart) {
        
		ShoppingCartEntity cart = service.getShoppingCart(idShoppingCart);
		String output;
		
		if (cart == null) {
			output = "es null";
			return output;
			//return Response.status(200).entity(output).build();
		}
		else{
			output ="no es null su id es "+idShoppingCart;
			return output;
			//return Response.status(200).entity(output).build();
		}

	}
}
