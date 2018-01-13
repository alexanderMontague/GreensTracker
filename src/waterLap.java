// Alex Montague 2018
// Class that will hold each lap/green data that will be used in the waterSession collection

import java.util.*;

public class waterLap {

	public String lapNum;
	public String lapStartTime;			// Indexes
	public ArrayList<String> greenNums; 	// 0 - 8
	public ArrayList<String> watered;	// 0 - 8
	public ArrayList<String> temps;      // 0 - 26
	public ArrayList<String> moistures;  // 0 - 26
	public ArrayList<String> notes;		// 0 - 8
	
	public waterLap() {					// Default constructor
		this.lapNum = "NULL";
		this.lapStartTime = "NULL";
		this.greenNums = null;
		this.watered = null;
		this.temps = null;
		this.moistures = null;
		this.notes = null;
	}
										// Specified Constructor
	public waterLap(String lapNum, String lapStartTime, ArrayList<String> greenNums, ArrayList<String> watered, ArrayList<String> temps, ArrayList<String> moistures, ArrayList<String> notes) {
		this.lapNum = lapNum;
		this.lapStartTime = lapStartTime;
		this.greenNums = greenNums;
		this.watered = watered;
		this.temps = temps;
		this.moistures = moistures;
		this.notes = notes;
	}
	
}
