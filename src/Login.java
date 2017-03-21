import java.util.Scanner;

//MItchell did this
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Login {
	User[] users;
	UserIO IO;
	User user;
	int userLocation;
	
	public User logInMenu() {
        Scanner input = new Scanner(System.in);
        String username = null;
        String password = null;
        try {
			users = IO.initializeUsers();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        for (int i = 0; i<users.length; i++){
            System.out.println(users[i].getUsername());
            System.out.println(users[i].getPassword());
        }

        System.out.println("Welcome to the Online Booking System");
        System.out.println("------------------------------------");
        System.out.println("Please Enter your Username");
        username = input.nextLine();

		if (searchUser(username) == false)
		{
			System.out.println("The username you entered is incorrect");
		} else
		{
			System.out.println("Enter Password");
			boolean valid = false;
			do
			{
				password = input.nextLine();

				if (password.equals(users[userLocation]))
				{
					System.out.println("User successfully logged in");
					user = new User(username, password);
					valid = true;
				} 
				else if (password.equals("\n")){
					valid = false;
					user = null;
				}
				else
				{
					System.out.println("Invalid username, press enter to cancel");
					user = null;
				}
			} while (valid == false);
		}

		System.out.println(username);
		System.out.println(password);

		System.out.println("Press Enter to return to Menu");
		input.nextLine();
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
