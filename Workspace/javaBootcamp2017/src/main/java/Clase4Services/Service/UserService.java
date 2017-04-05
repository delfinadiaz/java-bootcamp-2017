package Clase4Services.Service;

import Clase4Services.Model.MarketModel.Market;
import Clase4Services.Model.MarketModel.User;

public interface UserService {
	
	public boolean logUser(User anUser, String anUsername, String aPassword);
	public boolean userExists(User anUser);
	public void createUser(String anUsername, String aPassword,String anEmail, Market aMarket);
	public void removeUser(User anUser);
	public void changeUserPassword(User anUser, String oldPassword,String newPassword);
}
