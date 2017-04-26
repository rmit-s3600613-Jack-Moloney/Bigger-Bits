package owner;

public class Activity {
	private String name;
	private String description;
	private int length;
	
	public Activity(String name, String desc, int length){
		setName(name);
		setDesc(desc);
		setLength(length);
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDesc(){
		return this.description;
	}
	
	public void setDesc(String desc){
		this.description = desc;
	}
	
	public int getLength(){
		return this.length;
	}
	
	public void setLength(int length){
		this.length = length;
	}
	
	
}
