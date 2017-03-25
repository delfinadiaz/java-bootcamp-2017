package Clase1OOP.AbstractFactoryExample;

public class NoSQLFactory extends AbstractFactory {

	@Override
	SQLConnection getSQLConnection(String connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	NoSQLConnection getNOSQLConnection(String connection) {
		if(connection == null){
	         return null;
	      }		
	      
	    if(connection.equalsIgnoreCase("Mongodb")){
	         return new MongodbConnection();
	         
	    }else if(connection.equalsIgnoreCase("Redis")){
	         return new RedisConnection();
	         
	    }else if(connection.equalsIgnoreCase("Couchdb")){
	         return new CouchdbConnection();
	    }
	      
	      return null;
	}

}
