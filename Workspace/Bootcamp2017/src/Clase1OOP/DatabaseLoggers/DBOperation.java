package Clase1OOP.DatabaseLoggers;
import java.util.ArrayList;
import java.util.List;

public abstract class DBOperation {
	
	private String query;
	private List<LoggerObserver> observers = new ArrayList<LoggerObserver>();
	 
    abstract void doQuery(String columns, String tables, String condition);
    
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public void attach(LoggerObserver loggerObserver){
	      observers.add(loggerObserver);		
	   }

	public void notifyAllObservers(){
	      for (LoggerObserver observer : observers) {
	         observer.update();
	      }
	   } 
}
