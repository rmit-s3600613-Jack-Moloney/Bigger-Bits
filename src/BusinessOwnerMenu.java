import java.io.FileNotFoundException;
import java.util.Scanner;

public class BusinessOwnerMenu 
{
	public boolean businessOwnerMenu()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Business Owner Menu");
		System.out.println("--------------------------------");
		System.out.println("Please select one of the following options:");
		System.out.println("1. Add New Employee");
		System.out.println("2. Add Rosters for Employees");
		System.out.println("3. Summary of Bookings");
		System.out.println("4. New Booking");
		System.out.println("5. Workers Availabilty");
		System.out.println("6. Logout");
		System.out.println("--------------------------------");
		System.out.println("Enter an option: ");

		boolean loop = true;

		//Loop for if the input is invalid or user wants to do another action
		while(loop)
		{
			String option = input.nextLine();
			
			int optionNumber;

			try
			{
				optionNumber = Integer.parseInt(option);
			}
			catch(NumberFormatException e)
			{
				optionNumber = 0;
			}
			
			switch(optionNumber)
			{
			case 1:
				System.out.println("This is where you will see the add new employees.");
				businessOwnerMenu();
				break;
			case 2:
				System.out.println("This is where you will see the add roster for employees.");
				businessOwnerMenu();
				break;
			case 3:
				System.out.println("This is where you will see the summary of bookings.");
				businessOwnerMenu();
				break;
			case 4:
				System.out.println("This is where you will do new booking things.");
				businessOwnerMenu();
				break;
			case 5:
				System.out.println("This is where you will see the workers availability.");
				businessOwnerMenu();
				break;
			case 6:
				loop = false;
				break;
			default:
				System.out.println("Invalid input, please try again.");
				continue;
			}
		}
		return true;
	}
}

