package Clase1OOP.DatabaseLoggers;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerObserver {
	private Logger logger;
	private DBOperation subject;
	
	public LoggerObserver() {
		logger = Logger.getLogger(LoggerObserver.class.getName());
	}

	public void observe(DBOperation aDBOperation){
		aDBOperation.attach(this);
		setSubject(aDBOperation);
	}
	
	public void update(){
		String aQuery = subject.getQuery();
		logger.log(Level.INFO, aQuery);
	}

	public DBOperation getSubject() {
		return subject;
	}

	public void setSubject(DBOperation subject) {
		this.subject = subject;
	}
}
