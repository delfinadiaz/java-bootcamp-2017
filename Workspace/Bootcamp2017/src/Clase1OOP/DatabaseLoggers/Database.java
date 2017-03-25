package Clase1OOP.DatabaseLoggers;

public class Database {
	
	public void executeQuery(DBOperation anOperation, String columns, String tables, String condition){
		anOperation.doQuery(columns,tables,condition);
	}
	
}
