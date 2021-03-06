package Clase1OOP.DatabaseLoggers;

import java.util.logging.Level;
import java.util.logging.Logger;

//This class represents the State class from the State Pattern and the AbstractClass from the Template Method Pattern
public abstract class LoggerLanguage {
	private Logger logger;
	
	public LoggerLanguage(){
		logger = Logger.getLogger(LoggerObserver.class.getName());
	}
	abstract void setLanguage();
	
	void executeLog(String aQuery){
		logger.log(Level.INFO, aQuery);	
	}
	void log(String aQuery){
		setLanguage();
		executeLog(aQuery);
	}
}
