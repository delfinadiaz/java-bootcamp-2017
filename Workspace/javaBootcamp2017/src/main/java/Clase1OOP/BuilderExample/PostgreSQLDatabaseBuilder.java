package Clase1OOP.BuilderExample;

public class PostgreSQLDatabaseBuilder implements DatabaseBuilder {
	
	private Database database;
	
	public PostgreSQLDatabaseBuilder(){
		database = new Database();
	}
	
	
	public void buildHostName() {
		database.setHostName("another hostname");
	}

	
	public void buildDBName() {
		database.setDbName("another database name");
		
	}

	
	public void buildUsername() {
		database.setUsername("another username");
		
	}

	
	public void buildPassword() {
		database.setPassword("another password");
		
	}

	
	public void buildDBDriver() {
		database.setDbDriver("PostgreSQL");
		
	}

	
	public Database getDatabase() {
		// TODO Auto-generated method stub
		return database;
	}
	
}
