package Clase1OOP.DatabaseLoggers;

import java.util.Locale;
//This class represents the ConcreteStrategy class from the Strategy Pattern and the ConcreteClass from the Template Method Pattern
public class LoggerEnglish extends LoggerLanguage {

	@Override
	void setLanguage() {
		Locale.setDefault(Locale.ENGLISH);
	}

}
