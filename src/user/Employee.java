package user;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import booking.Shift;
import owner.Activity;
import util.Util;

public class Employee {
	private String name;
	private String Email;
	private Shift[] roster;
	private Activity[] activities;
	
	public Employee(String Name, String address){
		name = Name;
		Email = address;
	}
	
	public String getName(){
		return name;
	}
	
	public String getEmail(){
		return Email;
	}
	
	public Shift[] getRoster()
	{
		return roster;
	}
	
	public Activity[] getActivities(){
		return activities;
	}
	
	public void loadHours() throws FileNotFoundException{
		//File employeeFile = new File("employees.txt");
		File hoursFile = new File("hours.txt");
		int count = 0;
		Scanner test = new Scanner(hoursFile);
		Scanner scanner = new Scanner(hoursFile);

		while (test.hasNextLine())
		{
			test.nextLine();
			count++;
		}
		test.close();
		
		for (int i = 0; i < count; i++){
			String[] searchString = scanner.nextLine().split(",");
			
			if (searchString[0].equals(name)){
				Shift[] shifts = new Shift[searchString.length - 1];
				for (int x = 1; x < searchString.length; x++){
					//System.out.println(searchString[x]);
					shifts[x-1] = new Shift(searchString[x]);					
				}
				roster = shifts;
			}
			else{
				continue;
			}
	    }
	}
	
	public boolean printHours(){
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd HH:mm");
		SimpleDateFormat endsdf = new SimpleDateFormat(" - HH:mm ");
		System.out.println("Current Roster");
		System.out.println("-------------------------");
		for  (int i = 0; i < roster.length; i++){
			System.out.print(sdf.format(roster[i].getStart()));
			System.out.println(endsdf.format(roster[i].getEnd()));
		}
		System.out.println("-------------------------");
		return false;
	}
	
	public boolean updateRoster(Shift newShift){
		Shift[] newRoster = new Shift[roster.length + 1];
		for (int i = 0; i < roster.length; i++){
			newRoster[i] = roster[i];
		}
		newRoster[roster.length] = newShift;
		roster = newRoster;
		return true;
	}
	
	public boolean loadEmployeeActivities() throws FileNotFoundException{
		File activityFile = new File("employeeSkills.txt");
		Util util = new Util();
		Activity[] allActivities;
		int count = 0;
		Scanner test = new Scanner(activityFile);
		Scanner scanner = new Scanner(activityFile);

		while (test.hasNextLine())
		{
			test.nextLine();
			count++;
		}
		test.close();
		
		for (int i = 0; i < count; i++){
			String[] searchString = scanner.nextLine().split(",");
			
			if (searchString[0].equals(name)){
				Activity[] skills = new Activity[searchString.length - 1];
				for (int x = 1; x < searchString.length; x++){
					//System.out.println(searchString[x]);
					skills[x-1] = new Activity(searchString[x]);					
				}
				activities = skills;
			}
			else{
				continue;
			}
	    }
		
		//Loop through both activity arrays to set activity info correctly
		allActivities = util.loadActivity();
		for (int i = 0; i < activities.length; i++){
			for (int j = 0; j < allActivities.length; j++){
				if (name.equals(allActivities[j].getName())){
					activities[i].setDesc(allActivities[j].getDesc());
					activities[i].setLength(allActivities[j].getLength());
				}
			}
		}
		return false;
	}
}
