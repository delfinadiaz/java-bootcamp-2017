package Clase1OOP.AbstractFactoryExample;

public class AbstractFactoryPatternDemo {
	 public static void main(String[] args) {
          
	      //get SQL db connection factory
	      AbstractFactory sqlConnectionFactory = FactoryProducer.getFactory("SQLConnection");

	      //get an object of Mysql connection
	      SQLConnection sqlConnection1 = sqlConnectionFactory.getSQLConnection("MYSQL");

	      //call connect method of Mysql connection
	      sqlConnection1.sqlConnect();

	      //get an object of SQLITE connection
	      SQLConnection sqlConnection2 = sqlConnectionFactory.getSQLConnection("SQLITE");

	      //call connect method of SQLITE connection
	      sqlConnection2.sqlConnect();
	      
	    //get an object of POSTGRESQL connection
	      SQLConnection sqlConnection3 = sqlConnectionFactory.getSQLConnection("PostgreSQL");

	      //call connect method of POSTGRESQL connection
	      sqlConnection3.sqlConnect();
	      
	      
	      //get NO SQL db connection factory
	      AbstractFactory noSQLConnectionFactory = FactoryProducer.getFactory("NoSQLConnection");

	      //get an object of Mongodb connection
	      NoSQLConnection noSQLConnection1 = noSQLConnectionFactory.getNOSQLConnection("Mongodb");

	      //call connect method of Mongodb connection
	      noSQLConnection1.noSQLConnect();

	      //get an object of Redis connection
	      NoSQLConnection noSQLConnection2 = noSQLConnectionFactory.getNOSQLConnection("Redis");

	      //call connect method of Redis connection
	      noSQLConnection2.noSQLConnect();
	      
	    //get an object of Couchdb connection
	      NoSQLConnection noSQLConnection3 = noSQLConnectionFactory.getNOSQLConnection("Couchdb");

	      //call connect method of Couchdb connection
	      noSQLConnection3.noSQLConnect();
	   }
}
