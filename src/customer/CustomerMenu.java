package customer;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import booking.Booking;

public class CustomerMenu 
{
	Booking[] bookings;
	File bookingsFile = new File("bookings.txt");
	public String[] times = new String[16];

	public boolean customerMenu() throws FileNotFoundException
	{
		bookings = loadBookings();

		Scanner input = new Scanner(System.in);

		String option = null;
		boolean loop = true;
		
		System.out.println("Welcome to the Customer Menu");
		System.out.println("--------------------------------");
		
		while(loop)
		{

			System.out.println("Please select one of the following options:");
			System.out.println("1. Display Booking Times");
			System.out.println("2. Return to Menu");
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
	
	/* Loads all bookings in the file into an array */
	public Booking[] loadBookings() throws FileNotFoundException{
		int count = 0;

		Scanner test = new Scanner(bookingsFile);
		Scanner scanner = new Scanner(bookingsFile);
		
		/* Checks how many lines are in the file so the array length can be defined */
		while (test.hasNextLine())
		{
			test.nextLine();
			count++;
		}
		test.close();

		Booking[] bookings = new Booking[count];

		for (int i = 0; i < count; i++){
			bookings[i] = new Booking(scanner.nextLine());
		}
		return bookings;
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
