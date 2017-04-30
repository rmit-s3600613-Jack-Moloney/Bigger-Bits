package main;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main 

  {	
	/* Throws file not found exception as the class it goes to opens multiple files */
	  public static void main(String[] args) throws IOException{
		  Menu menu = new Menu();
		  /* Runs the menu function */
		  menu.menu();
  }

}
