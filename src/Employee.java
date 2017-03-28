import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Employee {
	private String name;
	private String Email;
	private Shift[] roster;
	
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
				for (int x = 1; x < searchString.length; x++){
					System.out.println(searchString[x]);
					Shift[] shifts = new Shift[searchString.length - 1];
					
				}
			}
			else{
				continue;
			}
	    }
	}
	

}
