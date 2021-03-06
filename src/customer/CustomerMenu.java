package customer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import booking.Booking;
import user.User;
import util.Util;

public class CustomerMenu 
{
	User currentUser;
	Booking[] bookings;
	File bookingsFile = new File("bookings.txt");
	String[] times = new String[16];
	Util util = new Util();
	
	
	public CustomerMenu(User user){
		currentUser = user;
	}
	
	public boolean customerMenu() throws FileNotFoundException
	{
		bookings = util.loadBookings();

		Scanner input = new Scanner(System.in);

		String option = null;
		boolean loop = true;
		
		System.out.println("Welcome to the Customer Menu");
		System.out.println("--------------------------------");
		
		/*Loads the menu, allows logging out to the main menu*/
		while(loop)
		{

			System.out.println("Please select one of the following options:");
			System.out.println("1. Display Available Times");
			System.out.println("2. Make Booking!");
			System.out.println("3. Return to Menu");
			System.out.println("--------------------------------");
			System.out.println("Enter an option: ");
			
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
				displayTimes();
				break;
			case 2:
				System.out.println("Make Booking!");
				CustomerBooking book = new CustomerBooking(currentUser);
				book.makeBooking();
				break;
			case 3:
				loop = false;
				break;
			default:
				System.out.println("Invalid input, please try again.");
				continue;
			}
		}
		return true;
	}

	/*Allows user to enter a date and shows all bookings on that date */
	public void displayTimes()
	{
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int dayNumber = 0;
		
		System.out.println("Enter the day you are interested in. Eg. If you want the 20/4 just enter '20'.");
		while (!valid){
			
			String day = input.nextLine();
			if (testDateInput(day)){
				valid = true;
			}
			else{
				System.out.println("Invalid Input.Please try again");
			}

			try
			{
				dayNumber = Integer.parseInt(day);
			}
			catch(NumberFormatException e)
			{
				dayNumber = 0;
			}
		}
		System.out.println("-------------------------");
		System.out.println("Available times on " + dayNumber + "/4");
		System.out.println("-------------------------");
		
		for(int i = 0; i < bookings.length; i++)
		{
			if(bookings[i].getStart().getDate() == dayNumber)
			{
				times[bookings[i].getStart().getHours()] = "1";
			}
			
			else
			{
				times[bookings[i].getStart().getHours()] = "0";
			}
		}

		for(int i = 9; i < 16; i++)
		{
			if(times[i] == "1")
			{
				System.out.println(i + ":00: Taken");
			}

			else
			{
				System.out.println(i + ":00:");
			}
		}
		System.out.println("-------------------------");
	}
	
	/* Test the date input by the user to ensure it is correct*/
	public boolean testDateInput(String date){
		/* Checks that all characters are digits */
		for (int i = 0; i < date.length(); i++){
			if(!Character.isDigit(date.charAt(i))){
				return false;
			}
		}
		
		/* Checks that the input is one or two digits long */
		if (date.length() > 2 || date.length() < 1){
			return false;
		}
		
		/* Checks that the input is within the acceptable range for a date */
		else if (Integer.parseInt(date) > 31 || Integer.parseInt(date) < 1){
			return false;
		}
		return true;
	}
	
}
