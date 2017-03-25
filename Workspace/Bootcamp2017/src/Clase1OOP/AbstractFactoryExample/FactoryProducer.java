package Clase1OOP.AbstractFactoryExample;

public class FactoryProducer {
	
	public static AbstractFactory getFactory(String choice){
		   
	      if(choice.equalsIgnoreCase("SQLConnection")){
	         return new SQLFactory();
	         
	      }else if(choice.equalsIgnoreCase("NoSQLConnection")){
	         return new NoSQLFactory();
	      }
	      
	      return null;
	   }
}
