package ShoppingCart.Service;

import java.util.List;

import ShoppingCart.Model.Entities.Offer;
import ShoppingCart.Model.Entities.Payment;

public interface OfferService {

	/**
	 *  This creates an offer with the specified instance of the offer
	 * @param anOffer the instance of the offer to create
	 * @return true if the offer was created successfully or false if it wasn't
	 */
	public boolean createOffer(Offer anOffer);
	
	/**
	 * This gets the offer with the specified id
	 * @param idOffer id of the offer to get
	 * @return the offer with the same id that was sent in the parameter
	 */
	public Offer getOffer(int idOffer);
	
	/**
	 * This gets a list with all the offers
	 * @return the list with all the offers
	 */
	public List<Offer> getOffers();
	
	/**
	 * This gets the offers to the specified type of payment
	 * @param paymentType type of payment. The types are 1(CashPayment),
	 *            2(CreditCardPayment) and 3 (PaypalPayment)
	 * @return the list of offers with the same type that was sent in the parameter
	 */
	public List<Offer> getOffersByPayment(int paymentType);
	
	
	/**
	 *  This updates an offer with the specified instance of the offer
	 * @param anOffer the instance of the offer to update
	 * @return true if the offer was updated successfully or false if it wasn't
	 */
	public boolean updateOffer(Offer anOffer);
	
	/**
	 *  This removes an offer with the specified instance of the offer
	 * @param anOffer the instance of the offer to removed
	 * @return true if the offer was removed successfully or false if it wasn't
	 */
	public boolean removeOffer(Offer anOffer);
}
