package ShoppingCart.RestService;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ShoppingCart.Dto.CartDTO.ListShoppingCartsDTO;
import ShoppingCart.Dto.CartDTO.ShoppingCartDTO;
import ShoppingCart.Dto.CartDTO.StadisticShoppingCartDTO;
import ShoppingCart.Dto.ItemDTO.InfoItemDTO;
import ShoppingCart.Dto.ItemDTO.ItemCartDTO;
import ShoppingCart.Dto.ItemDTO.ListItemDTO;
import ShoppingCart.Dto.PaymentDTO.ListStadisticPaymentDTO;
import ShoppingCart.Dto.PaymentDTO.PaymentDTO;
import ShoppingCart.Mapper.CartMapper;
import ShoppingCart.Mapper.ItemMapper;
import ShoppingCart.Model.ShoppingCartStatus;
import ShoppingCart.Model.Entities.CartItem;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Payment;
import ShoppingCart.Model.Entities.ShoppingCartEntity;
import ShoppingCart.Model.Entities.User;
import ShoppingCart.Service.ItemService;
import ShoppingCart.Service.UserService;
import ShoppingCart.ServiceImp.ShoppingCartImp;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartRestService {
    
	
	private ShoppingCartImp service;
	private UserService userService;
	private ItemService itemService;
	
	@Autowired
	public ShoppingCartRestService(ShoppingCartImp service, UserService userService, ItemService itemService){
		this.service = service;
		this.userService=userService;
		this.itemService= itemService;
	}


		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/{idShoppingCart}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getShoppingCart(@PathVariable int idShoppingCart) throws JsonProcessingException {
        
		ShoppingCartEntity cart = service.getShoppingCart(idShoppingCart);
		if (cart == null) {
			return new ResponseEntity("No cart found with id " + idShoppingCart, HttpStatus.NOT_FOUND);
		}
		List<IndividualItem> items = itemService.getItemsByCart(cart);
		StadisticShoppingCartDTO stadisticCarts = null;
		try {
			String username = cart.getUser().getUsername();
			String status =cart.getStatus().toString();
			stadisticCarts = CartMapper.convertToStadisticCartDTO(items,username,status);
			return new ResponseEntity(stadisticCarts, HttpStatus.OK);
			
			
		}
		catch(Exception  e){
			return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/status/{status}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getShoppingCartsByStatus(@PathVariable int status) throws JsonProcessingException {
		if (status > ShoppingCartStatus.values().length) {
			return new ResponseEntity("Status no valid", HttpStatus.CONFLICT);
		}
		ShoppingCartStatus enumStatus = ShoppingCartStatus.values()[status];
		List<ShoppingCartEntity> carts = service.getShoppingCartsByStatus(enumStatus);
		if (carts.isEmpty()) {
			return new ResponseEntity("No shoppings carts found for the status", HttpStatus.NOT_FOUND);
		} else {
			List<ShoppingCartDTO> shoppingCartsDTO = new ArrayList<ShoppingCartDTO>();
			for (ShoppingCartEntity cart : carts) {
				List<IndividualItem> items = itemService.getItemsByCart(cart);
				List<ItemCartDTO> itemsdto = new ArrayList<ItemCartDTO>();
				// Adds the DTO items to the DTO list
				for (IndividualItem item : items) {
					CartItem cartItem = service.getCartItem(cart, item);
					ItemCartDTO itemCartDTO = new ItemCartDTO(item.getIdItem(), cartItem.getQuantity());
					itemsdto.add(itemCartDTO);
				}
				// Adds the DTO items list to the DTO cart list
				int iduser = cart.getUser().getIdUser();
				ShoppingCartDTO cartDTO = new ShoppingCartDTO(iduser, itemsdto);
				shoppingCartsDTO.add(cartDTO);
			}
			String statusString = enumStatus.toString();
			ListShoppingCartsDTO cartsDTO = new ListShoppingCartsDTO(shoppingCartsDTO,statusString);
			return new ResponseEntity(cartsDTO, HttpStatus.OK);
		}
	}
	
    @Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.POST)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity saveShoppingCart(@RequestBody ShoppingCartDTO cartDTO) throws JsonProcessingException {
        User user= userService.getUser(cartDTO.getIdUser());
        if (user == null){
        	return new ResponseEntity("The user does not exist", HttpStatus.NOT_FOUND);
        }
		ShoppingCartEntity cart = new ShoppingCartEntity(user);
		cart.setStatus(ShoppingCartStatus.Created);
		List<ItemCartDTO> itemsdto=cartDTO.getItems();
		for (ItemCartDTO itemDto : itemsdto) {
			IndividualItem item = itemService.getItem(itemDto.getIdItem());
            if (item.getStock() < itemDto.getQuantity()){
	        	return new ResponseEntity("The stock of the item " + item.getIdItem() + " is not enough", HttpStatus.CONFLICT);
            }
            int oldStock = item.getStock();
			int newStock= oldStock - itemDto.getQuantity();
			item.setStock(newStock);
			itemService.updateItem(item);
			cart.addItem(item,itemDto.getQuantity());

		}
		boolean created = service.createShoppingCart(cart);
		if (created) {
			return new ResponseEntity("The Shopping Cart was successfully created",HttpStatus.CREATED);
		}
		else{
			return new ResponseEntity("The Shopping Cart could not be created", HttpStatus.CONFLICT);
		}
    }
	
    @Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.PUT, value = "/{idShoppingCart}")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity addItems(@PathVariable int idShoppingCart, @RequestBody ShoppingCartDTO cartDTO) throws JsonProcessingException {
        
		//Checks if idShoppingCart exists
		ShoppingCartEntity cart = service.getShoppingCart(idShoppingCart);
		if (cart == null){
			return new ResponseEntity("The Shopping Cart was not found",HttpStatus.NOT_FOUND);
		}
		
		//Checks if idUser sent in the body exists and if is the owner of the cart
		User user= userService.getUser(cartDTO.getIdUser());
        if (user == null){
        	return new ResponseEntity("The user does not exist", HttpStatus.NOT_FOUND);
        }
        if(user.getIdUser()!= cart.getUser().getIdUser()){
        	return new ResponseEntity("The user is not the owner of the cart to update", HttpStatus.CONFLICT);
        }
        
		// Add items to the shopping cart
		for (ItemCartDTO itemcartdto : cartDTO.getItems()) {
			IndividualItem item = itemService.getItem(itemcartdto.getIdItem());
			
			// Checks if the stock of the item is enough
			if (item.getStock() < itemcartdto.getQuantity()) {
				return new ResponseEntity("The stock of the item " + item.getIdItem() + " is not enough", HttpStatus.CONFLICT);
			}
			cart.addItem(item, itemcartdto.getQuantity());
			
			// Updates stock of each item
			int oldStock = item.getStock();
			int newStock = oldStock - itemcartdto.getQuantity();
			item.setStock(newStock);
			itemService.updateItem(item);

			// Checks if the item was already bought before in the same cart
			CartItem cartItemOfItemBoughtBefore = service.getCartItem(cart, item);
			if (cartItemOfItemBoughtBefore != null) {
				// If it was bought before then updates the quantity of the existing cart item
				int quantityUpdated = cartItemOfItemBoughtBefore.getQuantity() + itemcartdto.getQuantity();
				cartItemOfItemBoughtBefore.setQuantity(quantityUpdated);
				boolean updated = service.updateCartItem(cartItemOfItemBoughtBefore);
				if (!(updated)){
					return new ResponseEntity("The items could not be added",HttpStatus.OK);
				}
				
			} 
			else {
				// If it wasn't bought before then saves the association between the cart and the items
				CartItem newCartItem = new CartItem(cart,item,itemcartdto.getQuantity());
				boolean created = service.createCartItem(newCartItem);
				if (!(created)){
					return new ResponseEntity("The items could not be added",HttpStatus.OK);
				}
			}
		}
			return new ResponseEntity("The items were successfully added",HttpStatus.OK);
	}
    
    
    
    @Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.PUT, value = "/{idShoppingCart}/removeItems")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity removeItems(@PathVariable int idShoppingCart, @RequestBody ShoppingCartDTO cartDTO) throws JsonProcessingException {
        
		//Checks if idShoppingCart exists
		ShoppingCartEntity cart = service.getShoppingCart(idShoppingCart);
		if (cart == null){
			return new ResponseEntity("The Shopping Cart was not found",HttpStatus.NOT_FOUND);
		}
		
		//Checks if idUser sent it in the body exists and is the owner of the cart
		User user= userService.getUser(cartDTO.getIdUser());
        if (user == null){
        	return new ResponseEntity("The user does not exist", HttpStatus.NOT_FOUND);
        }
        if(user.getIdUser()!= cart.getUser().getIdUser()){
        	return new ResponseEntity("The user is not the owner of the cart to update", HttpStatus.CONFLICT);
        }
        //Remove items to the shopping cart
       for (ItemCartDTO itemcartdto : cartDTO.getItems()){
        	IndividualItem item = itemService.getItem(itemcartdto.getIdItem());
        	CartItem cartItem = service.getCartItem(cart,item);
        	//Checks if the quantity to remove isn't higher than the actual quantity
        	if (cartItem.getQuantity()< itemcartdto.getQuantity()){
            	return new ResponseEntity("The quantity to remove of the item " +itemcartdto.getIdItem()+ "is higher than the actual quantity of that item" , HttpStatus.CONFLICT);
            }
        	//Updates the stock of the item
        	int newStock = item.getStock() + itemcartdto.getQuantity();
        	item.setStock(newStock);
        	itemService.updateItem(item);
        	
        	//Updates the quantity of the item in CartItem
        	int newQuantity = cartItem.getQuantity() - itemcartdto.getQuantity();
             if (newQuantity==0){
        		//If the quantity of items is 0 then removes the association between the cart and that item
        		cart.removeItem(item, itemcartdto.getQuantity());
        		 boolean removed = service.removeCartItem(cartItem);
        		 if (!(removed)){
 					return new ResponseEntity("The items could not be removed",HttpStatus.OK);
 				}
        	}
             else {
	        	cartItem.setQuantity(newQuantity);
	        	service.updateShoppingCart(cart);
	        	boolean updated =service.updateCartItem(cartItem);
	        	 if (!(updated)){
	 					return new ResponseEntity("The items could not be removed",HttpStatus.OK);
	 				}
             }
    }
     
	return new ResponseEntity("The items were successfully removed",HttpStatus.OK);
	   
	}
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.DELETE, value = "/{idShoppingCart}")
	public ResponseEntity removeCart(@PathVariable int idShoppingCart) throws JsonProcessingException {

		ShoppingCartEntity cart = service.getShoppingCart(idShoppingCart);
		if (cart == null) {
			return new ResponseEntity("No shopping cart found with id " + idShoppingCart, HttpStatus.NOT_FOUND);
		}

		boolean deleted = service.removeShoppingCart(cart);
		if (deleted) {
			return new ResponseEntity("The cart was successfully deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity("The cart could not be deleted", HttpStatus.CONFLICT);
		}

	}
    
    @Transactional
   	@SuppressWarnings({ "rawtypes", "unchecked" })
   	@RequestMapping(method = RequestMethod.PUT, value = "/buyCart/{idShoppingCart}")
   	@Consumes(MediaType.APPLICATION_JSON)
   	public ResponseEntity buyCart(@PathVariable int idShoppingCart, @RequestBody PaymentDTO paymentDTO) throws JsonProcessingException {
           
   		//Checks if idShoppingCart exists
   		ShoppingCartEntity cart = service.getShoppingCart(idShoppingCart);
   		if (cart == null){
   			return new ResponseEntity("The Shopping Cart was not found",HttpStatus.NOT_FOUND);
   		}
   		if(cart.getStatus() == ShoppingCartStatus.Paid){
   			return new ResponseEntity("The Shopping Cart is already paid",HttpStatus.NOT_FOUND);
   		}
   		if(cart.getStatus() == ShoppingCartStatus.Cancelled){
   			return new ResponseEntity("The Shopping Cart is cancelled",HttpStatus.NOT_FOUND);
   		}
   		List<IndividualItem> items = itemService.getItemsByCart(cart);
   		double partialPrice =0;
		for (IndividualItem item : items){
			int discount = itemService.getOfferItemWithGivenPaymentType(item.getIdItem(),paymentDTO.getPaymentType());
			CartItem cartItem = service.getCartItem(cart, item);
			if (discount == 0){
				partialPrice += item.getPrice()*cartItem.getQuantity();
			}
			else{
					double percentageDiscount = ((double) discount )/ 100;
					double priceDiscount = item.getPrice() * percentageDiscount;
	                partialPrice += ((item.getPrice()- priceDiscount)*cartItem.getQuantity());
				
			}
		}
		Payment payment = null;
		try {
			payment = CartMapper.createPaymentFromDTO(paymentDTO,paymentDTO.getPaymentType());
			if (payment == null){
				return new ResponseEntity("null", HttpStatus.CONFLICT);
	          }
		}
		catch(Exception  e){
			return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
		}
		Boolean cartBought = payment.buy(cart.getUser(),items,partialPrice);
		if (cartBought){
			payment.setCart(cart);
			service.createPayment(payment);
			cart.setStatus(ShoppingCartStatus.Paid);
			Boolean updated= service.updateShoppingCart(cart);
			if (updated){
				return new ResponseEntity("The cart was successfully bought", HttpStatus.OK);
			}
			return new ResponseEntity("The cart could not be bought", HttpStatus.CONFLICT);
		}
		return new ResponseEntity("The cart could not be bought", HttpStatus.CONFLICT);
      }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/payments/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getPaymentsByType(@PathVariable int type) throws JsonProcessingException {
		if (type > 3 || type < 1) {
			return new ResponseEntity(" Payment Type no valid", HttpStatus.CONFLICT);
		}
		List<Payment> payments = service.getPaymentsByType(type);
		if (payments.isEmpty()) {
			return new ResponseEntity("No payments found for type " + type, HttpStatus.NOT_FOUND);
		} else {
			ListStadisticPaymentDTO stadisticPayments = null;
			try {
				stadisticPayments = CartMapper.convertToListPaymentsDTO(payments);
				 return new ResponseEntity(stadisticPayments, HttpStatus.OK);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
		    
		}
	}
    
    
    @Transactional
   	@SuppressWarnings({ "rawtypes", "unchecked" })
   	@RequestMapping(method = RequestMethod.PUT, value = "/cancelCart/{idShoppingCart}")
   	@Consumes(MediaType.APPLICATION_JSON)
   	public ResponseEntity cancelCart(@PathVariable int idShoppingCart) throws JsonProcessingException {
           
   		//Checks if idShoppingCart exists
   		ShoppingCartEntity cart = service.getShoppingCart(idShoppingCart);
   		if (cart == null){
   			return new ResponseEntity("The Shopping Cart was not found",HttpStatus.NOT_FOUND);
   		}
   		
   		if(cart.getStatus() == ShoppingCartStatus.Paid){
   			return new ResponseEntity("The Shopping Cart is paid",HttpStatus.NOT_FOUND);
   		}
   		if(cart.getStatus() == ShoppingCartStatus.Cancelled){
   			return new ResponseEntity("The Shopping Cart is already cancelled",HttpStatus.NOT_FOUND);
   		}
   		
   		cart.setStatus(ShoppingCartStatus.Cancelled);
   		boolean updated = service.updateShoppingCart(cart);
   		if (updated) {
   			return new ResponseEntity("The cart was successfully cancelled",HttpStatus.OK);
   		}
   		else{
   			return new ResponseEntity("The cart could not be cancelled", HttpStatus.CONFLICT);
   		}
   	}
       
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(method = RequestMethod.GET, value = "/userPayments/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity getPaymentsByUser(@PathVariable int idUser) throws JsonProcessingException {
    	User user= userService.getUser(idUser);
        if (user == null){
        	return new ResponseEntity("The user does not exist", HttpStatus.NOT_FOUND);
        }
		List<Payment> payments = service.getPaymentsByUser(user);
		if (payments.isEmpty()) {
			return new ResponseEntity("No payments found for the user " + user.getUsername(), HttpStatus.NOT_FOUND);
		} else {
			ListStadisticPaymentDTO stadisticPayments = null;
			try {
				stadisticPayments = CartMapper.convertToListPaymentsDTO(payments);
				 return new ResponseEntity(stadisticPayments, HttpStatus.OK);
			}
			catch(Exception  e){
				return new ResponseEntity("The operation could not be completed", HttpStatus.CONFLICT);
			}
		    
		}
	}
}
