// Title Panel Class
// JPanel that contains information for the title

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import javax.swing.*;



public class titlePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public titlePanel(int lapNum) {
		
		setLayout(new GridLayout(1, 2));
		
	    Font menuFont2 = new Font("Lucidia Sans Unicode", Font.BOLD + Font.ITALIC, 35);
	    Font timeFont = new Font("Lucidia Sans Unicode", Font.BOLD, 25);

		// Date Stuff
	    Calendar time = Calendar.getInstance();
	    int hour = time.get(Calendar.HOUR_OF_DAY);
	    int mins = time.get(Calendar.MINUTE);
		int newHour = hour;
		int newMins = mins;
		boolean pm = false;
		// TIME SUFFIXES AND STUFF
		if((newHour > 12 && newMins > 0) || newHour - 12 == 0) {
			newHour = hour - 12;
			if(newHour == 0) {
				newHour = newHour + 12;
			}
			pm = true;
		}
		if(newHour == 0) {
			newHour = 12;
		}
		String minString = Integer.toString(newMins);
		if(pm == true) {
			minString = minString + "pm";
		}
		else {
			minString = minString + "am";
		}
		if(newMins < 10) {
			minString = "0" + minString;
		}
		String shortTime = newHour + ":" + minString;
		
		JLabel waterLap = new JLabel("Water Lap " + lapNum, JLabel.CENTER);
		waterLap.setFont(menuFont2);
		waterLap.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		JLabel realStartTime = new JLabel("Actual Start Time: " + shortTime, JLabel.CENTER);
		realStartTime.setFont(timeFont);
		realStartTime.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		
		add(waterLap);
		add(realStartTime);
		
		// Write Welcome Screen to File
		BufferedWriter fileWriter;
		try {
			fileWriter = new BufferedWriter(new FileWriter("assets/handwaterDATA.txt", true));
			fileWriter.write(waterLap.getText() + "~" + realStartTime.getText() + "|");
			fileWriter.close();
		}
		catch(IOException e) {
			System.out.println("Error Writing to File\n");
		}
	}
}
