package booking;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking {
	public Date startTime;
	public Date endTime;
	public String custName;
	
	public Booking(String bookingData){
		//System.out.println(time);
		//Cust1.6.4.9:00.10:00
		String[] splitBooking = bookingData.split("\\.");
		String[] splitStartHour = splitBooking[3].split(":");
		String[] splitEndHour = splitBooking[4].split(":");
		setName(splitBooking[0]); 
		setStart(splitBooking[2], splitBooking[1],splitStartHour[0], splitStartHour[1]);
		setEnd(splitBooking[2], splitBooking[1],splitEndHour[0],splitEndHour[1]);
	}
	
	public Date getStart(){
		return startTime;
	}
	
	public Date getEnd(){
		return endTime;
	}
	
	public String getName(){
		return custName;
	}
	
	public void setName(String name){
		this.custName = name;
	}
	
	public void setStart(String month, String date, String hour, String minute){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Integer.parseInt(month)-1);
		cal.set(Calendar.DATE, Integer.parseInt(date));
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
		cal.set(Calendar.MINUTE, Integer.parseInt(minute));
		cal.set(Calendar.SECOND, 0);	
		startTime = cal.getTime();
	}
	
	public void setEnd(String month, String date, String hour, String minute){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Integer.parseInt(month));
		cal.set(Calendar.DATE, Integer.parseInt(date));
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
		cal.set(Calendar.MINUTE, Integer.parseInt(minute));
		cal.set(Calendar.SECOND, 0);	
		endTime = cal.getTime();
	}
	
	public boolean printHours(){
		SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd HH:mm");
		SimpleDateFormat endsdf = new SimpleDateFormat(" - HH:mm ");
		System.out.print(getName() + " ");
		System.out.print(sdf.format(getStart()));
		System.out.println(endsdf.format(getEnd()));
		System.out.println("-------------------------");
		return false;
	}
	
}
