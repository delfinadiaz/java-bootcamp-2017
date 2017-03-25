package Clase1OOP.DatabaseLoggers;

import java.util.Calendar;

//This class represents the Observer class from the Observer Pattern and the Context class from the Strategy Pattern
public class LoggerObserver {
	LoggerLanguage language;
	
	public LoggerObserver() {
	}

	public void observe(DBOperation aDBOperation){
		aDBOperation.attach(this);
	}

	public void doUpdate(String query) {

		Calendar currentDate = Calendar.getInstance();
		int currentHour = currentDate.get(Calendar.HOUR);
	    if (currentHour < 12) {
			language = new LoggerEnglish();
			language.logQuery(query);
		}
		else if (currentHour > 12 && currentHour < 21){
			language = new LoggerSpanish();
			language.logQuery(query);
		}
		else {
			language = new LoggerFrench();
			language.logQuery(query);
		}
		
	}


	
}
