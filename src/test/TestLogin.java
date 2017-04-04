package test;
import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import customer.Login;
import owner.Owner;
import user.User;

public class TestLogin {
	User[] users = new User[4];
	Login login = new Login();
	
	@Before 
	public void setup(){
		users[0] = new User("Jack","Moloney");
		users[1] = new User("Mitchell","Sutton");
		users[2] = new User("Samuel","Holland");
		users[3] = new User("Dom","Alvaro");
		login.users = users;
	}
	
	@After
	public void afterTest(){
		login.users = null;	
	}
	
	@Test
	public void usernameNotInSystem() {
		boolean testVariable;
		testVariable = login.searchUser("abc");
		assertFalse(testVariable);
	}
	
	@Test
	public void usernameFoundInSystem(){
		boolean testVariable;
		testVariable = login.searchUser("Jack");
		assertTrue(testVariable);
		
	}
	
	@Test
	public void nullInput(){
		boolean testVariable;
		testVariable = login.searchUser("");
		assertFalse(testVariable);
		
	}
	
	@Test
	public void correctPassword(){
		int testVariable;
		Owner owner = new Owner("Test", "TestPassword", "RMIT", "Homy" ,"10 Address Street", 0123123123);
		testVariable = login.searchPassword("Jack","Moloney", owner);
		assertEquals(testVariable, 0);
		
	}
	
	@Test
	public void incorrectPassword(){
		int testVariable;
		Owner owner = new Owner("Test", "TestPassword", "RMIT", "Homy" ,"10 Address Street", 0123123123);
		testVariable = login.searchPassword("Jack","1234", owner);
		assertNotSame(testVariable, 0);
		
	}
	
	@Test
	public void nullPassword(){
		int testVariable;
		Owner owner = new Owner("Test", "TestPassword", "RMIT", "Homy" ,"10 Address Street", 0123123123);
		testVariable = login.searchPassword("Jack","", owner);
		assertEquals(testVariable, 2);
		
	}

}
