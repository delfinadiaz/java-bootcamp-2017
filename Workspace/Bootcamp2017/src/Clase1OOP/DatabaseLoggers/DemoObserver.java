package Clase1OOP.DatabaseLoggers;

public class DemoObserver {
	
	public static void main(String[] args) {
		
	  //Create database and operations
	  Database database = new Database();
	  DBOperation select = new Select();
	  DBOperation update = new Update();
	  DBOperation delete = new Delete();
	  String columns = "some columns";
	  String tables = "a table";
	  String condition = "a condition";
	  
	  //Create loggers 
	  LoggerObserver logObserver1 = new LoggerObserver();
	  logObserver1.observe(select);
	  logObserver1.observe(update);
	  logObserver1.observe(delete);
	  LoggerObserver logObserver2 = new LoggerObserver();
	  logObserver2.observe(select);
	  logObserver2.observe(update);
	  logObserver2.observe(delete);
	  
	  //Execute queries
	  database.executeQuery(select,columns, tables, condition);
	  database.executeQuery(update,columns, tables, condition);
	  database.executeQuery(delete,columns, tables, condition);
	  
	}
}
