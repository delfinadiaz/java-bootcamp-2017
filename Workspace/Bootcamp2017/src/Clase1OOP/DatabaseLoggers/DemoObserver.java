package Clase1OOP.DatabaseLoggers;

public class DemoObserver {
	
	public static void main(String[] args) {
		
	  //Create database and operations
	  Database database = new Database();
	  String columns = "some columns";
	  String tables = "a table";
	  String condition = "a condition";
	  
	  //Create loggers 
	  LoggerObserver logObserver1 = new LoggerObserver(new LoggerEnglish());
	  database.attach(logObserver1);
	  
	  LoggerObserver logObserver2 = new LoggerObserver(new LoggerSpanish());
	  database.attach(logObserver2);
	  
	  
	  //Execute queries
	  database.select(columns, tables, condition);
	  database.update(columns, tables, condition);
	  database.delete(columns, tables, condition);
	  
	  //Change languages
	  logObserver1.setLanguage(new LoggerFrench());
	  logObserver2.setLanguage(new LoggerFrench());
	  
	  //Execute queries again but in French
	  database.select(columns, tables, condition);
	  database.update(columns, tables, condition);
	  database.delete(columns, tables, condition);
	  
	}
}
