import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class BusinessOwnerMenu 
{
	AddEmployee addingEmployee = new AddEmployee();
	Employee[] employees;
	Booking[] bookings;
	File employeeFile = new File("employees.txt");
	File bookingsFile = new File("bookings.txt");


	public boolean businessOwnerMenu() throws FileNotFoundException
	{
		employees = loadEmployees();
		bookings = loadBookings();

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
			System.out.println("5. Workers Shifts");
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
				addingEmployee.addingEmployee();
				break;
			case 2:
				addHours();
				break;
			case 3:
				System.out.println("This is where I would put my summary of bookings, if I had any!");
				bookingSummaries();
				break;
			case 4:
				System.out.println("This is where you will do new booking things.");
				break;
			case 5:
				displayShifts();
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

			for (int i = 0; i < employees.length; i ++)
			{
				employees[i].loadHours();
			}

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
		//selectedEmployee.loadHours();
		selectedEmployee.printHours();

		System.out.println("Please Enter A Date To Add Roster (Format = dd.mm):");
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

		System.out.println("Please Enter A Starting Time (Format: hh:mm):");
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
		System.out.println("Please Enter A Finishing Time (Format: hh:mm):");
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
	
	public Booking[] loadBookings() throws FileNotFoundException{
		int count = 0;
		
		Scanner test = new Scanner(bookingsFile);
		Scanner scanner = new Scanner(bookingsFile);
		
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

	public boolean checkDate(String date){
		//Check that input is of format dd.MM or dd.M or d.M etc
		if (!(date.length() == 5))
		{
			return false;
		}
		
		if (!(Character.isDigit(date.charAt(0)) && (Character.isDigit(date.charAt(1)) && (date.charAt(2) == '.') && (Character.isDigit(date.charAt(3))) && (Character.isDigit(date.charAt(4))))))
		{
			return false;
		}
		
		return true;
	}

	public boolean checkTime(String time){
		//Check that input is of format HH:mm or H:mm
		if (!(time.length() == 5))
		{
			return false;
		}
		
		if (!(Character.isDigit(time.charAt(0)) && (Character.isDigit(time.charAt(1)) && (time.charAt(2) == ':') && (Character.isDigit(time.charAt(3)) && (Character.isDigit(time.charAt(4)))))))
		{
			return false;
		}
		
		return true;
	}

	public void saveRoster() throws FileNotFoundException{
		//read every employees hours back into the text file

		File testFile = new File("hours.txt");

		PrintWriter output = new PrintWriter(testFile);


		PrintWriter fw = new PrintWriter(output);			

		for (int i = 0; i < employees.length; i++)
		{
			fw.write(employees[i].getName());
			fw.write(","); 

			for (int j = 0; j < employees[i].getRoster().length; j++)
			{
				Shift[] employeeRoster = employees[i].getRoster();

				Date start = employeeRoster[j].getStart();
				Date end = employeeRoster[j].getEnd();

				output.print(start.getDate() + "." + (start.getMonth()+1) + "." + start.getHours() + ":" + start.getMinutes() + "." + end.getHours() + ":" + end.getMinutes());
				fw.write(",");
			}

			fw.write("\n");
		}
 
		fw.close();
	}

	public void displayShifts()
	{
		for (int i = 0; i < employees.length; i++)
		{
			try {
				employees[i].loadHours();
				System.out.println(employees[i].getName());
				employees[i].printHours();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void bookingSummaries(){
		System.out.println("Current Bookings");
		System.out.println("-------------------------");
		for (int i = 0; i < bookings.length; i++){
			bookings[i].printHours();
		}
	}

}




