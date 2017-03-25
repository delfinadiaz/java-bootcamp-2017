package Clase1OOP.DatabaseLoggers;

public class Select extends DBOperation {
	
	@Override
	void doQuery(String columns, String tables, String condition) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Select " + columns + " FROM " + tables);
		if (condition != null){
			sb.append(" Where " + condition);
		}
		setQuery(sb.toString());
		System.out.println("Executing the query: " + this.getQuery());
		notifyAllObservers();
	}

	

}