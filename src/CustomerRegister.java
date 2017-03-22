import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CustomerRegister 
{
	public static Scanner scanner = new Scanner(System.in);
	
	public boolean registration()
	{	
		boolean loop = true;
		
		String username = null;
		String password = null;
		String checkPassword = null;

		System.out.println("Enter your desired username: ");
		
		boolean valid = false; 
		
		
		while(valid == false)
		{
			username = scanner.nextLine();
			valid = checkUsername(username);
		}
		
		while(loop)
		{	
			System.out.println("Enter your desired password: ");
			
			password = scanner.nextLine();
			
			System.out.println("Confirm Password: ");
			
			checkPassword = scanner.nextLine();
			
			if(password.equals(checkPassword))
			{
				System.out.println("Passwords match!");
				loop = false;
			}
			else
			{
				System.out.print("Passwords do not match, please try again.");
				System.out.print("\n");
			}
		}
		
		String filename= "users.txt";
		FileWriter fw;
		
		try 
		{
			fw = new FileWriter(filename,true);
		   
			fw.write(username);
			fw.write(",");
			fw.write(password); 
			
			fw.write('\n');
			fw.close();
			System.out.println("User registered!");
			System.out.println("\n");
		} 
		
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		return true;
		
		}
	
	public boolean checkUsername (String username){
		try
		{
			File file = new File("users.txt");
		
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) 
			{
				String lineFromFile = scanner.nextLine();
				if(lineFromFile.contains(username)) 
				{ 
					System.out.println("Username " +username+ " is already taken, please select another");
					return false;
				}
			}

		}
		
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean matchPassword (String password1, String password2){
		if (password1.equals(password2)){
			return true;
		}
		else{
			return false;
		}
	}
}
