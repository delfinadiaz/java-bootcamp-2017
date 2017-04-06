package Clase6Hibernate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Clase6Hibernate.Service.HighschoolServiceFactory;
import Clase6Hibernate.Service.HighschoolServiceImp;


public class MainClass {
	 
	
	public static void main(String[] args) throws ParseException {
	    HighschoolServiceImp highschool = HighschoolServiceFactory.getHighschoolService();
	    
		String inputString = "2017-04-02";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date inputDate = dateFormat.parse(inputString);
        String firstName="Kelsey";
        String lastName="Webster";
        int regNumber=11;
        int idnewstudent = highschool.createStudent(firstName, lastName, regNumber, inputDate);
        
        String inputString2 = "2017-04-02";
        Date inputDate2 = dateFormat.parse(inputString2);
        String firstName2="Tom";
        String lastName2="Fletcher";
        
        int idstudent = highschool.getIdStudent(firstName2,lastName2,inputDate2);
        
        highschool.getStudent(idstudent);
        
        highschool.listStudents();
        highschool.updateFirstNameStudent(6, "Nathan");
        
        highschool.deleteStudent(idnewstudent);
        
        highschool.shutdown();
  
	  }
	
}
