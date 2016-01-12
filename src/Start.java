
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import guildwars.BossTime;

public class Start {
	
	static ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) {
		GUI.loadALL();
		BossTime.updateButtons();

		startThread();
	}
	
	public static void startThread(){
	
		exec.scheduleAtFixedRate(new Runnable() {
		  @Override
		  public void run() {
		    BossTime.updateButtons();
		  }
		}, 0, 1, TimeUnit.SECONDS);
	}

	

}
