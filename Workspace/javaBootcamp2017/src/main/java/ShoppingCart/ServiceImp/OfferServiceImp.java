package ShoppingCart.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoppingCart.DaoImp.OfferDaoImp;
import ShoppingCart.Model.Entities.Offer;
import ShoppingCart.Model.Entities.Payment;
import ShoppingCart.Service.OfferService;

@Service
public class OfferServiceImp implements OfferService {

	private OfferDaoImp offerDao;
	
	@Autowired
	public OfferServiceImp(OfferDaoImp offerDao){
		this.offerDao = offerDao;
	}
	
	@Override
	public boolean createOffer(Offer anOffer) {
		// TODO Auto-generated method stub
		return offerDao.createOffer(anOffer);
	}

	@Override
	public Offer getOffer(int idOffer) {
		// TODO Auto-generated method stub
		return offerDao.getOffer(idOffer);
	}

	@Override
	public List<Offer> getOffers() {
		// TODO Auto-generated method stub
		return offerDao.getOffers();
	}

	@Override
	public List<Offer> getOffersByPayment(int paymentType) {
		// TODO Auto-generated method stub
		return offerDao.getOffersByPayment(paymentType);
	}

	@Override
	public boolean updateOffer(Offer anOffer) {
		// TODO Auto-generated method stub
		return offerDao.updateOffer(anOffer);
	}

	@Override
	public boolean removeOffer(Offer anOffer) {
		// TODO Auto-generated method stub
		return offerDao.removeOffer(anOffer);
	}


}
