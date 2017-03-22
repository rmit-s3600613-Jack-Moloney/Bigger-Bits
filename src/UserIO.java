
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
public class UserIO {
	File file = new File("users.txt");

	public User[] initializeUsers() throws FileNotFoundException
	{
		String[] tokens = new String[2];
		int count = 0;
		String username;
		String password;

		Scanner test = new Scanner(file);
		Scanner scanner = new Scanner(file);

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
	public User intializeOwners() throws FileNotFoundException
	{
		String[] tokens = new String[2];
		String username;
		String password;

		Scanner scanner = new Scanner(file);
		User owner;


		tokens = scanner.nextLine().split(",");
		username = tokens[0];
		password = tokens[1];
		owner = new User(username, password);

		scanner.close();
		return owner;

	}
	public void saveUsers(User[] users, ArrayList<User> playerList) throws FileNotFoundException
	{
		PrintWriter output = new PrintWriter(file);
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
