package Clase1OOP.AbstractFactoryExample;

public class SQLITEConnection implements SQLConnection{

	@Override
	public void sqlConnect() {
		System.out.println("Connecting to SQLITE..");
		
	}

}