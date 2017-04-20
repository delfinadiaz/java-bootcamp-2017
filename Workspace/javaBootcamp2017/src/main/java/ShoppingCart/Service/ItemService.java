package ShoppingCart.Service;

import java.util.List;

import ShoppingCart.Model.Category;
import ShoppingCart.Model.Entities.IndividualItem;
import ShoppingCart.Model.Entities.ShoppingCartEntity;

public interface ItemService {

	/**
	 * This creates an item with the specified instance of item
	 * 
	 * @param anItem
	 *            the instance of the item to create
	 * @return true if the item was created successfully or false if it wasn't
	 */
	public boolean createItem(IndividualItem anItem);

	/**
	 * This gets the item with the specified id
	 * 
	 * @param idItem
	 *            id of the item to get
	 * @return the item with the same id that was sent it the parameter
	 */
	public IndividualItem getItem(int idItem);

	/**
	 * This gets a list of all the items
	 * 
	 * @return the list with all the items
	 */
	public List<IndividualItem> getItems();

	/**
	 * This gets the items with the specified category
	 * 
	 * @param category
	 *            the category of the items to get. The categories are Music,
	 *            Entertainment, Home, Clothing, Electronic, Food
	 * @return the list of items with the same category that was sent in the
	 *         parameter
	 */
	public List<IndividualItem> getItemsByCategory(Category category);

	/**
	 * This gets the items with the specified name
	 * 
	 * @param aName
	 *            name of the items to get
	 * @return the list of items with the same name that was sent in the
	 *         parameter
	 */
	public List<IndividualItem> getItemsByName(String aName);

	/**
	 * This gets the items with the specified shopping cart
	 * 
	 * @param aCart
	 *            shopping cart of the items to get
	 * @return the list with all the items of the shopping cart sent in the
	 *         parameter
	 */
	public List<IndividualItem> getItemsByCart(ShoppingCartEntity aCart);

	/**
	 * This updates an item with the specified instance of item
	 * 
	 * @param anItem
	 *            the instance of the item to update
	 * @return true if the item was updated successfully or false if it wasn't
	 */
	public boolean updateItem(IndividualItem anItem);

	/**
	 * This removes an item with the specified instance of item
	 * 
	 * @param anItem
	 *            the instance of the item to remove
	 * @return true if the item was removed successfully or false if it wasn't
	 */
	public boolean removeItem(IndividualItem anItem);

	/**
	 * This gets the discount of the offer for the specified item paying with
	 * the specified payment type
	 * 
	 * @param idItem
	 *            id of the item to buy
	 * @param paymentType
	 *            type of the payment to buy the item
	 * @return the discount associated to the offer of the specified item paying
	 *         with the specified payment type
	 */
	public int getOfferItemWithGivenPaymentType(int idItem, int paymentType);
}
