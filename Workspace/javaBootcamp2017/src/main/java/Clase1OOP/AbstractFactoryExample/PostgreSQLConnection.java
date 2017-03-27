package Clase1OOP.AbstractFactoryExample;

public class PostgreSQLConnection implements SQLConnection{

	
	public void sqlConnect() {
		System.out.println("Connecting to PostgreSQL..");
		
	}

}