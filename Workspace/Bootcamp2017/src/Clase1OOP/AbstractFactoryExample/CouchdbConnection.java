package Clase1OOP.AbstractFactoryExample;

public class CouchdbConnection implements NoSQLConnection {

	@Override
	public void noSQLConnect() {
		System.out.println("Connecting to Couchdb..");
	}

}
