package Clase1OOP.DatabaseLoggers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {
	
	private String query;
	private List<LoggerObserver> observers = new ArrayList<LoggerObserver>();
	 
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	public void attach(LoggerObserver loggerObserver){
	      observers.add(loggerObserver);		
	   }
	
	public void detach(LoggerObserver loggerObserver){
	      observers.remove(loggerObserver);		
	   }
	public void doNotify(){
	    Iterator<LoggerObserver> it = observers.iterator();
		while (it.hasNext()) {
			LoggerObserver loggerObserver = it.next();
			loggerObserver.log(query);
		}
	   } 
	
	void select(String columns, String tables, String condition) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Select " + columns + " FROM " + tables);
		if (condition != null){
			sb.append(" Where " + condition);
		}
		setQuery(sb.toString());
		System.out.println("Executing the query: " + this.getQuery());
		doNotify();
	}
	
	void delete(String columns, String table, String condition) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM " + table);
		if (condition != null){
			sb.append(" Where " + condition);
		}
		setQuery(sb.toString());
		System.out.println("Executing the query: " + this.getQuery());
		doNotify();
	}
	
	void update(String columns, String tables, String condition) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE " + tables + " SET " + columns);
		if (condition != null){
			sb.append(" Where " + condition);
		}
		setQuery(sb.toString());
		System.out.println("Executing the query: " + this.getQuery());
		doNotify();
	}
	
}
