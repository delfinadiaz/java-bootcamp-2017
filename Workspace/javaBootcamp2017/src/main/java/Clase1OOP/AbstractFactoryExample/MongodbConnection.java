package Clase1OOP.AbstractFactoryExample;

public class MongodbConnection implements NoSQLConnection {

	
	public void noSQLConnect() {
		System.out.println("Connecting to Mongodb..");
	}

}
