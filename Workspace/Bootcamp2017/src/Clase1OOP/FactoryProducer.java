package Clase1OOP;

public class FactoryProducer {
	
	 public static AbstractFactory getFactory(){
		 
	     return new DBConnectionFactory();
	 }
}
