package Clase1OOP.BuilderExample;

public class DatabaseDirector {

	private DatabaseBuilder databaseBuilder = null;

	public DatabaseDirector(DatabaseBuilder databaseBuilder) {
		this.databaseBuilder = databaseBuilder;
	}

	public void constructDatabase() {
		
		databaseBuilder.buildHostName();
		databaseBuilder.buildDBName();	
		databaseBuilder.buildUsername();
		databaseBuilder.buildPassword();
		databaseBuilder.buildDBDriver();
	}

	public Database getDatabase() {
		return databaseBuilder.getDatabase();
	}
}
