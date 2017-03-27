package Clase1OOP.AbstractFactoryExample;

public class RedisConnection implements NoSQLConnection {

	
	public void noSQLConnect() {
		System.out.println("Connecting to Redis..");
	}
}
