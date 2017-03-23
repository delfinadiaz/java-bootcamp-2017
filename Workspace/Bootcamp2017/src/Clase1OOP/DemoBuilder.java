package Clase1OOP;

public class DemoBuilder {

	public static void main(String[] args) {
		
        //creates a Mysql database
		DatabaseBuilder databaseBuilder = new MYSQLDatabaseBuilder();
		DatabaseDirector databaseDirector = new DatabaseDirector(databaseBuilder);
		databaseDirector.constructDatabase();
		Database database = databaseDirector.getDatabase();
		System.out.println("The database is: " + database);
		
		//creates a PostgreSQL database
		databaseBuilder = new PostgreSQLDatabaseBuilder();
		databaseDirector = new DatabaseDirector(databaseBuilder);
		databaseDirector.constructDatabase();
		database = databaseDirector.getDatabase();
		System.out.println("The database is: " + database);
	}
}
