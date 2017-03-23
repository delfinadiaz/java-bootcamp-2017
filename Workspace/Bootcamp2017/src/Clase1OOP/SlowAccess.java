package Clase1OOP;

public class SlowAccess extends DBAccesor {
	public SlowAccess() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
