package Clase1OOP;

public class PostgreSQLDatabaseBuilder implements DatabaseBuilder {
	
	private Database database;
	
	public PostgreSQLDatabaseBuilder(){
		database = new Database();
	}
	
	@Override
	public void buildHostName() {
		database.setHostName("another hostname");
	}

	@Override
	public void buildDBName() {
		database.setDbName("another database name");
		
	}

	@Override
	public void buildUsername() {
		database.setUsername("another username");
		
	}

	@Override
	public void buildPassword() {
		database.setPassword("another password");
		
	}

	@Override
	public void buildDBDriver() {
		database.setDbDriver("PostgreSQL");
		
	}

	@Override
	public Database getDatabase() {
		// TODO Auto-generated method stub
		return database;
	}
	
}
