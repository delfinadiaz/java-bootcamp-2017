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
	  LoggerObserver logObserver1 = new LoggerObserver(new LoggerEnglish());
	  select.attach(logObserver1);
	  update.attach(logObserver1);
	  delete.attach(logObserver1);
	  
	  LoggerObserver logObserver2 = new LoggerObserver(new LoggerSpanish());
	  select.attach(logObserver2);
	  update.attach(logObserver2);
	  delete.attach(logObserver2);
	  
	  
	  //Execute queries
	  database.executeQuery(select,columns, tables, condition);
	  database.executeQuery(update,columns, tables, condition);
	  database.executeQuery(delete,columns, tables, condition);
	  
	  //Change languages
	  logObserver1.setLanguage(new LoggerFrench());
	  logObserver2.setLanguage(new LoggerFrench());
	  
	  //Execute queries again but in French
	  database.executeQuery(select,columns, tables, condition);
	  database.executeQuery(update,columns, tables, condition);
	  database.executeQuery(delete,columns, tables, condition);
	  
	}
}
