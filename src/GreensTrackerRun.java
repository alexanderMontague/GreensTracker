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
                					fileWriter.write(welcomeScreen + "|");
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
            		basePanel.add(new SwingCalendar());
            		
            		repaint();
            		revalidate();
            		
            }
    		});
	    
	}
	
	
	
	public void run() {
		
		
	    
	}
	
	public static void main(String[] args) {
	    
	    GreensTrackerRun runProgram = new GreensTrackerRun();
		runProgram.setVisible(true);
	    
	}
	
}


