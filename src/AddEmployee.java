import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AddEmployee {
	public static Scanner scanner = new Scanner(System.in);

	public boolean addingEmployee()
	{
		boolean loop = true;
		
		String name = null;
		String email = null;
		
		System.out.println("Please Enter Name ");
		
		boolean valid = false;
		
		while(valid == false){
			name = scanner.nextLine();
			valid = checkName(name);
		}
		
		
		
		System.out.println("Please Enter an Email Address");
			
		email = scanner.nextLine();
		
		
		String filename = "employees.txt";
		FileWriter fw;
		
		try
		{
			fw = new FileWriter(filename,true);
			   
			fw.write(name);
			fw.write(",");
			fw.write(email);
			
			fw.write('\n');
			fw.close();
			System.out.println("Employee Added!");
			System.out.println("\n");
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
	
	
	String filename2 = "hours.txt";
	FileWriter fw2;
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
			e.printStackTrace();
		}
		return true;
	
	}
	
	
	public boolean checkName ( String name){
		try{
			File file = new File("employees.txt");
			
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine())
			{
				String lineFromFile = scanner.nextLine();
				if(lineFromFile.contains(name))
				{
					System.out.println("Name " +name+ " already exists in employee database");
					return false;
				}
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return true;
	}
}
