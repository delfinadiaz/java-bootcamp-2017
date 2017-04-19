package ShoppingCart.Dao;

import java.util.List;


import ShoppingCart.Entities.Offer;
import ShoppingCart.Entities.Payment;

public interface OfferDao {

	public boolean createOffer(Offer anOffer);
	public Offer getOffer(int idOffer);
	public List<Offer> getOffers();
	public List<Offer> getOffersByPayment(int paymentType);
	public Offer getOffersByItem(int idItem,Payment aPayment);
	public boolean updateOffer(Offer anOffer);
	public boolean removeOffer(Offer anOffer);
}
