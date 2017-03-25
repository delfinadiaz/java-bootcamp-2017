package Clase1OOP.AbstractFactoryExample;

public abstract class AbstractFactory {
	abstract SQLConnection getSQLConnection(String connection);
	abstract NoSQLConnection getNOSQLConnection(String connection);
	
}
