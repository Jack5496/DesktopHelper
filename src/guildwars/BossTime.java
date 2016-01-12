package guildwars;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;

public class BossTime {

	public static ArrayList<BossElement> bossEvents;
	public static ArrayList<TimeElement> events = new ArrayList<TimeElement>();

	static {
		bossEvents = new ArrayList<BossElement>();

		bossEvents.add(new BossElement("Tequatl", "Funkenschwärmküste", "Splitterküste", 65, "01:00", "04:00", "08:00",
				"12:30", "17:00", "20:00"));
		bossEvents.add(new BossElement("Großer Dschungelwurn", "Blutstrom-Küste", "Wachsame der Fördenmündung", 55,
				"02:00", "02:00", "09:00", "13:30", "18:00", "21:00"));
		bossEvents.add(new BossElement("Karka-Königin", "Südlicht-Bucht", "Karka-Lager", 80, "00:00", "03:00", "07:00",
				"11:30", "16:00", "19:00"));
		bossEvents.add(new BossElement("Der Zerschmetterer", "Flammenkamm-Steppe", "Tiefland-Brand", 50, "01:00",
				"04:00", "08:00", "12:30", "17:00", "20:00"));
		bossEvents.add(new BossElement("Golem Typ II", "Mahlstrom-Gipfel", "Alter Hammergrund", 68, "00:00", "03:00",
				"06:00", "09:00", "12:00", "15:00", "18:00", "21:00"));
		bossEvents.add(new BossElement("Klaue von Jormag", "Eisklamm-Sund", "Erdbeben ", 80, "00:15", "03:30", "06:30",
				"09:30", "12:30", "15:30", "18:30", "21:30"));
		bossEvents.add(new BossElement("Megazerstörer", "Mahlstrom-Gipfel", "Mahlstrom ", 66, "01:30", "04:30", "07:30",
				"10:30", "13:30", "16:30", "19:30", "22:30"));
		bossEvents.add(new BossElement("Modniir Ulgoth", "Harathi-Hinterland", "Spalthuf", 43, "02:30", "05:30",
				"08:30", "11:30", "14:30", "17:30", "20:30", "23:30"));
		bossEvents.add(new BossElement("Taidha Covington", "Blutstrom-Küste", "Lachmöwe", 50, "01:00", "04:00", "07:00",
				"10:00", "13:00", "16:00", "19:00", "22:00"));
		bossEvents.add(new BossElement("Dschungelwurm", "Caledon-Wald", "Zwielichtgarten", 15, "00:15", "02:15",
				"04:15", "06:15", "08:15", "10:15", "12:15", "14:15", "16:15", "18:15", "20:15", "22:15"));
		bossEvents.add(new BossElement("Feuerelementar", "Provinz Metrica", "Überlebendenlager", 15, "01:45", "03:45",
				"05:45", "07:45", "09:45", "11:45", "13:45", "15:45", "17:45", "19:45", "21:45", "23:45"));
		bossEvents.add(new BossElement("Schatten-Behemoth", "Königintal", "Gottloser Sumpf", 15, "00:45", "02:45",
				"04:45", "06:45", "08:45", "10:45", "12:45", "14:45", "16:45", "18:45", "20:45", "22:45"));
		bossEvents.add(new BossElement("Svanir-Schamane", "Wanderer-Hügel", "Vendrakes Gehöft", 10, "01:15", "03:15",
				"05:15", "07:15", "09:15", "11:15", "13:15", "15:15", "17:15", "19:15", "21:15", "23:15"));
	}

	public static BossElement getBossElementByInfo(String info) {
		for (BossElement lookup : bossEvents) {
			if (lookup.name.equalsIgnoreCase(info))
				return lookup;
		}
		return null;
	}

	public static List<TimeElement> getNextBosses() {

		List<TimeElement> back = new ArrayList<TimeElement>();
		for (BossElement boss : bossEvents) {
			back.add(new TimeElement(boss.getNextSpawnTime(), boss.name));
		}
		Collections.sort(back);
		return back;
	}

	public static void updateButtons() {
		List<TimeElement> events = getNextBosses();

		List<JButton> allButtons = GuildWarsGUI.getButtons();

		int max = allButtons.size();
		if (events.size() < max)
			max = events.size();

		LocalDateTime now = LocalDateTime.now();
		int seconds = 60 - now.getSecond();
		int ts = seconds / 10;
		int ss = seconds % 10;

		TimeElement t = events.get(0);
		BossElement event = getBossElementByInfo(t.info);

		allButtons.get(0).setLabel(t.time + " Uhr");
		allButtons.get(1).setLabel("<html><center>left: <br>" + t.getTimeUntil() + ":" + ts + ss + "</center></html>");
		allButtons.get(2).setLabel("<html><center>" + event.name + "<br>" + event.gebiet + "<br>"+event.wegmarke+"</center></html>");
		allButtons.get(3).setLabel("Lvl: " + event.stufe);

		for (int i = 1; i < max; i++) {
			TimeElement te = events.get(i);
			allButtons.get(i + GuildWarsGUI.topPanelButtons - 1).setLabel("<html><center>At: " + te.time + " is: "
					+ te.info + "<br>left: " + te.getTimeUntil() + "</center></html>");
		}
	}

}
