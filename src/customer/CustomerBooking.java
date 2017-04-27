package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import booking.Booking;
import owner.Activity;
import user.Employee;
import user.User;
import util.Util;

public class CustomerBooking {
	User user;
	Util util;
	Activity[] activities;
	Employee[] employees;
	Booking[] bookings;
	
	public CustomerBooking(User currentUser){
		user = currentUser;
	}
	
	public boolean makeBooking() throws FileNotFoundException{
		activities = util.loadActivity();
		employees = util.loadEmployees();
		bookings = util.loadBookings();
		
		System.out.println("Please select the services you would like performed: ");
		displayActivities();
		
		System.out.println("Please select the employee you would like to use: ");
		//Only display Employees that can perform the desired activity
		displayEmployees();
		
		System.out.println("Please select your preferred date: ");
		//Only display dates that selected employee is working
		displayDates();
		
		System.out.println("Please select your preferred time: ");
		//Only display times that selected employee is working
		//Check if selected activities fit for selected time
		displayTimes();
		
		return true;
	}
	
	public boolean displayActivities(){
		for(int i = 0; i < activities.length; i++){
			System.out.print(i + 1 + ".");
			System.out.println(activities[i].getName());
		}
		return true;
	}
	
	public boolean displayEmployees(){
		for (int i = 0; i < employees.length; i++){
			System.out.print(i + 1 + ". ");
			System.out.println(employees[i].getName());
		}
		return true;
	}
	
	public boolean displayDates(){
		
		return true;
	}
	
	public boolean displayTimes(){
		
		return true;
	}
}
