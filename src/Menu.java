import java.io.FileNotFoundException;
import java.util.Scanner;


public class Menu {
	Login login = new Login();
	User user;
	Owner owner;
	User[] users;
	UserIO IO = new UserIO();
	CustomerRegister register = new CustomerRegister();
	public void menu()
	{
		try {
			users = IO.initializeUsers();
			owner = IO.intializeOwners();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		Scanner input = new Scanner(System.in);
		boolean loop = true;

		//Loop for if the input is invalid or user wants to do another action
		while(loop)
		{
			System.out.println("Welcome to Jack's Booking System");
			System.out.println("--------------------------------");
			System.out.println("Please select one of the following options:");
			System.out.println("1.Login");
			System.out.println("2.Customer Registration");
			System.out.println("3.Quit");
			System.out.println("--------------------------------");
			System.out.println("Enter an option: ");
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

				user = login.logInMenu(users);

				if(user == null){
					System.out.println("Log-in failed");
				}
				else{
					System.out.println("THIS IS WHERE WE RUN THE BOOKING STUFF");
				}
				break;
			case 2:
				register.registration();
				try {
					users = IO.initializeUsers();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				System.out.println("Exiting!");
				System.exit(0);
			default:
				System.out.println("Invalid input, please try again.");
				continue;
			}
		}
	}

}
