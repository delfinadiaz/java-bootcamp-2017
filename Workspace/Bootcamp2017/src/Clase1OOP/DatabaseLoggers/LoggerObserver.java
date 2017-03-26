package Clase1OOP.DatabaseLoggers;


//This class represents the Observer class from the Observer Pattern and the Context class from the State Pattern
public class LoggerObserver {
	
	LoggerLanguage language;
	
	public LoggerObserver(LoggerLanguage language) {
		this.language = language;
	}
	
	public void setLanguage(LoggerLanguage language){
		this.language = language;
	}

	public void log(String query) {
			language.log(query);	
	}
	
}
