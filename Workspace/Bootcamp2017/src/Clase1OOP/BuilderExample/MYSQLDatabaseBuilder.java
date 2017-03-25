package Clase1OOP.BuilderExample;

public class MYSQLDatabaseBuilder implements DatabaseBuilder {
	
	private Database database;
	
	public MYSQLDatabaseBuilder(){
		database = new Database();
	}
	
	@Override
	public void buildHostName() {
		database.setHostName("a hostname");
	}

	@Override
	public void buildDBName() {
		database.setDbName("a database name");
		
	}

	@Override
	public void buildUsername() {
		database.setUsername("a username");
		
	}

	@Override
	public void buildPassword() {
		database.setPassword("a password");
		
	}

	@Override
	public void buildDBDriver() {
		database.setDbDriver("MYSQL");
		
	}

	@Override
	public Database getDatabase() {
		// TODO Auto-generated method stub
		return database;
	}
	
}
