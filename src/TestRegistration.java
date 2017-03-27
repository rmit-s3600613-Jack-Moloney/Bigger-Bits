import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRegistration {
	CustomerRegister register = new CustomerRegister();
	
	@Before
	public void setup(){
		
	}
	
	@After
	public void afterTest(){
		
		
	}
	
	@Test
	public void usernameAlreadyTaken() {
		boolean testVariable;
		testVariable = register.checkUsername("Jack");
		assertFalse(testVariable);
	}
	
	@Test
	public void usernameNotTaken(){
		boolean testVariable;
		testVariable = register.checkUsername("Test Username");
		assertTrue(testVariable);
	}
	
	@Test
	public void passwordsDontMatch(){
		boolean testVariable;
		testVariable = register.matchPassword("1234","wasd");
		assertFalse(testVariable);
	}
	
	@Test
	public void passwordsMatch(){
		boolean testVariable;
		testVariable = register.matchPassword("1234","1234");
		assertTrue(testVariable);
	}
	
	@Test
	public void passwordTooShort(){
		boolean testVariable;
		testVariable = register.testPassword("ab1");
		assertFalse(testVariable);
	}
	
	@Test
	public void passwordTooLong(){
		boolean testVariable;
		testVariable = register.testPassword("wasd1234wasd1234wasd1");
		assertFalse(testVariable);
	}
	
	@Test
	public void passwordNoLetters(){
		boolean testVariable;
		testVariable = register.testPassword("12345");
		assertFalse(testVariable);
	}
	
	@Test
	public void passwordNoNumbers(){
		boolean testVariable;
		testVariable = register.testPassword("abcde");
		assertFalse(testVariable);
	}
}
