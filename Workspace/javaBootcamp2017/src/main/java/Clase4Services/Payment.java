package Clase4Services;

import java.util.List;

public interface Payment {

	public boolean buy(User user, List<Item> cart, double totalPrice);
	public double getAmount();
}
