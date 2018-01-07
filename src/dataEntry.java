// Data Entry JPanel Class
// Contains all fields for hand watering 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class dataEntry extends JPanel {
	

	private static final long serialVersionUID = 1L;
	
	// Note Declaration
	private JTextField notes1;
	private JTextField notes2;
	private JTextField notes3;
	private JTextField notes4;
	private JTextField notes5;
	private JTextField notes6;
	private JTextField notes7;
	private JTextField notes8;
	private JTextField notes9;
	
	// Check Boxes Declaration
	private JCheckBox Wone1;
	private JCheckBox Wtwo1;
	private JCheckBox Wthree1;
	private JCheckBox Wfour1;
	private JCheckBox Wfive1;
	private JCheckBox Wsix1;
	private JCheckBox Wseven1;
	private JCheckBox Weight1;
	private JCheckBox Wnine1;
	
	// Temperature Declaration
	private JTextField Tone1;
	private JTextField Tone2;
	private JTextField Tone3;
	private JTextField Ttwo1;
	private JTextField Ttwo2;
	private JTextField Ttwo3;
	private JTextField Tthree1;
	private JTextField Tthree2;
	private JTextField Tthree3;
	private JTextField Tfour1;
	private JTextField Tfour2;
	private JTextField Tfour3;
	private JTextField Tfive1;
	private JTextField Tfive2;
	private JTextField Tfive3;
	private JTextField Tsix1;
	private JTextField Tsix2;
	private JTextField Tsix3;
	private JTextField Tseven1;
	private JTextField Tseven2;
	private JTextField Tseven3;
	private JTextField Teight1;
	private JTextField Teight2;
	private JTextField Teight3;
	private JTextField Tnine1;
	private JTextField Tnine2;
	private JTextField Tnine3;
	
	// Moisture Declaration
	private JTextField Mone1;
	private JTextField Mone2;
	private JTextField Mone3;
	private JTextField Mtwo1;
	private JTextField Mtwo2;
	private JTextField Mtwo3;
	private JTextField Mthree1;
	private JTextField Mthree2;
	private JTextField Mthree3;
	private JTextField Mfour1;
	private JTextField Mfour2;
	private JTextField Mfour3;
	private JTextField Mfive1;
	private JTextField Mfive2;
	private JTextField Mfive3;
	private JTextField Msix1;
	private JTextField Msix2;
	private JTextField Msix3;
	private JTextField Mseven1;
	private JTextField Mseven2;
	private JTextField Mseven3;
	private JTextField Meight1;
	private JTextField Meight2;
	private JTextField Meight3;
	private JTextField Mnine1;
	private JTextField Mnine2;
	private JTextField Mnine3;
	
	public dataEntry() {
		
	    Font buttonFont = new Font("Lucidia Sans Unicode", Font.BOLD, 15);
	    Font noBoldSmall = new Font("Lucidia Sans Unicode", Font.PLAIN, 10);
		
		// Data Input Panel
		JPanel dataEntries = new JPanel(new GridLayout(10, 5, 0, 0));
		dataEntries.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
		
		// Data Entry Screen Components
		JLabel hole = new JLabel("   Hole", JLabel.CENTER);
		hole.setFont(buttonFont);
		hole.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
		
		JPanel tempTitles = new JPanel(new GridLayout(2, 1));
		JLabel temperature = new JLabel("Temperature", JLabel.CENTER);
		temperature.setFont(buttonFont);
		tempTitles.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		JLabel tempSpot = new JLabel("      Front\t\t\t\t\t\t\t\t\tMiddle\t\t\t\t\t\t\t\tBack");
		tempSpot.setFont(noBoldSmall);
		tempTitles.add(temperature);
		tempTitles.add(tempSpot);
		
		JPanel moisTitles = new JPanel(new GridLayout(2, 1));
		JLabel moisture = new JLabel("Moisture", JLabel.CENTER);
		moisture.setFont(buttonFont);
		moisTitles.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		JLabel moisSpot = new JLabel("      Front\t\t\t\t\t\t\t\t\tMiddle\t\t\t\t\t\t\t\tBack");
		moisSpot.setFont(noBoldSmall);
		moisTitles.add(moisture);
		moisTitles.add(moisSpot);
		
		JLabel watered = new JLabel("          Watered", JLabel.LEFT);
		watered.setFont(buttonFont);
		watered.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
		
		JLabel notes = new JLabel("Notes", JLabel.CENTER);
		notes.setFont(buttonFont);
		notes.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK));
		
		// Green Picture Icons
		ImageIcon pic1 = new ImageIcon(new ImageIcon("assets/green1.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	    ImageIcon pic2 = new ImageIcon(new ImageIcon("assets/green2.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon pic3 = new ImageIcon(new ImageIcon("assets/green3.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon pic4 = new ImageIcon(new ImageIcon("assets/green4.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon pic5 = new ImageIcon(new ImageIcon("assets/green5.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon pic6 = new ImageIcon(new ImageIcon("assets/green6.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon pic7 = new ImageIcon(new ImageIcon("assets/green7.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon pic8 = new ImageIcon(new ImageIcon("assets/green8.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		ImageIcon pic9 = new ImageIcon(new ImageIcon("assets/green9.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		JLabel green1 = new JLabel ("     Green 1", pic1, JLabel.LEFT);
		JLabel green2 = new JLabel ("     Green 2", pic2, JLabel.LEFT);
		JLabel green3 = new JLabel ("     Green 3", pic3, JLabel.LEFT);
		JLabel green4 = new JLabel ("     Green 4", pic4, JLabel.LEFT);
		JLabel green5 = new JLabel ("     Green 5", pic5, JLabel.LEFT);
		JLabel green6 = new JLabel ("     Green 6", pic6, JLabel.LEFT);
		JLabel green7 = new JLabel ("     Green 7", pic7, JLabel.LEFT);
		JLabel green8 = new JLabel ("     Green 8", pic8, JLabel.LEFT);
		JLabel green9 = new JLabel ("     Green 9", pic9, JLabel.LEFT);
		
		// Temperature Fields
		JPanel temp1 = new JPanel(new GridLayout(1, 3));
		Tone1 = new JTextField();
		Tone2 = new JTextField();
		Tone3 = new JTextField();
		Tone1.setHorizontalAlignment(JTextField.CENTER);
		Tone2.setHorizontalAlignment(JTextField.CENTER);
		Tone3.setHorizontalAlignment(JTextField.CENTER);
		temp1.add(Tone1);
		temp1.add(Tone2);
		temp1.add(Tone3);
		JPanel temp2 = new JPanel(new GridLayout(1, 3));
		Ttwo1 = new JTextField();
		Ttwo2 = new JTextField();
		Ttwo3 = new JTextField();
		Ttwo1.setHorizontalAlignment(JTextField.CENTER);
		Ttwo2.setHorizontalAlignment(JTextField.CENTER);
		Ttwo3.setHorizontalAlignment(JTextField.CENTER);
		temp2.add(Ttwo1);
		temp2.add(Ttwo2);
		temp2.add(Ttwo3);
		JPanel temp3 = new JPanel(new GridLayout(1, 3));
		Tthree1 = new JTextField();
		Tthree2 = new JTextField();
		Tthree3 = new JTextField();
		Tthree1.setHorizontalAlignment(JTextField.CENTER);
		Tthree2.setHorizontalAlignment(JTextField.CENTER);
		Tthree3.setHorizontalAlignment(JTextField.CENTER);
		temp3.add(Tthree1);
		temp3.add(Tthree2);
		temp3.add(Tthree3);
		JPanel temp4 = new JPanel(new GridLayout(1, 3));
		Tfour1 = new JTextField();
		Tfour2 = new JTextField();
		Tfour3 = new JTextField();
		Tfour1.setHorizontalAlignment(JTextField.CENTER);
		Tfour2.setHorizontalAlignment(JTextField.CENTER);
		Tfour3.setHorizontalAlignment(JTextField.CENTER);
		temp4.add(Tfour1);
		temp4.add(Tfour2);
		temp4.add(Tfour3);
		JPanel temp5 = new JPanel(new GridLayout(1, 3));
		Tfive1 = new JTextField();
		Tfive2 = new JTextField();
		Tfive3 = new JTextField();
		Tfive1.setHorizontalAlignment(JTextField.CENTER);
		Tfive2.setHorizontalAlignment(JTextField.CENTER);
		Tfive3.setHorizontalAlignment(JTextField.CENTER);
		temp5.add(Tfive1);
		temp5.add(Tfive2);
		temp5.add(Tfive3);
		JPanel temp6 = new JPanel(new GridLayout(1, 3));
		Tsix1 = new JTextField();
		Tsix2 = new JTextField();
		Tsix3 = new JTextField();
		Tsix1.setHorizontalAlignment(JTextField.CENTER);
		Tsix2.setHorizontalAlignment(JTextField.CENTER);
		Tsix3.setHorizontalAlignment(JTextField.CENTER);
		temp6.add(Tsix1);
		temp6.add(Tsix2);
		temp6.add(Tsix3);
		JPanel temp7 = new JPanel(new GridLayout(1, 3));
		Tseven1 = new JTextField();
		Tseven2 = new JTextField();
		Tseven3 = new JTextField();
		Tseven1.setHorizontalAlignment(JTextField.CENTER);
		Tseven2.setHorizontalAlignment(JTextField.CENTER);
		Tseven3.setHorizontalAlignment(JTextField.CENTER);
		temp7.add(Tseven1);
		temp7.add(Tseven2);
		temp7.add(Tseven3);
		JPanel temp8 = new JPanel(new GridLayout(1, 3));
		Teight1 = new JTextField();
		Teight2 = new JTextField();
		Teight3 = new JTextField();
		Teight1.setHorizontalAlignment(JTextField.CENTER);
		Teight2.setHorizontalAlignment(JTextField.CENTER);
		Teight3.setHorizontalAlignment(JTextField.CENTER);
		temp8.add(Teight1);
		temp8.add(Teight2);
		temp8.add(Teight3);
		JPanel temp9 = new JPanel(new GridLayout(1, 3));
		Tnine1 = new JTextField();
		Tnine2 = new JTextField();
		Tnine3 = new JTextField();
		Tnine1.setHorizontalAlignment(JTextField.CENTER);
		Tnine2.setHorizontalAlignment(JTextField.CENTER);
		Tnine3.setHorizontalAlignment(JTextField.CENTER);
		temp9.add(Tnine1);
		temp9.add(Tnine2);
		temp9.add(Tnine3);
		
		// Moisture Fields
		JPanel moist1 = new JPanel(new GridLayout(1, 3));
		Mone1 = new JTextField();
		Mone2 = new JTextField();
		Mone3 = new JTextField();
		Mone1.setHorizontalAlignment(JTextField.CENTER);
		Mone2.setHorizontalAlignment(JTextField.CENTER);
		Mone3.setHorizontalAlignment(JTextField.CENTER);
		moist1.add(Mone1);
		moist1.add(Mone2);
		moist1.add(Mone3);
		JPanel moist2 = new JPanel(new GridLayout(1, 3));
		Mtwo1 = new JTextField();
		Mtwo2 = new JTextField();
		Mtwo3 = new JTextField();
		Mtwo1.setHorizontalAlignment(JTextField.CENTER);
		Mtwo2.setHorizontalAlignment(JTextField.CENTER);
		Mtwo3.setHorizontalAlignment(JTextField.CENTER);
		moist2.add(Mtwo1);
		moist2.add(Mtwo2);
		moist2.add(Mtwo3);
		JPanel moist3 = new JPanel(new GridLayout(1, 3));
		Mthree1 = new JTextField();
		Mthree2 = new JTextField();
		Mthree3 = new JTextField();
		Mthree1.setHorizontalAlignment(JTextField.CENTER);
		Mthree2.setHorizontalAlignment(JTextField.CENTER);
		Mthree3.setHorizontalAlignment(JTextField.CENTER);
		moist3.add(Mthree1);
		moist3.add(Mthree2);
		moist3.add(Mthree3);
		JPanel moist4 = new JPanel(new GridLayout(1, 3));
		Mfour1 = new JTextField();
		Mfour2 = new JTextField();
		Mfour3 = new JTextField();
		Mfour1.setHorizontalAlignment(JTextField.CENTER);
		Mfour2.setHorizontalAlignment(JTextField.CENTER);
		Mfour3.setHorizontalAlignment(JTextField.CENTER);
		moist4.add(Mfour1);
		moist4.add(Mfour2);
		moist4.add(Mfour3);
		JPanel moist5 = new JPanel(new GridLayout(1, 3));
		Mfive1 = new JTextField();
		Mfive2 = new JTextField();
		Mfive3 = new JTextField();
		Mfive1.setHorizontalAlignment(JTextField.CENTER);
		Mfive2.setHorizontalAlignment(JTextField.CENTER);
		Mfive3.setHorizontalAlignment(JTextField.CENTER);
		moist5.add(Mfive1);
		moist5.add(Mfive2);
		moist5.add(Mfive3);
		JPanel moist6 = new JPanel(new GridLayout(1, 3));
		Msix1 = new JTextField();
		Msix2 = new JTextField();
		Msix3 = new JTextField();
		Msix1.setHorizontalAlignment(JTextField.CENTER);
		Msix2.setHorizontalAlignment(JTextField.CENTER);
		Msix3.setHorizontalAlignment(JTextField.CENTER);
		moist6.add(Msix1);
		moist6.add(Msix2);
		moist6.add(Msix3);
		JPanel moist7 = new JPanel(new GridLayout(1, 3));
		Mseven1 = new JTextField();
		Mseven2 = new JTextField();
		Mseven3 = new JTextField();
		Mseven1.setHorizontalAlignment(JTextField.CENTER);
		Mseven2.setHorizontalAlignment(JTextField.CENTER);
		Mseven3.setHorizontalAlignment(JTextField.CENTER);
		moist7.add(Mseven1);
		moist7.add(Mseven2);
		moist7.add(Mseven3);
		JPanel moist8 = new JPanel(new GridLayout(1, 3));
		Meight1 = new JTextField();
		Meight2 = new JTextField();
		Meight3 = new JTextField();
		Meight1.setHorizontalAlignment(JTextField.CENTER);
		Meight2.setHorizontalAlignment(JTextField.CENTER);
		Meight3.setHorizontalAlignment(JTextField.CENTER);
		moist8.add(Meight1);
		moist8.add(Meight2);
		moist8.add(Meight3);
		JPanel moist9 = new JPanel(new GridLayout(1, 3));
		Mnine1 = new JTextField();
		Mnine2 = new JTextField();
		Mnine3 = new JTextField();
		Mnine1.setHorizontalAlignment(JTextField.CENTER);
		Mnine2.setHorizontalAlignment(JTextField.CENTER);
		Mnine3.setHorizontalAlignment(JTextField.CENTER);
		moist9.add(Mnine1);
		moist9.add(Mnine2);
		moist9.add(Mnine3);
		
		// Note Fields
		notes1 = new JTextField();
		notes2 = new JTextField();
		notes3 = new JTextField();
		notes4 = new JTextField();
		notes5 = new JTextField();
		notes6 = new JTextField();
		notes7 = new JTextField();
		notes8 = new JTextField();
		notes9 = new JTextField();
		
		// Watered CheckBoxes
		JPanel watered1 = new JPanel(new GridLayout(1, 2));
		Wone1 = new JCheckBox("Yes");
		JCheckBox Wone2 = new JCheckBox("No");
		watered1.add(Wone1);
		watered1.add(Wone2);	
		Wone1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wone2.setSelected(false);
            }
        });
		Wone2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wone1.setSelected(false);
            }
        });		
		JPanel watered2 = new JPanel(new GridLayout(1, 2));
		Wtwo1 = new JCheckBox("Yes");
		JCheckBox Wtwo2 = new JCheckBox("No");
		watered2.add(Wtwo1);
		watered2.add(Wtwo2);
		Wtwo1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wtwo2.setSelected(false);
            }
        });
		Wtwo2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wtwo1.setSelected(false);
            }
        });
		JPanel watered3 = new JPanel(new GridLayout(1, 2));
		Wthree1 = new JCheckBox("Yes");
		JCheckBox Wthree2 = new JCheckBox("No");
		watered3.add(Wthree1);
		watered3.add(Wthree2);
		Wthree1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wthree2.setSelected(false);
            }
        });
		Wthree2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wthree1.setSelected(false);
            }
        });
		JPanel watered4 = new JPanel(new GridLayout(1, 2));
		Wfour1 = new JCheckBox("Yes");
		JCheckBox Wfour2 = new JCheckBox("No");
		watered4.add(Wfour1);
		watered4.add(Wfour2);
		Wfour1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wfour2.setSelected(false);
            }
        });
		Wfour2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wfour1.setSelected(false);
            }
        });
		JPanel watered5 = new JPanel(new GridLayout(1, 2));
		Wfive1 = new JCheckBox("Yes");
		JCheckBox Wfive2 = new JCheckBox("No");
		watered5.add(Wfive1);
		watered5.add(Wfive2);
		Wfive1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wfive2.setSelected(false);
            }
        });
		Wfive2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wfive1.setSelected(false);
            }
        });
		JPanel watered6 = new JPanel(new GridLayout(1, 2));
		Wsix1 = new JCheckBox("Yes");
		JCheckBox Wsix2 = new JCheckBox("No");
		watered6.add(Wsix1);
		watered6.add(Wsix2);
		Wsix1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wsix2.setSelected(false);
            }
        });
		Wsix2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wsix1.setSelected(false);
            }
        });
		JPanel watered7 = new JPanel(new GridLayout(1, 2));
		Wseven1 = new JCheckBox("Yes");
		JCheckBox Wseven2 = new JCheckBox("No");
		watered7.add(Wseven1);
		watered7.add(Wseven2);
		Wseven1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wseven2.setSelected(false);
            }
        });
		Wseven2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wseven1.setSelected(false);
            }
        });
		JPanel watered8 = new JPanel(new GridLayout(1, 2));
		Weight1 = new JCheckBox("Yes");
		JCheckBox Weight2 = new JCheckBox("No");
		watered8.add(Weight1);
		watered8.add(Weight2);
		Weight1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Weight2.setSelected(false);
            }
        });
		Weight2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Weight1.setSelected(false);
            }
        });
		JPanel watered9 = new JPanel(new GridLayout(1, 2));
		Wnine1 = new JCheckBox("Yes");
		JCheckBox Wnine2 = new JCheckBox("No");
		watered9.add(Wnine1);
		watered9.add(Wnine2);
		Wnine1.addActionListener(new ActionListener() {		
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wnine2.setSelected(false);
            }
        });
		Wnine2.addActionListener(new ActionListener() {	
            @Override
            public void actionPerformed(ActionEvent ae) {
            		Wnine1.setSelected(false);
            }
        });
		
		// Title Labels
		dataEntries.add(hole);
		dataEntries.add(tempTitles);
		dataEntries.add(moisTitles);
		dataEntries.add(watered);
		dataEntries.add(notes);
		
		// Hole One
		green1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes1.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green1);
		dataEntries.add(temp1);
		dataEntries.add(moist1);
		dataEntries.add(watered1);
		dataEntries.add(notes1);
		// Hole Two
		green2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes2.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green2);
		dataEntries.add(temp2);
		dataEntries.add(moist2);
		dataEntries.add(watered2);
		dataEntries.add(notes2);
		// Hole Three
		green3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green3);
		dataEntries.add(temp3);
		dataEntries.add(moist3);
		dataEntries.add(watered3);
		dataEntries.add(notes3);
		// Hole Four
		green4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes4.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green4);
		dataEntries.add(temp4);
		dataEntries.add(moist4);
		dataEntries.add(watered4);
		dataEntries.add(notes4);
		// Hole Five
		green5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes5.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green5);
		dataEntries.add(temp5);
		dataEntries.add(moist5);
		dataEntries.add(watered5);
		dataEntries.add(notes5);
		// Hole Six
		green6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes6.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green6);
		dataEntries.add(temp6);
		dataEntries.add(moist6);
		dataEntries.add(watered6);
		dataEntries.add(notes6);
		// Hole Seven
		green7.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp7.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist7.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered7.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes7.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green7);
		dataEntries.add(temp7);
		dataEntries.add(moist7);
		dataEntries.add(watered7);
		dataEntries.add(notes7);
		// Hole Eight
		green8.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp8.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist8.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered8.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes8.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green8);
		dataEntries.add(temp8);
		dataEntries.add(moist8);
		dataEntries.add(watered8);
		dataEntries.add(notes8);
		// Hole Nine
		green9.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		temp9.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		moist9.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		watered9.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		notes9.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dataEntries.add(green9);
		dataEntries.add(temp9);
		dataEntries.add(moist9);
		dataEntries.add(watered9);
		dataEntries.add(notes9);
		
		add(dataEntries);
		
	}
	
	public String getDataVals() {
		
		// Green# ~ wateredBOOL ~ temps ~ moist ~ notes + NewGreen#... <> New Lap ...
		
		String dataVals;
		
		dataVals = "Green 1~" + Wone1.isSelected() + "~" + Tone1.getText() + "~" + Tone2.getText() + "~" + Tone3.getText() + "~" + Mone1.getText() + "~" + Mone2.getText() + "~" + Mone3.getText() + "~" + notes1.getText() + "+"; 
		dataVals = dataVals + "Green 2~" + Wtwo1.isSelected() + "~" + Ttwo1.getText() + "~" + Ttwo2.getText() + "~" + Ttwo3.getText() + "~" + Mtwo1.getText() + "~" + Mtwo2.getText() + "~" + Mtwo3.getText() + "~" + notes2.getText() + "+";
		dataVals = dataVals + "Green 3~" + Wthree1.isSelected() + "~" + Tthree1.getText() + "~" + Tthree2.getText() + "~" + Tthree3.getText() + "~" + Mthree1.getText() + "~" + Mthree2.getText() + "~" + Mthree3.getText() + "~" + notes3.getText() + "+";
		dataVals = dataVals + "Green 4~" + Wfour1.isSelected() + "~" + Tfour1.getText() + "~" + Tfour2.getText() + "~" + Tfour3.getText() + "~" + Mfour1.getText() + "~" + Mfour2.getText() + "~" + Mfour3.getText() + "~" + notes4.getText() + "+";
		dataVals = dataVals + "Green 5~" + Wfive1.isSelected() + "~" + Tfive1.getText() + "~" + Tfive2.getText() + "~" + Tfive3.getText() + "~" + Mfive1.getText() + "~" + Mfive2.getText() + "~" + Mfive3.getText() + "~" + notes5.getText() + "+";
		dataVals = dataVals + "Green 6~" + Wsix1.isSelected() + "~" + Tsix1.getText() + "~" + Tsix2.getText() + "~" + Tsix3.getText() + "~" + Msix1.getText() + "~" + Msix2.getText() + "~" + Msix3.getText() + "~" + notes6.getText() + "+";
		dataVals = dataVals + "Green 7~" + Wseven1.isSelected() + "~" + Tseven1.getText() + "~" + Tseven2.getText() + "~" + Tseven3.getText() + "~" + Mseven1.getText() + "~" + Mseven2.getText() + "~" + Mseven3.getText() + "~" + notes7.getText() + "+";
		dataVals = dataVals + "Green 8~" + Weight1.isSelected() + "~" + Teight1.getText() + "~" + Teight2.getText() + "~" + Teight3.getText() + "~" + Meight1.getText() + "~" + Meight2.getText() + "~" + Meight3.getText() + "~" + notes8.getText() + "+";
		dataVals = dataVals + "Green 9~" + Wnine1.isSelected() + "~" + Tnine1.getText() + "~" + Tnine2.getText() + "~" + Tnine3.getText() + "~" + Mnine1.getText() + "~" + Mnine2.getText() + "~" + Mnine3.getText() + "~" + notes9.getText() + "<>";		
		
		return dataVals;
	}
	
}
