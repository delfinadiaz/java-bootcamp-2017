package Clase1OOP.AbstractFactoryExample;

public class CouchdbConnection implements NoSQLConnection {

	public void noSQLConnect() {
		System.out.println("Connecting to Couchdb..");
	}

}
