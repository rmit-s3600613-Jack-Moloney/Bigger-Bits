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
				/* Runs the log in function */
				user = login.logInMenu(users, owners);
				/*  */
				if(user == null){
					System.out.println("Log-in failed");
				}
				else if (user instanceof Owner){
					ownerMenu.businessOwnerMenu();
				}
				else{
					custMenu.customerMenu();
				}
				break;
			case 2:
				int size = users.length;
				User[] userTemp = users;
				users = new User[size];
				users = userTemp;

				User user = register.registration(users);
				if (user != null){
					users[size-1] = user;
					IO.saveUsers(users);
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
