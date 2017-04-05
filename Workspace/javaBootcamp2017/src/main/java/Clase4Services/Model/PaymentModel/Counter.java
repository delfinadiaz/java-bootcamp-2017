package Clase4Services.Model.PaymentModel;

public class Counter {

	private static int count = 0;
	private int id;

	public int generateUniqueID() {
		int id = ++count;
		setId(id);
		return id;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
}
