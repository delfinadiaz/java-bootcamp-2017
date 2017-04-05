package Clase4Services.ServiceImp;

import Clase4Services.Model.MarketModel.Market;
import Clase4Services.Model.MarketModel.User;
import Clase4Services.Service.UserService;

public class UserServiceImp implements UserService{
	
	private User user;

	@Override
	public boolean logUser(User anUser, String anUsername, String aPassword) {
		// TODO Auto-generated method stub
		if ((anUser.getUsername() == anUsername) && (anUser.getPassword()== aPassword)){
			//Log in the user
			return true;
		}
		return false;
	}

	@Override
	public boolean userExists(User anUser) {
		// TODO Auto-generated method stub
		return anUser.getMarket().getUsers().contains(anUser);
	}

	@Override
	public void createUser(String anUsername, String aPassword, String anEmail, Market aMarket) {
		// TODO Auto-generated method stub
		setUser(new User(anUsername,aPassword,anEmail,aMarket));
		aMarket.addUser(user);
		
	}

	@Override
	public void removeUser(User anUser) {
		// TODO Auto-generated method stub
		if (userExists(anUser)){ 
			anUser.getMarket().getUsers().remove(anUser);
		}
		System.out.println("The user doesn't exist");
		
	}

	@Override
	public void changeUserPassword(User anUser, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		if (anUser.getPassword() == oldPassword){
			anUser.setPassword(newPassword);
		}
		else {
			System.out.println("The old password is incorrect, plase try again");
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	


}
