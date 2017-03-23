package Clase1OOP;
import java.util.Date;

public abstract class DBAccesor {
	public void access() {
		System.out.println(this.getClass().getSimpleName() + " is accessing the database at " + new Date());
	}

}
