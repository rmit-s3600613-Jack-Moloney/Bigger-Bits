package owner;
import user.User;

public class Owner extends User {

    private String business;
    private String name;
    private String address;
    private String phone;
    
    /* Constructor to set up the owner */
    public Owner(String username, String pass, String bus, String name, String address, String num){
    	super(name, username, pass, address, num);
    	this.setUsername(username);
        this.business = bus;
        this.name = name;
        this.address = address;
        this.phone = num;
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
    public String getNum(){
        return phone;
    }
    
}
