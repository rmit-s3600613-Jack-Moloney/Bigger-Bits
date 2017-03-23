import java.util.Scanner;

//MItchell did this
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Login {
	User[] users;
	Owner owner;
	UserIO IO;
	User user;
	int userLocation;

	public User logInMenu(User[] userInput, Owner owner) {
		users = userInput;
		Scanner input = new Scanner(System.in);
		String username = null;
		String password = null;


		System.out.println("User Login");
		System.out.println("------------------------------------");
		
		
		boolean loop = true;
		boolean isOwner;
		
		while (loop == true){
			System.out.println("Please Enter your Username");
			
			username = input.nextLine();
			if(searchOwner(username, owner)){
				isOwner = true;
				System.out.println("Owner found!");
				loop = false;
			}
			else if(searchUser(username)){
				isOwner = false;
				System.out.println("Customer found!");
				loop = false;
			}
			else if(username.toUpperCase().equals("C")){
				System.out.println("Returning to menu");
				input.close();
				return null;
			}
			else{
				System.out.println("The username you entered is incorrect (Enter 'C' to cancel)");
			}
		}

		System.out.println("Enter Password");
		int valid = -1;
		do
		{
			valid = -1;
			password = input.nextLine();
			valid = searchPassword(username, password, owner);
			if (valid == 0){
				user = new User(username, password);
			}
			else if (valid == 1){
				user = null;
				//input.close();
				return null;
			}
			else if (valid == 2){
				System.out.println("No password entered, please try again.(Enter 'C' to cancel)");
				user = null;
			}
			else
			{
				System.out.println("Invalid password, (Enter 'C' to cancel)");
				user = null;
			}
		} while (valid != 0);


		System.out.println("User "+username+" has successfully been logged in");
		//input.close();
		return user;

	}
	public boolean searchUser(String search)
	{
		//Search array for matching id.
		boolean exist = false;

		for (int i = 0; i < users.length; i++)
		{
			if ((users[i] != null) && (users[i].getUsername().equals(search)))
			{
				//If exists, set memberLocation to i
				userLocation = i;
				exist = true;
				break;
			}
		}
		return exist;
	}
	
	public boolean searchOwner(String search, Owner owner)
	{
		//Search array for matching id.
		boolean exist = false;
		System.out.println(owner.getUsername());
		
		if ((owner != null) && (owner.getUsername().equals(search)))
			{
				//If exists, set memberLocation to i
				exist = true;
			}
		return exist;
	}
	
	public int searchPassword(String username, String password, Owner owner){
		
		if (password.equals(users[userLocation].getPassword()))
		{
			return 0;
		} 
		else if(password.equals(owner.getPassword())){
			return 0;
		}
		else if (password.toUpperCase().equals("C")){
			user = null;
			return 1;
		}
		else if (password.equals("")){
			return 2;
		}
		else
		{
			return 3;
		}
	}

}
