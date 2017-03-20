
public class User {

    private String username;
    private String password;
    private String[][] accounts = {{"dominic", "scrum"},{"christian", "abc123"}};


    public User(String user, String pass){
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
    public String getUsername()
    {
        return username;
    }

    public String getPassword(){
        return password;
    }
}
