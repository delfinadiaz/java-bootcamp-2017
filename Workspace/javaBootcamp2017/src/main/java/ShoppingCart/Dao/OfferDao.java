package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Model.Entities.Offer;
import ShoppingCart.Model.Entities.Payment;

public interface OfferDao {

	public boolean createOffer(Offer anOffer);
	public Offer getOffer(int idOffer);
	public List<Offer> getOffers();
	public List<Offer> getOffersByPayment(int paymentType);
	public boolean updateOffer(Offer anOffer);
	public boolean removeOffer(Offer anOffer);
}
