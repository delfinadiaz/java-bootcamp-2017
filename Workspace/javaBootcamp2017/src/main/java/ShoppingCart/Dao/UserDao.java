package ShoppingCart.Dao;

import ShoppingCart.Entities.ShoppingCartEntity;
import ShoppingCart.Entities.User;
import ShoppingCart.Model.MarketModel.Market;

public interface UserDao {

	public void createUser(String anUsername, String aPassword,String anEmail, Market aMarket);
	public void setCreditNumber(int idUser, int aCreditNumber);
	public boolean logInUser(int idUser, String anUsername, String aPassword);
	public void changePassword(int idUser, String oldPassword,String newPassword);
	public void changeEmail(int idUser, String newEmail);
	public User getUser(int idUser);
	public ShoppingCartEntity getShoppingCartUser(int idUser);
	public void logOutUser(int IdUser);
	public void removeUser(int idUser);
}
