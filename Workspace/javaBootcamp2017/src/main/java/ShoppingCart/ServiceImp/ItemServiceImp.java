package ShoppingCart.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoppingCart.DaoImp.ItemDaoImp;
import ShoppingCart.Entities.IndividualItem;
import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.Model.Category;
import ShoppingCart.Service.ItemService;

@Service
public class ItemServiceImp implements ItemService {

	ItemDaoImp itemDao;
	
	@Autowired
	public ItemServiceImp(ItemDaoImp itemDao){
		this.itemDao = itemDao;
	}
	
	@Override
	public boolean createItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		return itemDao.createItem(anItem);
	}

	@Override
	public IndividualItem getItem(int idItem) {
		// TODO Auto-generated method stub
		return itemDao.getItem(idItem);
	}

	@Override
	public List<IndividualItem> getItems() {
		// TODO Auto-generated method stub
		return itemDao.getItems();
	}

	@Override
	public List<IndividualItem> getItemsByCategory(Category category) {
		// TODO Auto-generated method stub
		return itemDao.getItemsByCategory(category);
	}

	@Override
	public List<IndividualItem> getItemsByName(String aName) {
		// TODO Auto-generated method stub
		return itemDao.getItemsByName(aName);
	}

	@Override
	public boolean updateItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		return itemDao.updateItem(anItem);
	}

	@Override
	public boolean removeItem(IndividualItem anItem) {
		// TODO Auto-generated method stub
		return itemDao.removeItem(anItem);
	}

	@Override
	public List<IndividualItem> getItemsByCart(ShoppingCartEntity aCart) {
		// TODO Auto-generated method stub
		return itemDao.getItemsByCart(aCart);
	}

	@Override
	public int getOfferItemWithGivenPaymentType(int idItem, int paymentType) {
		// TODO Auto-generated method stub
		return itemDao.getOfferItemWithGivenPaymentType(idItem, paymentType);
	}

}
