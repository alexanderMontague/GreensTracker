// Calendar Component to hold past hand watering sessions
// Base Calendar retrieved from: http://www.javacodex.com/Swing/Swing-Calendar

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class SwingCalendar extends JPanel {
 
  private static final long serialVersionUID = 1L; // Silence Warning
  DefaultTableModel model;
  Calendar cal = new GregorianCalendar();
  JLabel label;
  Font timeFont = new Font("Lucidia Sans Unicode", Font.BOLD, 25);
  Font buttonFont = new Font("Lucidia Sans Unicode", Font.BOLD + Font.ITALIC, 15);
  Font cellFont = new Font("Lucidia Sans Unicode", Font.BOLD, 15);
 
  public SwingCalendar() {
 
    this.setLayout(new BorderLayout()); // Main Class Panel
    this.setVisible(true);
    
    label = new JLabel();
    label.setHorizontalAlignment(SwingConstants.CENTER);
 
    JButton b1 = new JButton();
    b1.setFont(timeFont);
    try {
    			ImageIcon pic1 = new ImageIcon(new ImageIcon("assets/left_arrow.jpg").getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT));
        		b1.setIcon(pic1);
      	} 
        catch (Exception ex) {
    			System.out.println(ex);
        }
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
    	  	cal.add(Calendar.MONTH, -1);
        updateMonth();
      }
    });
 
    JButton b2 = new JButton();
    b2.setFont(timeFont);
    try {
    		ImageIcon pic2 = new ImageIcon(new ImageIcon("assets/right_arrow.jpg").getImage().getScaledInstance(50, 30, Image.SCALE_DEFAULT));
		b2.setIcon(pic2);
	} 
    catch (Exception ex) {
		System.out.println(ex);
    }
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, +1);
        updateMonth();
      }
    });
 
    JPanel panel = new JPanel();		// Header Panel with Title and Buttons
    panel.setLayout(new BorderLayout());
    panel.add(b1,BorderLayout.WEST);
    panel.add(label,BorderLayout.CENTER);
    panel.add(b2,BorderLayout.EAST);
 
 
    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    model = new DefaultTableModel(null,columns);
    JTable table = new JTable(model) {
		private static final long serialVersionUID = 1L;	// Silence Warning
		public boolean isCellEditable(int row, int column){  
            return false;  
        }
    };
    
    table.getTableHeader().setFont(buttonFont);
    table.setShowGrid(true);
    table.setFont(cellFont);
    table.setGridColor(Color.BLACK);
    table.setRowHeight(75);
    table.setRowSelectionAllowed(false);
    table.setCellSelectionEnabled(true);
    JScrollPane pane = new JScrollPane(table);
    
    this.add(panel,BorderLayout.NORTH);
    this.add(pane,BorderLayout.CENTER);
 
    this.updateMonth();
 
  }
 
  void updateMonth() {
    cal.set(Calendar.DAY_OF_MONTH, 1);
 
    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    int year = cal.get(Calendar.YEAR);
    label.setFont(timeFont);
    label.setText(month + " " + year);
 
    int startDay = cal.get(Calendar.DAY_OF_WEEK);
    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
 
    model.setRowCount(weeks);
 
    int i = startDay-1;
    for(int day = 1; day <= numberOfDays; day++){
      model.setValueAt(day, i / 7 , i % 7 );    
      i = i + 1;
    }
    
    // Parse file data then add to calendar
	try {
		BufferedReader fileReader = new BufferedReader(new FileReader("assets/handwaterDATA.txt"));
		String readLine = fileReader.readLine();
		while(readLine != null) {
			
			
			
			readLine = fileReader.readLine();
		}
	}
	catch(IOException e) {
		System.out.println("Failed to read the specified file");
	}
	
  }
}