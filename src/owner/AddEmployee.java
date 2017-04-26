package owner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
import java.util.regex.Pattern;

import user.Employee;
import util.Util;

public class AddEmployee {
	public static Scanner scanner = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger(AddEmployee.class.getName());
	Employee[] employees;
	public boolean addingEmployee(Employee[] employees)
	{
		this.employees = employees;
		Util util = new Util();
		boolean loop = true;

		String name = null;
		String email = null;

		System.out.println("Please Enter Name ");

		boolean valid = false;

		/* Loop which constantly reads input until a valid name is entered. */
		while(valid == false){
			name = scanner.nextLine();
			if(util.validateComma(name) == false){
				continue;
			}
			valid = checkName(name);

		}

		valid = false;
		System.out.println("Please Enter an Email Address");
		while(valid == false){
			email = scanner.nextLine();
			if(util.validateComma(email) == true){
				valid = true;
			}
		}

		String filename = "employees.txt";
		FileWriter fw;

		/* Filewriter saves the name and email to a text file */
		logger.fine("Attempting to write to file");
		try
		{
			fw = new FileWriter(filename,true);

			fw.write(name);
			fw.write(",");
			fw.write(email);
			/* Important to add a new line character at the end */
			fw.write('\n');
			fw.close();
			System.out.println("Employee Added!");
			System.out.println("\n");
		} 

		catch (IOException e) 
		{
			logger.log(Level.WARNING, "Unable to save to file", e);
		} 



		String filename2 = "hours.txt";
		FileWriter fw2;
		/* Filewriter saves the name and hours to a textfile */
		logger.fine("Attempting to write to file");

		try
		{
			fw2 = new FileWriter(filename2,true);

			fw2.write(name);
			fw2.write(",");

			fw2.write('\n');
			fw2.close();
		} 

		catch (IOException e) 
		{
			logger.log(Level.WARNING, "Unable to save to file", e);
		}
		return true;

	}

	/* Check name functions makes sure the name does not already exist within the text file */
	public boolean checkName ( String name){
		
		for (int i = 0; i < employees.length; i++)
			if (name.equals(employees[i].getName())){
				System.out.println("Username " +name+ " is already taken, please select another (Enter 'C' to cancel)");
				return false;
			}
		return true;
	}
	/*
	public boolean checkEmail(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		java.util.regex.Matcher matcher = pattern.matcher(email);
		System.out.println(matcher.matches());
		return matcher.matches();
	}
	 */
}
