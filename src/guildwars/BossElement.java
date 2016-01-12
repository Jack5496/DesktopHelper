package guildwars;

import java.util.ArrayList;

public class BossElement {

	public String name;
	public String gebiet;
	public String wegmarke;
	public int stufe;
	public ArrayList<String> spawntimes;

	public BossElement(String name, String gebiet, String wegmarke, int stufe, ArrayList<String> times) {
		this.name = name;
		this.wegmarke = wegmarke;
		this.stufe = stufe;
		this.gebiet = gebiet;
		this.spawntimes = times;
	}

	public BossElement(String name, String gebiet, String wegmarke, int stufe) {
		this.name = name;
		this.wegmarke = wegmarke;
		this.stufe = stufe;
		this.gebiet = gebiet;
		spawntimes = new ArrayList<String>();
	}

	public BossElement(String name, String gebiet, String wegmarke, int stufe, String... times) {
		this.name = name;
		this.wegmarke = wegmarke;
		this.stufe = stufe;
		this.gebiet = gebiet;

		spawntimes = new ArrayList<String>();
		for (String time : times) {
			spawntimes.add(time);
		}
	}

	public String getNextSpawnTime() {
		String nextTime = null;
		String nextTimeRemaining = null;
		
		for(int i=spawntimes.size()-1; i>=0; i--){
			String remaining = TimeElement.getTimeUntilNow(spawntimes.get(i));
			
			if(nextTime==null || nextTimeRemaining==null){				
				nextTime = spawntimes.get(i);
				nextTimeRemaining = remaining;
			}
			else{
				if(remaining.compareTo(nextTimeRemaining)<0){
					nextTimeRemaining = remaining;
					nextTime = spawntimes.get(i);
				}
			}			
		}
		
		return nextTime;
	}

}
