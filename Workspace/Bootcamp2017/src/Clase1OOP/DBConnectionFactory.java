package Clase1OOP;

public class DBConnectionFactory extends AbstractFactory {

	@Override
	DBConnection getDBConnection(String connection) {
		if(connection == null){
	         return null;
	      }		
	      
	    if(connection.equalsIgnoreCase("MYSQL")){
	         return new MYSQLConnection();
	         
	    }else if(connection.equalsIgnoreCase("SQLITE")){
	         return new SQLITEConnection();
	         
	    }else if(connection.equalsIgnoreCase("PostgreSQL")){
	         return new PostgreSQLConnection();
	    }
	      
	      return null;
	   }
}
