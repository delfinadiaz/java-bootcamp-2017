package Clase1OOP.ProxyExample;

import java.util.Date;

public class Proxy {
	SlowAccess slowAccess;

	public Proxy() {
		System.out.println("Accessing the database at " + new Date());
	}

	public void access() {
		if (slowAccess == null) {
			slowAccess = new SlowAccess();
		}
		slowAccess.access();
	}
}
