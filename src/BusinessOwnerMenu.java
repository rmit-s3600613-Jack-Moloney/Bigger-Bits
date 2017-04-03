import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BusinessOwnerMenu 
{
	AddEmployee addingEmployee = new AddEmployee();
	Employee[] employees;
	Bookings[] bookings;
	File employeeFile = new File("employees.txt");
	
	
	public boolean businessOwnerMenu() throws FileNotFoundException
	{
		employees = loadEmployees();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the Business Owner Menu");

		boolean loop = true;

		//Loop for if the input is invalid or user wants to do another action
		while(loop)
		{
			System.out.println("--------------------------------");
			System.out.println("Please select one of the following options:");
			System.out.println("1. Add New Employee");
			System.out.println("2. Add Rosters for Employees");
			System.out.println("3. Summary of Bookings");
			System.out.println("4. New Booking");
			System.out.println("5. Workers Availabilty");
			System.out.println("6. Logout");
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
				System.out.println("This is where you will see the add new employees.");
				addingEmployee.addingEmployee();
				break;
			case 2:
				System.out.println("This is where you will see the add roster for employees.");
				addHours();
				break;
			case 3:
				System.out.println("This is where you will see the summary of bookings.");
				break;
			case 4:
				System.out.println("This is where you will do new booking things.");
				break;
			case 5:
				System.out.println("This is where you will see the workers availability.");
				break;
			case 6:
				System.out.println("Returning to main menu");
				loop = false;
				break;
			default:
				System.out.println("Invalid input, please try again.");
				continue;
			}
		}
		return true;
	}
	
	public boolean addHours() throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
		Employee selectedEmployee = null;
		boolean valid = false;
		
		System.out.println("--------------------");
		//Loads employees from Array/File and displays list
		for (int i = 0; i < employees.length; i++){
			System.out.print(i + 1 + ". ");
			System.out.println(employees[i].getName());
		}
		
		int optionNumber = -1;
		while (!valid){
			System.out.println("Please Select An Employee(Number Only):");
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
			else if (optionNumber - 1 > employees.length || optionNumber - 1 < 0){
				System.out.println("Invalid Entry");
			}
			else{
				selectedEmployee = employees[optionNumber - 1];
				System.out.println("You have selected " + selectedEmployee.getName());
				valid = true;
			}
		}
		
		//Displays hour of selected employee
		selectedEmployee.loadHours();
		selectedEmployee.printHours();
		
		System.out.println("Please Enter A Date To Add Roster (Format = dd.m):");
		String selectedDate = null;
		valid = false;
		while (!valid){
			selectedDate = input.nextLine();
			if(checkDate(selectedDate)){
				valid = true;
			}
			else{
				System.out.println("Incorrect Format Used. Please Try Again.");
			}		
		}
		
		System.out.println("Please Enter A Starting Time (Format: h:mm):");
		valid = false;
		String startTime = null;
		while (!valid){
			startTime = input.nextLine();
			if(checkTime(startTime)){
				valid = true;
			}
			else{
				System.out.println("Incorrect Format Used. Please Try Again.");
			}		
		}
		System.out.println("Please Enter A Finishing Time (Format: h:mm):");
		String endTime = null;
		valid = false;
		while (!valid){
			endTime = input.nextLine();
			if(checkTime(endTime)){
				valid = true;
			}
			else{
				System.out.println("Incorrect Format Used. Please Try Again.");
			}		
		}
		String shiftTime = selectedDate;
		shiftTime = shiftTime.concat("." + startTime + ".");
		shiftTime = shiftTime.concat(endTime);
		System.out.println(shiftTime);
		
		Shift newShift = new Shift(shiftTime);
		employees[optionNumber - 1].updateRoster(newShift);
		saveRoster();
		
		return false;
		
	}
	
	public Employee[] loadEmployees() throws FileNotFoundException{
		String[] tokens = new String[2];
		int count = 0;
		String empName;
		String empEmail;

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
	
	public boolean checkDate(String date){
		//Check that input is of format dd.MM or dd.M or d.M etc
		
		return true;
	}
	
	public boolean checkTime(String time){
		//Check that input is of format HH:mm or H:mm
		
		return true;
	}
	
	public void saveRoster(){
		//read every employees hours back into the text file
		
	}
}

