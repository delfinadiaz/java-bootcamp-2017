package Clase1OOP.DatabaseLoggers;

//This class represents the ConcreteSubject from the Observer Pattern
public class Delete extends DBOperation {

	@Override
	void doQuery(String columns, String table, String condition) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM " + table);
		if (condition != null){
			sb.append(" Where " + condition);
		}
		setQuery(sb.toString());
		System.out.println("Executing the query: " + this.getQuery());
		doNotify();
	}

}
