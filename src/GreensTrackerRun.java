// Greens Tracker Application
// Alexander Montague
// Updated December 2017
// Application developed for use during a hand watering shift at the Oakville Golf Club 

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.time.*;


public class GreensTrackerRun extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private static String[] suffixes =
      //    0     1     2     3     4     5     6     7     8     9
	     { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
	  //    10    11    12    13    14    15    16    17    18    19
	       "th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
	  //    20    21    22    23    24    25    26    27    28    29
	       "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
	  //    30    31
	       "th", "st" };
	
	private int lapNum = 1;
	
	private dataEntry dataEntry1;
	private dataEntry dataEntry2;
	
	public GreensTrackerRun() {
		
		// DEFAULT SETUP
		setTitle("Greens Tracker");
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setDefaultLookAndFeelDecorated(true);
		JSplitPane basePanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		basePanel.setResizeWeight(1);
        basePanel.setEnabled(false);
        basePanel.setDividerSize(0);
	    add(basePanel);	// main menu split pane
	    
	    BufferedImage myPicture = null;	// loading the menu picture in
	    try {                
	    		myPicture = ImageIO.read(new File("assets/menu.jpg"));
	    		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
	        basePanel.add(picLabel);
	    } 
	    catch (IOException ex) {
	            System.out.println("Error\n");
	    }
	    
	    // MENU COMPONENTS
	    // Layouts / Fonts
	    getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.GRAY));
	    JPanel bottomMenu = new JPanel(new GridLayout(2, 1));
	    JPanel titleTime = new JPanel(new GridLayout(2,1));
	    JLabel menuTitle = new JLabel("Greens Tracker", SwingConstants.CENTER);
	    Font menuFont = new Font("Lucidia Sans Unicode", Font.BOLD, 45);
	    Font timeFont = new Font("Lucidia Sans Unicode", Font.BOLD, 25);
	    Font buttonFont = new Font("Lucidia Sans Unicode", Font.BOLD, 15);
	    Font noBold = new Font("Lucidia Sans Unicode", Font.PLAIN, 15);
	    
	    // Date Stuff
	    LocalDate date = LocalDate.now();
	    DayOfWeek dow = date.getDayOfWeek(); 
	    int dom = date.getDayOfMonth(); 
	    Month m = date.getMonth(); 
	    int y = date.getYear();
	    String fullDate = "Today is " + dow + " " + m + " " + dom + suffixes[dom] + ", " + y;
	    JLabel dateL = new JLabel(fullDate, SwingConstants.CENTER);
	    Calendar time = Calendar.getInstance();
	    int hour = time.get(Calendar.HOUR_OF_DAY);
	    int mins = time.get(Calendar.MINUTE);
	   
	    // Buttons
	    JPanel menuButtons = new JPanel(new GridLayout(1, 2));
	    JButton newWater = new JButton("NEW Watering Session");
	    JButton viewPast = new JButton("VIEW Past Watering Sessions");
	    
	    // Additions / Font Setters
	    menuTitle.setFont(menuFont);
	    dateL.setFont(timeFont);
	    newWater.setFont(buttonFont);
	    viewPast.setFont(buttonFont);
	    
	    titleTime.add(menuTitle);
	    titleTime.add(dateL);
	    basePanel.add(bottomMenu);
	    bottomMenu.add(titleTime);
	    bottomMenu.add(menuButtons);
	    menuButtons.add(newWater);
	    menuButtons.add(viewPast);
	    
	    
	    // NEW HAND WATER 
	    // SCREEN ONE
	    newWater.addActionListener(new ActionListener() {    // When the New Water Button is Clicked
            @Override
            public void actionPerformed(ActionEvent ae) {
            		remove(basePanel);
            		invalidate();
            		
            		JPanel initialScreen = new JPanel(new GridLayout(2, 1));
                 BufferedImage waterPic = null;	// loading the water image in
         	    try {                
         	    		waterPic = ImageIO.read(new File("assets/handWater.jpg"));
         	    		JLabel waterLabel = new JLabel(new ImageIcon(waterPic));
         	    		initialScreen.add(waterLabel);
         	    } 
         	    catch (IOException ex) {
         	            System.out.println("Error\n");
         	    }
            		JLabel waterDateL = new JLabel("Date of Watering: ", JLabel.CENTER);
            		waterDateL.setFont(timeFont);
            		String waterDateLabel = dow + " " + m + " " + dom + suffixes[dom] + ", " + y;
            		JTextField waterDate = new JTextField(waterDateLabel);
            		waterDate.setFont(noBold);
            		waterDate.setEditable(false);
            		JLabel waterNamesL = new JLabel("Name of Waterers: ", JLabel.CENTER);
            		waterNamesL.setFont(timeFont);
            		JTextField waterNames = new JTextField("Enter Names Here");
            		waterNames.setFont(buttonFont);
            		waterNames.addMouseListener(new MouseAdapter() {
            		    @Override
            		    public void mouseClicked(MouseEvent e) {
            		        waterNames.setText("");
            		    }
            		});
            		JLabel startTimeL = new JLabel("Initial Start Time: ", JLabel.CENTER);
            		startTimeL.setFont(timeFont);
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
            		JTextField startTime = new JTextField(shortTime);
            		startTime.setFont(noBold);
            		startTime.setEditable(false);
            		
            		JButton back = new JButton("BACK");
            		back.setFont(buttonFont);
            		JButton next = new JButton("NEXT");
            		next.setFont(buttonFont);
            		
            		add(initialScreen);
            		JPanel rowOne = new JPanel(new GridLayout(4, 1));
            		rowOne.add(waterNamesL);
            		rowOne.add(waterNames);
            		rowOne.add(waterDateL);
            		rowOne.add(waterDate);
            		rowOne.add(startTimeL);
            		rowOne.add(startTime);
            		rowOne.add(back);
            		rowOne.add(next);
            		
            		initialScreen.add(rowOne);
            		
            		revalidate();
            		repaint();
            	    
            		back.addActionListener(new ActionListener() {    
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                    		GreensTrackerRun back = new GreensTrackerRun();
                    		back.setVisible(true);
                    		dispose();
                    	    remove(initialScreen);
                    }
            		});
            		
            		next.addActionListener(new ActionListener() {    
        			   @Override
                    public void actionPerformed(ActionEvent ae) {
                    		if(waterNames.getText().equals("") || waterNames.getText().equals("Enter Names Here") || waterNames.getText().equals("Enter Names!")) {
                    			waterNames.setText("Enter Names!");
                    		}
                    		else {
                    			
                    			// Save input from Previous Screen - Names/Date/Start Time
                    			String names = waterNames.getText();
                    			String date = waterDate.getText();
                    			String initStartTime = startTime.getText();
                    			String welcomeScreen = date + "~" + names + "~" + initStartTime;
                    			
                    			// Write Welcome Screen to File
                				BufferedWriter fileWriter;
                				try {
                					fileWriter = new BufferedWriter(new FileWriter("assets/handwaterDATA.txt", true));
                					fileWriter.write(welcomeScreen + "~");
                					fileWriter.close();
                				}
                				catch(IOException e) {
                					System.out.println("Error Writing to File\n");
                				}
                    			
                    			// WATERING DETAILS
                    			remove(initialScreen);
                    			invalidate();
                    			
                    			// Main Split Panel - Title Labels and Big Panel below that holds inputPanel
                    			JSplitPane waterDataScreen = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                    			waterDataScreen.setResizeWeight(0.05);
                    			waterDataScreen.setEnabled(false);
                    			waterDataScreen.setDividerSize(0);
                    			
                    			// Secondary Split Panel IN second part of waterData Screen - split contains data and button sections
                    			JSplitPane inputPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                    			inputPanel.setResizeWeight(0.60);
                    			inputPanel.setEnabled(false);
                    			inputPanel.setDividerSize(0);
                    			
                    			// Bottom Panel Buttons
                    			JPanel bottomPanel = new JPanel(new GridLayout(1, 2));	 
                    			JButton saveExit = new JButton("Save and Exit");
                    			JButton nextLap = new JButton("Next Lap");
                    			saveExit.setFont(buttonFont);
                    			nextLap.setFont(buttonFont);
                    			bottomPanel.add(saveExit);
                    			bottomPanel.add(nextLap);
                    			
                    			// Input Panel Initial Additions
                    			add(waterDataScreen);
                    			waterDataScreen.add(new titlePanel(lapNum));
                    			waterDataScreen.add(inputPanel);
                    			dataEntry1 = new dataEntry();
                    			inputPanel.add(dataEntry1);
                    			inputPanel.add(bottomPanel);
                    			
                    			revalidate();
                    			repaint();
                    			
                    			saveExit.addActionListener(new ActionListener() {	
                    	            @Override
                    	            public void actionPerformed(ActionEvent ae) {
	                    	            	if(dataEntry1 != null) {
	                	            			// Write data screen to File initial dataEntry panel is already there
	                	            			BufferedWriter fileWriter;
	                	            			try {
	                	            				fileWriter = new BufferedWriter(new FileWriter("assets/handwaterDATA.txt", true));
	                	            				String dataFileWrite = dataEntry1.getDataVals();
	                	            				fileWriter.write(dataFileWrite);
	                	            				fileWriter.newLine();
	                	            				fileWriter.close();
	                	            			}
	                	            			catch(IOException e) {
	                	            				System.out.println("Error Writing to File\n");
	                	            			}
	                	            			dataEntry1 = null;
	                	            		}
	                	            		else {
	                	            			// Write data screen to File for new laps now
	                	            			BufferedWriter fileWriter;
	                	            			try {
	                	            				fileWriter = new BufferedWriter(new FileWriter("assets/handwaterDATA.txt", true));
	                	            				String dataFileWrite = dataEntry2.getDataVals();
	                	            				fileWriter.write(dataFileWrite);
	                	            				fileWriter.newLine();
	                	            				fileWriter.close();
	                	            			}
	                	            			catch(IOException e) {
	                	            				System.out.println("Error Writing to File\n");
	                	            			}
	                	            		}
	                    	        	    remove(waterDataScreen);
	                    	        		GreensTrackerRun saveExit = new GreensTrackerRun();
	                    	        		saveExit.setVisible(true);
	                    	        		dispose();
                    	            }
                    	        });
                    			
                    			nextLap.addActionListener(new ActionListener() {	
                    	            @Override
                    	            public void actionPerformed(ActionEvent ae) {
                    	            		if(dataEntry1 != null) {
                    	            			// Write data screen to File initial dataEntry panel is already there
                    	            			BufferedWriter fileWriter;
                    	            			try {
                    	            				fileWriter = new BufferedWriter(new FileWriter("assets/handwaterDATA.txt", true));
                    	            				String dataFileWrite = dataEntry1.getDataVals();
                    	            				fileWriter.write(dataFileWrite);
                    	            				fileWriter.close();
                    	            			}
                    	            			catch(IOException e) {
                    	            				System.out.println("Error Writing to File\n");
                    	            			}
                    	            			dataEntry1 = null;
                    	            		}
                    	            		else {
                    	            			// Write data screen to File for new laps now
                    	            			BufferedWriter fileWriter;
                    	            			try {
                    	            				fileWriter = new BufferedWriter(new FileWriter("assets/handwaterDATA.txt", true));
                    	            				String dataFileWrite = dataEntry2.getDataVals();
                    	            				fileWriter.write(dataFileWrite);
                    	            				fileWriter.close();
                    	            			}
                    	            			catch(IOException e) {
                    	            				System.out.println("Error Writing to File\n");
                    	            			}
                    	            		}
	                    	        	    lapNum++;
	                    	        	    waterDataScreen.removeAll();
	                    	        	    waterDataScreen.add(new titlePanel(lapNum));
                            			waterDataScreen.add(inputPanel);
                            			inputPanel.removeAll();
                            			dataEntry2 = new dataEntry();
                            			inputPanel.add(dataEntry2);
                            			inputPanel.add(bottomPanel);
                            			revalidate();
                            			repaint();
                    	            }
                    	        });
                    		}
                    }
            		}); 
            }
        });
	    
	    // DISPLAY PAST HAND WATER SESSIONS
	    viewPast.addActionListener(new ActionListener() {    
            @Override
            public void actionPerformed(ActionEvent ae) {
            		
            		basePanel.removeAll();
            		basePanel.setResizeWeight(0.0);
            		SwingCalendar newCal = new SwingCalendar();
            		basePanel.add(newCal);
            		JSplitPane bottomPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
            		bottomPanel.setResizeWeight(0.95);
            		bottomPanel.setEnabled(false);
            		bottomPanel.setDividerSize(0);
            		JPanel top = new JPanel(new GridLayout(1, 1));
            		JPanel bottom = new JPanel(new GridLayout(1, 2));
            		JTextArea data = new JTextArea();
            		data.setEditable(false);
            		JScrollPane scrollData = new JScrollPane(data);
            		JButton back = new JButton("BACK");
            		back.setFont(buttonFont);
            		back.addActionListener(new ActionListener() {    
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                        		GreensTrackerRun back = new GreensTrackerRun();
                        		back.setVisible(true);
                        		dispose();
                        }
                		});
            		JButton view = new JButton("VIEW");
            		view.setFont(buttonFont);
            		view.addActionListener(new ActionListener() {    
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                        		try {
                        			boolean found = false;
                        			int calGetDay = (Integer)newCal.table.getValueAt(newCal.table.getSelectedRow(), newCal.table.getSelectedColumn());
                            		for(int i = 0; i < newCal.waterSessions.size(); i++) {
	    	        	        				waterSession printSession = newCal.waterSessions.get(i);						// current waterSession that is being looked at 
	    	        	        				StringBuilder formatDate = new StringBuilder(printSession.splitDay);
	    	        	        				formatDate.delete(formatDate.length() - 3, formatDate.length());		// getting rid of date suffixes
	    	        	        				String formattedDate = formatDate.toString();
	    	        	        				// Checks every water entry if year, month and day is in entry. If true, colour dates with a water session
	    	        			        		if((calGetDay == Integer.parseInt(formattedDate)) && (newCal.cal.get(Calendar.YEAR) == Integer.parseInt(printSession.splitYear)) && (newCal.cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US).toLowerCase().equals(printSession.splitMonth.toLowerCase()))) {
	    	        			        			data.setText("Water Date: " + printSession.splitDayName + " " + printSession.splitMonth + " " + printSession.splitDay + " " + printSession.splitYear + "\n");
	    	        			        			data.append("Initial Session Start Time: " + printSession.initialStart + "\n\n");
	    	        			        			for(int z = 0; z < printSession.lapList.size(); z++) {
	    	        			        				found = true;
	    	        								data.append(printSession.lapList.get(z).lapNum + "\n");
	    	        								data.append(printSession.lapList.get(z).lapStartTime + "\n");
	    	        								data.append("|------------------------------------------------------------------------------------------------------------------------------------------------|\n");
	    	        								data.append("|\tGreen #\t|\tWatered?\t|\tTemperature (F / M / B)\t\t|\tMoisture (F / M / B)\t\t|\tNotes\t\t|\n");
	    	        							    data.append("|------------------------------------------------------------------------------------------------------------------------------------------------|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(0) + "\t|\t" + printSession.lapList.get(z).watered.get(0) + "\t|\t(" + printSession.lapList.get(z).temps.get(0) + " / " + printSession.lapList.get(z).temps.get(1) + " / " + printSession.lapList.get(z).temps.get(2) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(0) + " / " + printSession.lapList.get(z).moistures.get(1) + " / " + printSession.lapList.get(z).moistures.get(2) + ")\t|\t"+ printSession.lapList.get(z).notes.get(0) + "\t|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(1) + "\t|\t" + printSession.lapList.get(z).watered.get(1) + "\t|\t(" + printSession.lapList.get(z).temps.get(3) + " / " + printSession.lapList.get(z).temps.get(4) + " / " + printSession.lapList.get(z).temps.get(5) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(3) + " / " + printSession.lapList.get(z).moistures.get(4) + " / " + printSession.lapList.get(z).moistures.get(5) + ")\t|\t"+ printSession.lapList.get(z).notes.get(1) + "\t|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(2) + "\t|\t" + printSession.lapList.get(z).watered.get(2) + "\t|\t(" + printSession.lapList.get(z).temps.get(6) + " / " + printSession.lapList.get(z).temps.get(7) + " / " + printSession.lapList.get(z).temps.get(8) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(6) + " / " + printSession.lapList.get(z).moistures.get(7) + " / " + printSession.lapList.get(z).moistures.get(8) + ")\t|\t"+ printSession.lapList.get(z).notes.get(2) + "\t|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(3) + "\t|\t" + printSession.lapList.get(z).watered.get(3) + "\t|\t(" + printSession.lapList.get(z).temps.get(9) + " / " + printSession.lapList.get(z).temps.get(10) + " / " + printSession.lapList.get(z).temps.get(11) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(9) + " / " + printSession.lapList.get(z).moistures.get(10) + " / " + printSession.lapList.get(z).moistures.get(11) + ")\t|\t"+ printSession.lapList.get(z).notes.get(3) + "\t|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(4) + "\t|\t" + printSession.lapList.get(z).watered.get(4) + "\t|\t(" + printSession.lapList.get(z).temps.get(12) + " / " + printSession.lapList.get(z).temps.get(13) + " / " + printSession.lapList.get(z).temps.get(14) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(12) + " / " + printSession.lapList.get(z).moistures.get(13) + " / " + printSession.lapList.get(z).moistures.get(14) + ")\t|\t"+ printSession.lapList.get(z).notes.get(4) + "\t|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(5) + "\t|\t" + printSession.lapList.get(z).watered.get(5) + "\t|\t(" + printSession.lapList.get(z).temps.get(15) + " / " + printSession.lapList.get(z).temps.get(16) + " / " + printSession.lapList.get(z).temps.get(17) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(15) + " / " + printSession.lapList.get(z).moistures.get(16) + " / " + printSession.lapList.get(z).moistures.get(17) + ")\t|\t"+ printSession.lapList.get(z).notes.get(5) + "\t|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(6) + "\t|\t" + printSession.lapList.get(z).watered.get(6) + "\t|\t(" + printSession.lapList.get(z).temps.get(18) + " / " + printSession.lapList.get(z).temps.get(19) + " / " + printSession.lapList.get(z).temps.get(20) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(18) + " / " + printSession.lapList.get(z).moistures.get(19) + " / " + printSession.lapList.get(z).moistures.get(20) + ")\t|\t"+ printSession.lapList.get(z).notes.get(6) + "\t|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(7) + "\t|\t" + printSession.lapList.get(z).watered.get(7) + "\t|\t(" + printSession.lapList.get(z).temps.get(21) + " / " + printSession.lapList.get(z).temps.get(21) + " / " + printSession.lapList.get(z).temps.get(23) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(21) + " / " + printSession.lapList.get(z).moistures.get(22) + " / " + printSession.lapList.get(z).moistures.get(23) + ")\t|\t"+ printSession.lapList.get(z).notes.get(7) + "\t|\n");
	    	        								data.append("|\t" + printSession.lapList.get(z).greenNums.get(8) + "\t|\t" + printSession.lapList.get(z).watered.get(8) + "\t|\t(" + printSession.lapList.get(z).temps.get(24) + " / " + printSession.lapList.get(z).temps.get(24) + " / " + printSession.lapList.get(z).temps.get(26) + ")\t\t|\t(" + printSession.lapList.get(z).moistures.get(24) + " / " + printSession.lapList.get(z).moistures.get(25) + " / " + printSession.lapList.get(z).moistures.get(26) + ")\t|\t"+ printSession.lapList.get(z).notes.get(8) + "\t|\n");
		    	        			        		}
	    	        				        }
            	        				}
                            		if(found == false) {
                            			data.setText("No Watering Session for this Day");
                            		}
                        		}
                        		catch(NullPointerException e) {
                        			data.setText("No Watering Session for this Day");
                        		}
			        			newCal.table.clearSelection();
                        }
                		});
            		
            		top.add(scrollData);
            		bottom.add(back);
            		bottom.add(view);
            		bottomPanel.add(top);
            		bottomPanel.add(bottom);
            		basePanel.add(bottomPanel);
            		
            		repaint();
            		revalidate();
            }
    		});
	    
	}
	
	public static void main(String[] args) {
	    
	    GreensTrackerRun runProgram = new GreensTrackerRun();
		runProgram.setVisible(true);
	    
	}
	
}


