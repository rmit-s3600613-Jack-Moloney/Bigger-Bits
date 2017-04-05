package customer;
import java.util.Scanner;

import util.Util;
import user.User;

public class CustomerRegister 
{
	public static Scanner scanner = new Scanner(System.in);
	public User[] users;
	public Util util = new Util();
	public User registration(User[] users)
	{	
		this.users = users;
		boolean loop = true;

		String name = null;
		String username = null;
		String password = null;
		String checkPassword = null;
		String address = null;
		String contact = null;
		boolean valid = false;

		System.out.println("Enter your full name ");
		
		while(valid == false){
			name = scanner.nextLine();
			if(util.validateCancel(name) == false){
				return null;
			}
			else if(util.validateComma(name) == false);
			else{
				valid = true;
			}
		}

		System.out.println("Enter your desired username (must be between 4-20 characters): ");
		/*Customer enters their preferred username, if not available or incorrect format asks again*/
		valid = false;
		while(valid == false)
		{
			username = scanner.nextLine();
			if(util.validateCancel(username) == false){
				return null;
			}
			else if(util.validateComma(username) == false);
			else if(username.length() < 4 || username.length() > 20){
				System.out.println("Username must be between 4-20 characters long (Enter 'C' to cancel)");
			} 
			else{
				valid = checkUsername(username);
			}

		}

		System.out.println("Passwords must be 4-20 characters long and contain both Numbers and Letters");

		/*Customer enters their preferred password, if incorrect format asks again*/
		while(loop)
		{	

			System.out.println("Enter your desired password: ");

			password = scanner.nextLine();
			if(util.validateCancel(password) == false){
				return null;
			}
			else if(util.validateComma(password) == false){
				continue;
			}
			else if(testPassword(password));
			else{
				System.out.println("Password must be 4-20 characters long and contain both Numbers and Letters");
				continue;
			}

			System.out.println("Confirm Password: ");

			/*Gets user to re enter password to check it*/
			checkPassword = scanner.nextLine();

			if(password.equals(checkPassword))
			{
				System.out.println("Passwords match!");
				loop = false;
			}
			if(util.validateCancel(password) == false){
				return null;
			}
			else
			{
				System.out.print("Passwords do not match, please try again.");
				System.out.print("\n");
			}
		}
		System.out.println("Enter in your address");
		valid = false;
		while(valid == false){
			address = scanner.nextLine();
			if(util.validateCancel(address) == false){
				return null;
			}
			else if(util.validateComma(address) == false);
			else{
				valid = true;
			}
		}
		
		System.out.println("Enter in your contact number");
		valid = false;
		while(valid == false){
			contact = scanner.nextLine();
			if(util.validateCancel(contact) == false){
				return null;
			}
			else if(util.validateComma(contact) == false);
			else if (contact.contains("[a-zA-Z]+") == true){
				System.out.println("Please only type numbers, not characters.");
				continue;
			}
			else{
				valid = true;
			}
		}
		User newUser = new User(name, username, password, address, contact);

		return newUser;

	}
	/*Makes sure username has bit been taken*/
	public boolean checkUsername (String username){

		for (int i = 0; i < users.length; i++)
			if (username.equals(users[i].getUsername())){
				System.out.println("Username " +username+ " is already taken, please select another (Enter 'C' to cancel)");
				return false;
			}
		return true;
	}

	/*Checks passwords match*/
	public boolean matchPassword (String password1, String password2){
		if (password1.equals(password2)){
			return true;
		}
		else{
			return false;
		}
	}

	/*Password testing to make sure it is acceptable*/
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
