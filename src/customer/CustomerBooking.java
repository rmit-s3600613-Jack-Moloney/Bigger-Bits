package customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

import booking.Booking;
import owner.Activity;
import user.Employee;
import user.User;
import util.Util;

public class CustomerBooking {
	User user;
	Util util = new Util();
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
		Scanner scanner = new Scanner(System.in);
		
		int activityNum;
		String activitySelect;
		Activity selectedActivity;
		ArrayList<Activity> selectedActivities = new ArrayList<Activity>();
		ArrayList<Activity> allActivities = new ArrayList<Activity>(Arrays.asList(activities));
		
		int employeeNum;
		String employeeSelect;
		ArrayList<Employee> suitableEmp = new ArrayList<Employee>();
		
		System.out.println("Please select the services you would like performed: ");
		boolean loop = true;
		while(loop){
			displayActivities(allActivities);
			activitySelect = scanner.nextLine();
			activityNum = Integer.parseInt(activitySelect);
			if(activityNum == allActivities.size() + 1){
				loop = false;
				break;
			}
			selectedActivity = allActivities.get(activityNum - 1);
			selectedActivities.add(selectedActivity);
			
			for(int i = 0; i < allActivities.size(); i++){
				if(allActivities.get(i) == selectedActivity){
					allActivities.remove(i);
				}
			}
			if(allActivities.size() < 1){
				loop = false;
				break;
			}		
		}

		System.out.println("Please select the employee you would like to use: ");
		//Only display Employees that can perform the desired activity
		boolean found = false;
		for(int i = 0; i < employees.length; i++){
			employees[i].loadEmployeeActivities();
			//Cycle through all selected activities to check that employee can perform all tasks
			for(int j = 0; j < selectedActivities.size(); j++){
				
				for(int k = 0; k < employees[i].getActivities().length; k++){
					if(selectedActivities.get(j) == employees[i].getActivities()[k]){
						found = true;
						break;
					}
					else{
						found = false;
					}
				}
			}
			if(found == true){
				suitableEmp.add(employees[i]);
			}
		}
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
	
	public boolean displayActivities(ArrayList<Activity> currentActs){
		for(int i = 0; i < currentActs.size(); i++){
			System.out.print(i + 1 + ".");
			System.out.println(currentActs.get(i).getName());
		}
		System.out.println(currentActs.size() + 1 + ".Continue");
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
	
	public boolean saveNewBooking(){
		File bookingFile = new File("bookings.txt");
		
		return true;
	}
}
