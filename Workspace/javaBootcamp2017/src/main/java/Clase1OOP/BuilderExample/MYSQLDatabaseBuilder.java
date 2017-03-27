package Clase1OOP.BuilderExample;

public class MYSQLDatabaseBuilder implements DatabaseBuilder {
	
	private Database database;
	
	public MYSQLDatabaseBuilder(){
		database = new Database();
	}
	
	public void buildHostName() {
		database.setHostName("a hostname");
	}

	
	public void buildDBName() {
		database.setDbName("a database name");
		
	}

	
	public void buildUsername() {
		database.setUsername("a username");
		
	}

	
	public void buildPassword() {
		database.setPassword("a password");
		
	}

	
	public void buildDBDriver() {
		database.setDbDriver("MYSQL");
		
	}

	
	public Database getDatabase() {
		// TODO Auto-generated method stub
		return database;
	}
	
}
