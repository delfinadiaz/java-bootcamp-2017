package Clase1OOP;

public class AuxiliaryClass {
	public static void main(String[] args) {
		DBSingletonExample singletonExample = DBSingletonExample.getInstance();

		singletonExample.sayHello();
	}
}
