package user;

public class User {

    private String username;
    private String password;
    private boolean isOwner;

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
    
    public void setUsername(String username){
    	this.username = username;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
}
