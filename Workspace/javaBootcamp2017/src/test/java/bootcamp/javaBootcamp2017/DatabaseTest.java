package bootcamp.javaBootcamp2017;

import java.util.logging.Logger;

import junit.framework.TestCase;

public class DatabaseTest extends TestCase {

	public void testDatabase(){
		Database d = new Database("aName", "aUsername", "aPassword");
		Logger l = Logger.getLogger(Database.class.getName());
		  l.info("Name: " + d.getName());
		  l.info("Username:" + d.getUsername());
		  l.info("Password:" + d.getPassword());
		  assertEquals("aName", d.getName());
		  assertEquals("aUsername", d.getUsername());
		  assertEquals("aPassword",d.getPassword());
	}
}
