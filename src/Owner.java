
public class Owner {

    private String username;
    private String password;
    private String business;
    private String name;
    private String address;
    private int phone;
    
    public Owner(String user, String pass, String bus, String name, String address, int num){
        this.username = user;
        this.password = pass;
        this.business = bus;
        this.name = name;
        this.address = address;
        this.phone = num;
    }

    public String getUsername()
    {
        return username;
    }
    
    public String getPassword(){
    	return password;
    }

    public String getBusiness(){
        return business;
    }
    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public int getNum(){
        return phone;
    }
    
}
