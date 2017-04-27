package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import booking.Booking;
import owner.Activity;
import user.Employee;
import user.User;

public class Util {

	public boolean validateCancel(String input){

		if(input.toUpperCase().equals("C")){
			System.out.println("Returning to menu");
			return false;
		}
		else{
			return true;
		}
	}
	public boolean validateComma(String input){

		if(input.indexOf(',') >= 0){
			System.out.println("The character ',' is not allowed, please try again");
			return false;
		}
		else{
			return true;
		}
	}
	
	public Activity[] loadActivity() throws FileNotFoundException{
		String[] tokens = new String[2];
		File activityFile = new File("activities.txt");
		int count = 0;
		String actName;
		String actDesc;
		String actLength;
		int length;

		Scanner test = new Scanner(activityFile);
		Scanner scanner = new Scanner(activityFile);

		while (test.hasNextLine())
		{
			test.nextLine();
			count++;
		}
		test.close();

		Activity[] activities = new Activity[count];

		for (int i = 0; i < count; i++)
		{
			tokens = scanner.nextLine().split("_");
			actName = tokens[0];
			actDesc = tokens[1];
			actLength = tokens[2];
			length = Integer.parseInt(actLength);
			activities[i] = new Activity(actName, actDesc, length);
		}
		scanner.close();

		return activities;
	}
	
	public Booking[] loadBookings() throws FileNotFoundException{
		int count = 0;
		File bookingsFile = new File("bookings.txt");
		
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
	
	public Employee[] loadEmployees() throws FileNotFoundException{
		String[] tokens = new String[2];
		int count = 0;
		String empName;
		String empEmail;
		File employeeFile = new File("employees.txt");

		Scanner test = new Scanner(employeeFile);
		Scanner scanner = new Scanner(employeeFile);

		while (test.hasNextLine())
		{
			test.nextLine();
			count++;
		}
		test.close();

		Employee[] employees = new Employee[count];

		for (int i = 0; i < count; i++)
		{
			tokens = scanner.nextLine().split(",");
			empName = tokens[0];
			empEmail = tokens[1];
			employees[i] = new Employee(empName, empEmail);
		}
		scanner.close();

		return employees;
	}

}
