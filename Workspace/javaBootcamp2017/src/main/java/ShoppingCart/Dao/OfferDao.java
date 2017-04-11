package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Entities.Offer;
import ShoppingCart.Model.Category;

public interface OfferDao {

	public void createOffer(String aName, double aPrice, Category aCategory);
	public void changeOfferName(int idOffer,String aName);
	public void changeOfferPrice(int idOffer, double aPrice);
	public void changeOfferCategory(int idOffer, Category aCategory);
    public Offer getOffer(int idOffer);
    public List<Offer> getOffers();
    public void removeOffer(int idOffer);
}
