package ShoppingCart.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ShoppingCart.DaoImp.UserDaoImp;
import ShoppingCart.Entities.User;
import ShoppingCart.Service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	private UserDaoImp userDao;
	
	@Autowired
	public UserServiceImp(UserDaoImp userDao){
		this.userDao = userDao;
	}

	@Override
	public boolean createUser(User anUser) {
		// TODO Auto-generated method stub
		return userDao.createUser(anUser);
		
	}


	@Override
	public boolean logInUser(int idUser, String anUsername, String aPassword) {
		// TODO Auto-generated method stub
		return userDao.logInUser(idUser, anUsername, aPassword);
	}

	@Override
	public User getUser(int idUser) {
		// TODO Auto-generated method stub
		return userDao.getUser(idUser);
	}

	@Override
	public User userExists(String anUsername) {
		// TODO Auto-generated method stub
		return userDao.userExists(anUsername);
	}

	@Override
	public void logOutUser(int idUser) {
		// TODO Auto-generated method stub
		userDao.logOutUser(idUser);
		
	}

	@Override
	public boolean removeUser(User anUser) {
		// TODO Auto-generated method stub
		return userDao.removeUser(anUser);
		
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}

	@Override
	public boolean updateUser(User anUser) {
		// TODO Auto-generated method stub
		return userDao.updateUser(anUser);
	}

	@Override
	public int getAmountOfTransactions(User anUser) {
		// TODO Auto-generated method stub
		return userDao.getAmountOfTransactions(anUser);
	}

	@Override
	public User getUserByName(String aName) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(aName);
	}
	
	
	


}
