package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import customer.CustomerMenu;

public class TestCustomerMenu {
	
	CustomerMenu menu = new CustomerMenu();
	
	@Before
	public void setup(){
		
	}
	
	@After
	public void afterTest(){
		
	}
	
	@Test
	public void correctFormat() {
		boolean testVariable;
		testVariable = menu.testDateInput("12");
		assertTrue(testVariable);
	}
	
	@Test
	public void inputTooShort(){
		boolean testVariable;
		testVariable = menu.testDateInput("");
		assertFalse(testVariable);
	}
	
	@Test
	public void inputTooLong(){
		boolean testVariable;
		testVariable = menu.testDateInput("123");
		assertFalse(testVariable);
	}
	
	@Test
	public void inputAboveRange(){
		boolean testVariable;
		testVariable = menu.testDateInput("32");
		assertFalse(testVariable);
	}
	
	@Test
	public void inputBelowRange(){
		boolean testVariable;
		testVariable = menu.testDateInput("0");
		assertFalse(testVariable);
	}
	
	@Test
	public void inputNotNumber(){
		boolean testVariable;
		testVariable = menu.testDateInput("ab");
		assertFalse(testVariable);
	}

}
