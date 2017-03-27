package Clase1OOP.DatabaseLoggers;

import java.util.Locale;
//This class represents the ConcreteState class from the State Pattern and the ConcreteClass from the Template Method Pattern
public class LoggerSpanish extends LoggerLanguage {

	@Override
	void setLanguage() {
		Locale.setDefault(new Locale("ES"));
	}

}
