
public class User {

    private String username;
    private String password;

    public User(String user, String pass){
        username = user;
        password = pass;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword(){
        return password;
    }
}
