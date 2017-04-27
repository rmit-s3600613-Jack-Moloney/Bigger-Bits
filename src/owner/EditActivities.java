package owner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;

public class EditActivities {
	Activity[] activities;
	File activityFile = new File("activities.txt");
	
	public boolean UpdateActivities() throws IOException{
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
	
	public boolean editActivity() throws IOException{
		Activity selectedActivity = null;
		int optionNumber = 0;
		boolean valid = false;
		String option;
		Scanner input = new Scanner(System.in);
		displayActivities();
				
		while(!valid){
			System.out.println("Select The Activity You Would Like To Edit:");
			option = input.nextLine();
			
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
				valid = true;
			}
		}
		
		
		valid = false;
		while(!valid){
			String editOption;
			int editNumber;
			
			selectedActivity = activities[optionNumber - 1];
			System.out.println("------------------------------------");
			System.out.print("1. Name: ");
			System.out.println(selectedActivity.getName());
			System.out.print("2. Description: ");
			System.out.println(selectedActivity.getDesc());
			System.out.print("3. Length: ");
			System.out.print(selectedActivity.getLength());
			System.out.println(" Minutes");
			System.out.println("4. Exit");
			System.out.println("------------------------------------");
			
			System.out.println("Select the attribute you would like to edit (1-3)");
			editOption = input.nextLine();
			try
			{
				editNumber = Integer.parseInt(editOption);
			}
			catch(NumberFormatException e)
			{
				editNumber = 0;
			}
			
			switch(editNumber){
			case 1:
				String newName;
				System.out.println("Current Name: " + selectedActivity.getName());
				System.out.println("Please enter a new name: ");
				newName = input.nextLine();
				activities[optionNumber - 1].setName(newName);
				saveActivity();
				break;
			case 2:
				String newDesc;
				System.out.println("Current Description: " + selectedActivity.getDesc());
				System.out.println("Please enter a new description: ");
				newDesc = input.nextLine();
				activities[optionNumber - 1].setDesc(newDesc);
				saveActivity();
				break;
			case 3:
				String newLength;
				System.out.println("Current Length: " + selectedActivity.getLength());
				System.out.println("Please enter a new length(Multiples of 30 only): ");
				newLength = input.nextLine();
				activities[optionNumber - 1].setLength(Integer.parseInt(newLength));
				saveActivity();
				break;
			case 4:
				valid = true;
				break;
			default:
				System.out.println("Invalid Input");
			}
		}
	
		return true;
	}
	
	public boolean saveActivity() throws IOException{
		
		PrintWriter fw = new PrintWriter(activityFile);
		for (int i = 0; i < activities.length; i++){
			fw.write(activities[i].getName());
			fw.write("_");
			fw.write(activities[i].getDesc());
			fw.write("_");
			fw.print(activities[i].getLength());
			System.out.println("Writing!");
			System.out.println(activities[i].getLength());
			/* Important to add a new line character at the end */
			fw.write('\n');
			System.out.println(i);
		}
		fw.close();
		return true;
	}
}
