import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBusinessOwnerMenu 
{	
	BusinessOwnerMenu addHours = new BusinessOwnerMenu();

	@Before
	public void setup(){

	}

	@After
	public void afterTest(){

	}
	
	@Test
	public void incorrectDateFormat()
	{
		boolean testVariable;
		testVariable = addHours.checkDate("1,3");
		assertFalse(testVariable);
	}
	
	@Test
	public void correctDateFormat()
	{
		boolean testVariable;
		testVariable = addHours.checkDate("20.02");
		assertTrue(testVariable);
	}
	@Test
	public void incorrectTimeFormat()
	{
		boolean testVariable;
		testVariable = addHours.checkTime("100:2");
		assertFalse(testVariable);
	}
	
	@Test
	public void correctTimeFormat()
	{
		boolean testVariable;
		testVariable = addHours.checkTime("01:30");
		assertTrue(testVariable);
	}
}
