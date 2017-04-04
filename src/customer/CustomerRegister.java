package customer;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import user.User;

public class CustomerRegister 
{
	public static Scanner scanner = new Scanner(System.in);
	public User[] users;
	public User registration(User[] users)
	{	
		this.users = users;
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
		
		System.out.println("Passwords must be 4-20 characters long and contain both Numbers and Letters");
		
		while(loop)
		{	
			
			System.out.println("Enter your desired password: ");
			
			password = scanner.nextLine();
			
			if(testPassword(password)){
				
			}
			else{
				System.out.println("Password must be 4-20 characters long and contain both Numbers and Letters");
				continue;
			}
			
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
		User newUser = new User(username, password);
		
		return newUser;
		
		}
	
	public boolean checkUsername (String username){
		
		for (int i = 0; i < users.length; i++)
			if (username.equals(users[i].getUsername())){
				System.out.println("Username " +username+ " is already taken, please select another");
				return false;
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
	
	public boolean testPassword(String password){
		boolean hasNumber = false;
		boolean hasLetter = false;
		
		if(password.length() < 4 || password.length() > 20){
			return false;
		}
		
		for(int i = 0; i < password.length(); i++){
			if (Character.isDigit(password.charAt(i))){
				hasNumber = true;
			}
			if (Character.isLetter(password.charAt(i))){
				hasLetter = true;
			}
		}
		if(hasLetter && hasNumber){
			return true;
		}
		else{
			return false;
		}
	}
}
