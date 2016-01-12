package guildwars;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class TimeElement implements Comparable<TimeElement> {

	public String time;
	public String info;

	public TimeElement(String time, String info) {
		this.time = time;
		this.info = info;
	}

	public Date formatTime(String HoursAndMinutes) {
		SimpleDateFormat ft = new SimpleDateFormat("HH:mm");
		try {
			return ft.parse(HoursAndMinutes);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getTimeUntilNow(String time){
		LocalDateTime now = LocalDateTime.now();
		now = now.plusMinutes(1);
		
		int hours = Integer.parseInt(time.split(":")[0]);
		int minutes = Integer.parseInt(time.split(":")[1]);

		LocalDateTime tocheck = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), hours, minutes, now.getSecond(), now.getNano());
		
		
		if(tocheck.isBefore(now)){
			tocheck = tocheck.plusDays(1);
		}
		
		Duration remaining = Duration.between(now, tocheck);
		
		int rh = (int) remaining.toHours();
		int rm = (int) remaining.toMinutes();
		rm%=60;
		
		int ht = rh/10;
		int hs = rh%10;
		int mt = rm/10;
		int ms = rm%10;
		
		
		return ht+""+hs + ":" + mt+""+ms;
	}

	public String getTimeUntil() {
		return getTimeUntilNow(time);
	}

	@Override
	public int compareTo(TimeElement o) {
		return getTimeUntil().compareTo(o.getTimeUntil());
	}

}
