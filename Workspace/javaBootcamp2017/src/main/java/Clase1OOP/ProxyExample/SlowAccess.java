package Clase1OOP.ProxyExample;

public class SlowAccess extends DBAccesor {
	public SlowAccess() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
