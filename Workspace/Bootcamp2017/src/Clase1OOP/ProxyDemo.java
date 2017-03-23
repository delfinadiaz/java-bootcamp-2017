package Clase1OOP;

public class ProxyDemo {
	public static void main(String[] args) {

		Proxy proxy = new Proxy();

		FastAccess fastAccess = new FastAccess();
		fastAccess.access();

		proxy.access();

	}
}
