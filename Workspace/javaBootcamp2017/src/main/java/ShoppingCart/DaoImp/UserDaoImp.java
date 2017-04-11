package ShoppingCart.DaoImp;

import ShoppingCart.Dao.UserDao;
import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.Entities.User;
import ShoppingCart.Model.MarketModel.Market;

public class UserDaoImp implements UserDao {

	@Override
	public void createUser(String anUsername, String aPassword, String anEmail, Market aMarket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCreditNumber(int idUser, int aCreditNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean logInUser(int idUser, String anUsername, String aPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changePassword(int idUser, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeEmail(int idUser, String newEmail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCartEntity getShoppingCartUser(int idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logOutUser(int IdUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUser(int idUser) {
		// TODO Auto-generated method stub
		
	}

}
