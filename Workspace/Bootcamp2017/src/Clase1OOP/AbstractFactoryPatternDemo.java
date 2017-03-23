package Clase1OOP;

public class AbstractFactoryPatternDemo {
	 public static void main(String[] args) {

	      //get db connection factory
	      AbstractFactory dbConnectionFactory = FactoryProducer.getFactory();

	      //get an object of Mysql connection
	      DBConnection dbConnection1 = dbConnectionFactory.getDBConnection("MYSQL");

	      //call connect method of Mysql connection
	      dbConnection1.connect();

	      //get an object of SQLITE connection
	      DBConnection dbConnection2 = dbConnectionFactory.getDBConnection("SQLITE");

	      //call connect method of SQLITE connection
	      dbConnection2.connect();
	      
	    //get an object of POSTGRESQL connection
	      DBConnection dbConnection3 = dbConnectionFactory.getDBConnection("PostgreSQL");

	      //call connect method of POSTGRESQL connection
	      dbConnection3.connect();
	   }
}
