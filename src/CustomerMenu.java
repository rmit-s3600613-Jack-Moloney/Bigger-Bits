import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomerMenu 
{
	public boolean customerMenu()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Customer Menu");
		System.out.println("--------------------------------");
		System.out.println("Please select one of the following options:");
		System.out.println("1. Display Booking Times");
		System.out.println("2. Return to Menu");
		System.out.println("--------------------------------");
		System.out.println("Enter an option: ");

		String option = null;
		boolean loop = true;

		//Loop for if the input is invalid or user wants to do another action
		while(loop)
		{
		
			option = input.nextLine();
			
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
				System.out.println("This is where you will see the available times etc.");
				System.out.println("Type 2 to log out");
				break;
			case 2:
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

