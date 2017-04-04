package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import owner.Owner;
public class UserIO {
	File userFile = new File("users.txt");
	File ownerFile = new File("business.txt");
	
	public User[] initializeUsers() throws FileNotFoundException
	{
		String[] tokens = new String[2];
		int count = 0;
		String username;
		String password;

		Scanner test = new Scanner(userFile);
		Scanner scanner = new Scanner(userFile);

		while (test.hasNextLine())
		{
			test.nextLine();
			count++;
		}
		test.close();

		User[] user = new User[count];

		for (int i = 0; i < count; i++)
		{
			tokens = scanner.nextLine().split(",");
			username = tokens[0];
			password = tokens[1];
			user[i] = new User(username, password);
		}
		scanner.close();

		return user;
	}
	public Owner intializeOwners() throws FileNotFoundException
	{
		String[] tokens = new String[6];
		String username;
	    String password;
	    String business;
	    String name;
	    String address;
	    int phone;
		Scanner scanner = new Scanner(ownerFile);
		Owner owner;

		tokens = scanner.nextLine().split(",");
		username = tokens[0];
		password = tokens[1];
		business = tokens[2];
		name = tokens[3];
		address = tokens[4];
		phone = Integer.parseInt(tokens[5]);
		
		owner = new Owner(username, password, business, name, address, phone);

		scanner.close();
		return owner;

	}
	public void saveUsers(User[] users, ArrayList<User> playerList) throws FileNotFoundException
	{
		PrintWriter output = new PrintWriter(userFile);
		for (int i = 0; i < users.length; i++)
		{
			if (users[i] != null)
			{
				output.println(users[i].getUsername() + "," + users[i].getPassword());
			}
		}
		for (int i = 0; i < playerList.size(); i++)
		{
			output.println(playerList.get(i).getUsername() + "," + playerList.get(i).getPassword());

		}

		output.close();
	}

}
