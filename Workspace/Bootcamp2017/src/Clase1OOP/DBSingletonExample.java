package Clase1OOP;

public class DBSingletonExample {
	private static DBSingletonExample singletonExample = null;

	private DBSingletonExample() {
	}

	public static DBSingletonExample getInstance() {
		if (singletonExample == null) {
			singletonExample = new DBSingletonExample();
		}
		return singletonExample;
	}

	public void sayHello() {
		System.out.println("Hello");
	}
}
