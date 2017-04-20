package ShoppingCart.Service;

import java.util.List;

import ShoppingCart.Model.ShoppingCartStatus;
import ShoppingCart.Model.Entities.CartItem;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.Payment;
import ShoppingCart.Model.Entities.ShoppingCartEntity;
import ShoppingCart.Model.Entities.User;

public interface ShoppingCartAPI {

	/**
	 * This gets the shopping cart with the specified id
	 * 
	 * @param idShoppingCart
	 *            id of the shopping cart to get
	 * @return the shopping cart with the same id that was sent in the parameter
	 */
	public ShoppingCartEntity getShoppingCart(int idShoppingCart);

	/**
	 * This creates a shopping cart with the specified instance of the shopping cart 
	 * @param cart instance of the shopping cart to create
	 * @return true if the shopping cart was created successfully or false if it wasn't
	 */
	public boolean createShoppingCart(ShoppingCartEntity cart);
	
	
	/**
	 * This updates a shopping cart with the specified instance of the shopping cart
	 * @param cart instance of the shopping cart to update
	 * @return true if the shopping cart was updated successfully or false if it wasn't
	 */
	public boolean updateShoppingCart(ShoppingCartEntity cart);

	/**
	 * This gets a list of shopping carts with the specified status
	 * 
	 * @param status
	 *            the status of the shopping carts to get.The status are
	 *            0(Created), 1(Paid) or 2(Cancelled)
	 * @return the list of the shopping carts with the same status that was sent
	 *         it in the parameter
	 */
	public List<ShoppingCartEntity> getShoppingCartsByStatus(ShoppingCartStatus status);

	/**
	 * This removes the specified shopping cart
	 * 
	 * @param cart
	 *            the instance of the shopping cart to remove
	 * @return true if the shopping cart was removed successfully or false if it wasn't
	 */
	public boolean removeShoppingCart(ShoppingCartEntity cart);

	/**
	 * This gets the association between the specified cart and item
	 * 
	 * @param cart
	 *            the instance of the cart
	 * @param item
	 *            the item of the cart specified before
	 * @return the cartItem that contains the quantity of the specified item in
	 *         the specified cart
	 */
	public CartItem getCartItem(ShoppingCartEntity cart, IndividualItem item);

	/**
	 * This creates a cartItem with the specified instance of the cartItem
	 * 
	 * @param cartItem
	 * @return true if the cartItem was created successfully or false if it
	 *         wasn't
	 */
	public boolean createCartItem(CartItem cartItem);

	/**
	 * This updates a cartItem with the specified instance of the cartItem
	 * 
	 * @param cartItem
	 * @return true if the cartItem was updated successfully or false if it
	 *         wasn't
	 */
	public boolean updateCartItem(CartItem cartItem);

	/**
	 * This removes a cartItem with the specified instance of the cartItem
	 * 
	 * @param cartItem
	 * @return true if the cartItem was removed successfully or false if it
	 *         wasn't
	 */
	public boolean removeCartItem(CartItem cartItem);

	/**
	 * This gets a payment with the specified id
	 * 
	 * @param idPayment
	 *            id of the payment to get
	 * @return the instance of the payment with the same id that was sent in the
	 *         parameter
	 */
	public Payment getPayment(int idPayment);

	/**
	 * This creates a payment with the specified instance of payment
	 * 
	 * @param aPayment
	 *            instance of the payment to create
	 * @return true if the payment was created successfully or false if it
	 *         wasn't
	 */
	public boolean createPayment(Payment aPayment);

	/**
	 * This gets a list of payments with a specified type
	 * 
	 * @param paymentType
	 *            type of the payments to get. The types are 1(CashPayment),
	 *            2(CreditCardPayment) and 3 (PaypalPayment)
	 * @return the list of payments with the same type that was sent in the
	 *         parameter
	 */
	public List<Payment> getPaymentsByType(int paymentType);

	/**
	 * This gets a list of payments done by a specified user
	 * 
	 * @param anUser
	 *            the user that did the payments to get
	 * @return the list of payments that did the user sent in the parameter
	 */
	public List<Payment> getPaymentsByUser(User anUser);
}
