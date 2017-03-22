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
}
