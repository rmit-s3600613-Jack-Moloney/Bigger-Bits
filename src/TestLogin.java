import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLogin {
	
	@Before
	public void setup(){
		
	}
	
	@After
	public void afterTest(){
		
		
	}
	
	@Test
	public void userNotInSystem() {
		
		searchUser("abc");
		assertFalse();
	}
	
	@Test
	public void incorrectPassword(){
		
	}

}
