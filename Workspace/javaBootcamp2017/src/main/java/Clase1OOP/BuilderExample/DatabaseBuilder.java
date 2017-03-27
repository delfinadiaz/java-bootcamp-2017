package Clase1OOP.BuilderExample;

public interface DatabaseBuilder {
	public void buildHostName();
	public void buildDBName();	
	public void buildUsername();
	public void buildPassword();
	public void buildDBDriver();
	
	public Database getDatabase();
}
