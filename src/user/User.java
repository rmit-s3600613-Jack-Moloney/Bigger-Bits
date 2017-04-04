package user;

public class User {

	private String name;
    private String username;
    private String password;
    private String address;
    private String contact;
    public User (String name, String user, String pass, String address, String contact){
    	this.name = name;
        this.username = user;
        this.password = pass;
        this.address = address;
        this.contact = contact;
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
    public String getName()
    {
        return name;
    }

    public String getAddress(){
        return address;
    }
    
    public String getContact(){
        return contact;
    }
}
