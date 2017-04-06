package Clase6Hibernate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Clase6Hibernate.Dao.StudentDaoImp;

public class MainClass {
	static StudentDaoImp studentDao = new StudentDaoImp();
	public static void main(String[] args) throws ParseException {
		String inputString = "2017-04-02";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date inputDate = dateFormat.parse(inputString);
        String firstName="Kelsey";
        String lastName="Webster";
        int regNumber=11;
        studentDao.createStudent(firstName, lastName, regNumber, inputDate);
       // studentDao.listStudents();
        
        
	  }
	
}
