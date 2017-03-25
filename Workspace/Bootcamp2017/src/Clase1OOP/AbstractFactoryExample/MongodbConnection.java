package Clase1OOP.AbstractFactoryExample;

public class MongodbConnection implements NoSQLConnection {

	@Override
	public void noSQLConnect() {
		System.out.println("Connecting to Mongodb..");
	}

}
