package owner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class EditActivities {
	Activity[] activities;
	File activityFile = new File("activities.txt");
	
	public boolean UpdateActivities() throws FileNotFoundException{
		boolean valid = false;
		System.out.println("1. Add New Activity");
		System.out.println("2. Edit Activities");
		System.out.println("3. Exit");
		
		int optionNumber = -1;
		while (!valid){
			activities = loadActivities();
			Scanner input = new Scanner(System.in);
			System.out.println("Select An Option:");
			String option = input.nextLine();

			try
			{
				optionNumber = Integer.parseInt(option);
			}
			catch(NumberFormatException e)
			{
				optionNumber = 0;
			}
			
			switch(optionNumber){
			case 1:
				System.out.println("Add New Activity");
				addActivity();
				break;
			case 2:
				System.out.println("Edit Activities");
				editActivity();
				break;
			case 3:
				valid = true;
				break;
			default:
				System.out.println("Invalid Input!");
				break;
			}
		}
		
		return true;
	}
	
	public Activity[] loadActivities() throws FileNotFoundException{
		String[] tokens = new String[2];
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
	
	public void displayActivities(){
		for(int i = 0; i < activities.length; i++){
			System.out.print(i + 1 + ".");
			System.out.println(activities[i].getName());
		}
	}
	
	public boolean addActivity(){
		String newName;
		String newDesc;
		String newLength;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the name of the new activity");
		newName = scan.nextLine();
		
		System.out.println("Please enter a description of the new activity");
		newDesc = scan.nextLine();
		
		System.out.println("Please enter the length of the new activity(Must be a multiple of 30)");
		newLength = scan.nextLine();
		
		//Activity newActivity = new Activity(newName, newDesc, Integer.parseInt(newLength));
		
		try
		{
			FileWriter fw = new FileWriter(activityFile,true);

			fw.write(newName);
			fw.write("_");
			fw.write(newDesc);
			fw.write("_");
			fw.write(newLength);
			/* Important to add a new line character at the end */
			fw.write('\n');
			fw.close();
			System.out.println("Activity Added!");
		} 
		catch (IOException e) 
		{
			System.out.println("No File!");
		} 
		return true;
	}
	
	public boolean editActivity(){
		Activity selectedActivity;
		int optionNumber;
		boolean valid = false;
		Scanner input = new Scanner(System.in);
		displayActivities();
		
		
		while(!valid){
			System.out.println("Select The Activity You Would Like To Edit:");
			String option = input.nextLine();
			
			try
			{
				optionNumber = Integer.parseInt(option);
			}
			catch(NumberFormatException e)
			{
				optionNumber = 0;
			}

			if (optionNumber == 0){
				System.out.println("Invalid Entry");
			}
			else if (optionNumber - 1 > activities.length || optionNumber - 1 < 0){
				System.out.println("Invalid Entry");
			}
			else{
				selectedActivity = activities[optionNumber - 1];
				System.out.println("You have selected " + selectedActivity.getName());
				valid = true;
			}
		}
		return true;
	}
}
