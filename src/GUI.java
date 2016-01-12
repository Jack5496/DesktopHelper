import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import guildwars.GuildWarsGUI;

public class GUI {

	public static void loadALL() {
		updateScreenSize();
		loadGUI();
	}

	static GraphicsDevice gd;
	static int width;
	static int height;

	public static void updateScreenSize() {
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		width = gd.getDisplayMode().getWidth();
		height = gd.getDisplayMode().getHeight();
	}
	
	
	public static void loadGUI() {
		JFrame frame = new JFrame("Guild Wars 2");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width / 2, height / 2);
		
		frame.add(GuildWarsGUI.getPanel());
		
		frame.setVisible(true);

	}

}
