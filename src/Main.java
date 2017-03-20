import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Jack's Booking System");
		System.out.println("--------------------------------");
		System.out.println("Please select one of the following options:");
		System.out.println("1.Login");
		System.out.println("2.Customer Registration");
		System.out.println("3.Quit");
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
					Login.logInMenu();
					break;
				case 2:
					CustomerRegister.registration();
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("Invalid input, please try again.");
					continue;
			}
		}
		
	}

}
