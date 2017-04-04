package main;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.*;

import customer.CustomerMenu;
import customer.CustomerRegister;
import customer.Login;
import owner.BusinessOwnerMenu;
import owner.Owner;
import user.User;
import user.UserIO;


public class Menu {
	private static final Logger logger = Logger.getLogger(Menu.class.getName());
	Login login = new Login();
	User user;
	Owner owners;
	User[] users;
	UserIO IO = new UserIO();
	CustomerRegister register = new CustomerRegister();
	CustomerMenu custMenu = new CustomerMenu();
	BusinessOwnerMenu ownerMenu = new BusinessOwnerMenu();

	public void menu() throws FileNotFoundException
	{


		/* Imports the owner and users into the system */
		logger.fine("Attempting to open the files and import data");
		try {
			users = IO.initializeUsers();
			owners = IO.intializeOwners();
		} catch (FileNotFoundException e) {
			logger.log(Level.WARNING, "Trouble opening files", e);
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
			System.out.println("At any time, enter 'c' to cancel");
			String option = input.nextLine();

			/* Makes sure the input is a correct integer */
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
				/* Runs the log in function */
				user = login.logInMenu(users, owners);
				/* If no user is returned, then the log-in failed */
				if(user == null){
					System.out.println("Log-in failed");
				}
				/* If the user was an owner, then send to owner menu */
				else if (user instanceof Owner){
					ownerMenu.businessOwnerMenu();
				}
				/* If the user was a customer, send to the customer menu */
				else{
					custMenu.customerMenu();
				}
				break;
			case 2:
				int size = users.length;
				/* Creates a new user from the returned user from the register function */
				User user = register.registration(users);

				/* If the user was not returned as null, then save the users */
				if (user == null){
					break;
				}
				/* Create a temporary user array to hold the current */
				User[] userTemp = users;
				/* Makes the old array 1 size bigger */
				users = new User[size+1];
				/* Repopulate the original elements held in temp back into "users" */
				for(int i = 0; i < userTemp.length; ++i) {
					users[i] = userTemp[i];
				}
				/* Sets the last item in array as the new user, then saves to file */
				users[size] = user;
				IO.saveUsers(users);
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
