package Clase1OOP;

public class Database {
	
	private String hostName;
	private String dbName;
	private String username;
	private String password;
	private String dbDriver;
	
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDbDriver() {
		return dbDriver;
	}
	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}
	
	public String toString() {
		return "host: " + hostName + ", database: " + dbName + ", username: " + username+ ", password: " + password+ ", dbDriver: " + dbDriver;
	}
	
}
