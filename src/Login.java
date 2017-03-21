import java.util.Scanner;

//MItchell did this
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Login {
	User[] users;
	UserIO IO;
	User user;
	int userLocation;

	public User logInMenu(User[] userInput) {
		users = userInput;
		Scanner input = new Scanner(System.in);
		String username = null;
		String password = null;

		/*for (int i = 0; i<users.length; i++){
            System.out.println(users[i].getUsername());
            System.out.println(users[i].getPassword());
        }*/

		System.out.println("User Login");
		System.out.println("------------------------------------");
		System.out.println("Please Enter your Username");
		System.out.println();

		while (searchUser(username = input.nextLine()) == false){
			System.out.println("The username you entered is incorrect (Enter 'C' to cancel)");
			if(username.toUpperCase().equals("C")){
				return null;
			}
		}

		System.out.println("Enter Password");
		int valid = -1;
		do
		{
			valid = -1;
			password = input.nextLine();
			valid = searchPassword(username, password);
			if (valid == 0){
				user = new User(username, password);
			}
			else if (valid == 1){
				user = null;
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
	
	public int searchPassword(String username, String password){
		
		if (password.equals(users[userLocation].getPassword()))
		{
			System.out.println("Match!");
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
