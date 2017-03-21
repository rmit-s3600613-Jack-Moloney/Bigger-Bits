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
		boolean valid = false;
		do
		{
			password = input.nextLine();
			if (password.equals(users[userLocation].getPassword()))
			{
				user = new User(username, password);
				valid = true;
			} 
			else if (password.toUpperCase().equals("C")){
				valid = false;
				user = null;
				return null;
			}
			else if (password.equals("")){
				System.out.println("No password entered, please try again.(Enter 'C' to cancel)");
				user = null;
			}
			else
			{
				System.out.println("Invalid password, (Enter 'C' to cancel)");
				user = null;
			}
		} while (valid == false);


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

}
