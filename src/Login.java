import java.util.Scanner;

//MItchell did this
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Login {
	String username;
    String password;
	public void logInMenu(){
        User[] users;
        UserIO user = new UserIO();
        Scanner input = new Scanner(System.in);
        
        try
        {
            users = user.initializeUsers();
        } catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            users = null;
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
        if(searchUser(users, username)){
        	
        }
        else{
        	
        }

        System.out.println("Please enter your Password");
        password = input.nextLine();

    
    }
	public boolean searchUser(User[] users, String search)
	{
		//Search array for matching id.
		boolean exist = false;

		for (int i = 0; i < users.length; i++)
		{
			if ((users[i] != null) && (users[i].getUsername().equals(search)))
			{
				//If exists, set memberLocation to i
				username = users[i].getUsername();
				exist = true;
				break;
			}
		}
		return exist;
	}
}
