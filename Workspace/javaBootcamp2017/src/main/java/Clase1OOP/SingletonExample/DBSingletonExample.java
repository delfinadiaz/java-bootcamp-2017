package Clase1OOP.SingletonExample;

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

	public void connect() {
		System.out.println("Connecting to database..");
	}
}
