import java.util.Scanner;

public class Login 
{
        Scanner input = new Scanner(System.in);
        String username;
        String password;

        public void menu()
        {
		    System.out.println("Welcome to the Online Booking System");
		    System.out.println("------------------------------------");
		    System.out.println("Please Enter your Username");
		    username = input.nextLine();
		
		    System.out.println("Please enter your Password");
		    password = input.nextLine();
		
		    users check = new users(username, password);
		
		    if(check.auth())
		    {
		        System.out.println("You are logged in");
		    }
		    else
		    {
		        System.out.println("Invalid Input");
		    }
		}
}
