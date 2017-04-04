package Clase4Services.Service;

public interface UserService {
	
	public void logUser(String anUsername, String aPassword);
	public boolean userExists(String anUsername);
	public void createUser(String anUsername, String aPassword,String anEmail);
	public void removeUser(String anUsername);
	public void changeUserPassword(String anUsername, String oldPassword,String newPassword);
}
