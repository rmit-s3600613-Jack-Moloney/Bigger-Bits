
public class Owner extends User {

    private String business;
    private String name;
    private String address;
    private int phone;
    
    public Owner(String username, String pass, String bus, String name, String address, int num){
    	super(username, pass);
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
    public int getNum(){
        return phone;
    }
    
}
