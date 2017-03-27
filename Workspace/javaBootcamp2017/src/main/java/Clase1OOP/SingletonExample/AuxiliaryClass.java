package Clase1OOP.SingletonExample;

public class AuxiliaryClass {
	public static void main(String[] args) {
		DBSingletonExample singletonExample = DBSingletonExample.getInstance();

		singletonExample.connect();
	}
}
