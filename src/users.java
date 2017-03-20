
/**
 * Created by dominicalvaro on 14/03/2017.
 */
public class users {

    private String username;
    private String password;
    private String[][] accounts = {{"dominic", "scrum"},{"christian", "abc123"}};


    public users(String user, String pass){
        username = user;
        password = pass;
    }

    public boolean auth(){
        if((username.equals(accounts[0][0])) && (password.equals(accounts[0][1]))){
            return true;
        }
        else
            return false;
    }
}