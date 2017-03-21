import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TestLogin {
	User[] users;
	Login login = new Login();
	
	@Before public void setup(){
		users[1] = new User("Jack","Moloney");
		users[2] = new User("Mitchell","Sutton");
		users[3] = new User("Samuel","Holland");
		users[4] = new User("Dom","Alvaro");
		login.users = users;
	}
	
	@After
	public void afterTest(){
		login.users = null;	
	}
	
	@Test
	public void userNotInSystem() {
		boolean testVariable;
		testVariable = login.searchUser("abc");
		assertFalse(testVariable);
	}
	
	@Test
	public void incorrectPassword(){
		
	}

}
