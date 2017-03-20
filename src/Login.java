import java.util.Scanner;

//MItchell did this
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Login {
	public static void logInMenu(){
        User[] users;
        UserIO user = new UserIO();
        Scanner input = new Scanner(System.in);
        String username;
        String password;
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

        System.out.println("Please enter your Password");
        password = input.nextLine();

        //users check = new users(username, password);

        /*if(check.user.auth()){
            System.out.println("You are logged in");
        }
        else
            System.out.println("Invalid Input");
    */



    }
}
