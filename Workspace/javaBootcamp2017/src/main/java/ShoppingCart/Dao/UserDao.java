package ShoppingCart.Dao;

import java.util.List;

import ShoppingCart.Model.Entities.User;

public interface UserDao {

	public boolean createUser(User anUser);
	public User getUser(int idUser);
	public User getUserByName(String aName);
	public List<User> getUsers();
	public User userExists(String anUsername);
	public boolean logInUser(int idUser, String anUsername, String aPassword);
	public boolean updateUser(User anUser);
	public int getAmountOfTransactions(User anUser);
	public void logOutUser(int IdUser);
	public boolean removeUser(User anUser);
}
