package Clase1OOP.AbstractFactoryExample;

public class SQLFactory extends AbstractFactory {

	@Override
	SQLConnection getSQLConnection(String connection) {
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

	@Override
	NoSQLConnection getNOSQLConnection(String connection) {
		// TODO Auto-generated method stub
		return null;
	}
}
