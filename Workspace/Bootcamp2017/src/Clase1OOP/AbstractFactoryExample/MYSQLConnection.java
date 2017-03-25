package Clase1OOP.AbstractFactoryExample;

public class MYSQLConnection implements SQLConnection{

	@Override
	public void sqlConnect() {
		System.out.println("Connecting to MYSQL..");
		
	}

}
