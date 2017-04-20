package ShoppingCart.Service;

import java.util.List;

import ShoppingCart.Model.Entities.User;

public interface UserService {
	/**
	 * This creates an user with the specified instance of the user
	 * 
	 * @param anUser
	 *            the instance of the user to create
	 * @return true if the user was created successfully or false if it wasn't
	 */
	public boolean createUser(User anUser);

	/**
	 * This gets the user with the specified id
	 * 
	 * @param idUser
	 *            id of the user to get
	 * @return the user with the same id that was sent in the parameter
	 */
	public User getUser(int idUser);

	/**
	 * This gets the user with the specified name
	 * 
	 * @param aName
	 *            name of the user to get
	 * @return the user with the same name that was sent in the parameter
	 */
	public User getUserByName(String aName);

	/**
	 * This gets a list of all the users
	 * 
	 * @return the list of all the users
	 */
	public List<User> getUsers();

	/**
	 * This gets the user with the specified username
	 * 
	 * @param anUsername
	 *            username of the user to get
	 * @return the user with the same username that was sent in the parameter
	 */
	public User userExists(String anUsername);

	/**
	 * This updates an user the specified instance of the user
	 * 
	 * @param anUser
	 *            the user to update
	 * @return true if the user was updated successfully or false if it wasn't
	 */
	public boolean updateUser(User anUser);

	/**
	 * This removes an user the specified instance of the user
	 * 
	 * @param anUser
	 *            the user to remove
	 * @return true if the user was removed successfully or false if it wasn't
	 */
	public boolean removeUser(User anUser);
}
