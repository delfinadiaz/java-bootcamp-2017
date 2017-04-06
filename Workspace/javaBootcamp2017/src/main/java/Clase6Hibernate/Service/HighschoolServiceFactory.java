package Clase6Hibernate.Service;

public class HighschoolServiceFactory {

	public static HighschoolServiceImp getHighschoolService(){  
        return new HighschoolServiceImp ();  
    }  
}
