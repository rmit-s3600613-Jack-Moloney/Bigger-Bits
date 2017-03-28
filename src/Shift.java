import java.util.Date;
import java.util.Calendar;

public class Shift {
	private Date startTime;
	private Date endTime;
	
	public Shift(String time){
		String[] splitTime = time.split(",");
		String[] splitStartHour = splitTime[2].split(":");
		String[] splitEndHour = splitTime[3].split(":");
		setStart(splitTime[1], splitTime[0],splitStartHour[0], splitStartHour[1]);
		setEnd(splitTime[1], splitTime[0],splitEndHour[0],splitEndHour[1]);
	}
	
	public void setStart(String month, String date, String hour, String minute){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Integer.parseInt(month));
		cal.set(Calendar.DATE, Integer.parseInt(date));
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.HOUR, Integer.parseInt(hour));
		cal.set(Calendar.MINUTE, Integer.parseInt(minute));
		cal.set(Calendar.SECOND, 0);	
		startTime = cal.getTime();
	}
	
	public void setEnd(String month, String date, String hour, String minute){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Integer.parseInt(month));
		cal.set(Calendar.DATE, Integer.parseInt(date));
		cal.set(Calendar.YEAR, 2017);
		cal.set(Calendar.HOUR, Integer.parseInt(hour));
		cal.set(Calendar.MINUTE, Integer.parseInt(minute));
		cal.set(Calendar.SECOND, 0);	
		endTime = cal.getTime();
	}
	
	public Date getStart(){
		return startTime;
	}
	
	public Date getEnd(){
		return endTime;
	}
}
