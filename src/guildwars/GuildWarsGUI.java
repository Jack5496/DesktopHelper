package guildwars;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class GuildWarsGUI {

	static Panel gwpanel;
	public static List<JButton> allButtons = new ArrayList<JButton>();

	public static Panel getPanel() {
		if (gwpanel == null) {
			gwpanel = loadGUI();
		}
		return gwpanel;
	}

	public static List<JButton> getButtons() {
		return allButtons;
	}
	
	private static int topClocksize = 80;
	private static int topRemainingsize = 80;
	private static int topInfosize = 40;
	private static int topLvlsize = 80;
	
	
	private static int middlesize = 20;
	
	public static int topPanelButtons = 4;

	public static Panel loadGUI() {
		gwpanel = new Panel();
		gwpanel.setLayout(new GridLayout(2, 1, 3, 3));
		
		Panel topPanel = new Panel(new GridLayout(2, 2, 3, 3));
		for (int i = 0; i < 12+topPanelButtons; i++) {

			JButton b = new JButton("Button " + (i + 1));
			b.setFont(new Font("Arial", Font.PLAIN, middlesize));
			if (i == 0)	b.setFont(new Font("Arial", Font.PLAIN, topClocksize));
			if (i == 1)	b.setFont(new Font("Arial", Font.PLAIN, topRemainingsize));
			if (i == 2)	b.setFont(new Font("Arial", Font.PLAIN, topInfosize));
			if (i == 3)	b.setFont(new Font("Arial", Font.PLAIN, topLvlsize));
						
			
			allButtons.add(b);
		}
		
		// "this" Frame sets layout to 3x2 GridLayout, horizontal and verical
		// gaps of 3 pixels

		Panel middle = new Panel(new GridLayout(4, 3, 3, 3));
		

		
		gwpanel.add(topPanel);
		gwpanel.add(middle);
		
		topPanel.add(allButtons.get(0));
		topPanel.add(allButtons.get(1));
		topPanel.add(allButtons.get(2));
		topPanel.add(allButtons.get(3));


		for (int i = topPanelButtons; i < 12+topPanelButtons; i++) {
			middle.add(allButtons.get(i));
		}

		return gwpanel;
	}

}
